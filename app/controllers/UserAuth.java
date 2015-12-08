package controllers;

import models.User;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import static play.data.Form.form;

/**
 * Created by MoustafaElshaabiny
 */

public class UserAuth extends Controller {

    public Result index() {
        return ok(views.html.userauth.index.render());
    }

    @Security.Authenticated(SecAuth.class)
    public Result profile(String usrname){
        User user = User.find.where().eq("username", usrname).findUnique();
        return ok(views.html.userauth.profile.render(user));
    }

    public Result login() {
        // Get username and password from the login form
        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        // Find the user's information in the database
        User user = User.find.where().eq("username", username).findUnique();

        if (user != null && user.authenticate(password)) {
            session().clear();
            session("user_name", user.username);
            flash("success", "Welcome back " + user.username);
        }
        else {
            flash("error", "Invalid login. Check your username and password.");
        }

        return redirect(routes.UserAuth.profile(user.username));
    }

    public Result signup() {
        // Get username and password from the signup form
        DynamicForm userForm = form().bindFromRequest();
        String name = userForm.data().get("name");
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        // Create a new user with the username and password obtained above
        User user = User.createUser(name, username, password);

        if (user == null) {
            flash("error", "Invalid user");
            return redirect(routes.Application.index());
        }

        user.save();

        flash("success", "Welcome new user " + user.username);
        session().clear();
        session("user_name", user.username);
        return redirect(routes.Application.index());
    }
}