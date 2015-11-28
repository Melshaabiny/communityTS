package controllers;

import javafx.beans.property.ReadOnlyStringProperty;
import models.User;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import static play.data.Form.form;
import play.mvc.*;
import views.html.*;

/**
 * Created by MoustafaElshaabiny
 */

public class UserAuth extends Controller {

    public Result index() {
        return ok(views.html.userauth.index.render());
    }

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
            session("user_id", user.id.toString());
            flash("success", "Welcome back " + user.username);
        }
        else {
            flash("error", "Invalid login. Check your username and password.");
        }

        return redirect(routes.Application.index());
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

//        flash("success", "Welcome new user " + user.username);
//        session("user_id", user.id.toString());
        return redirect(routes.Application.index());
    }
}