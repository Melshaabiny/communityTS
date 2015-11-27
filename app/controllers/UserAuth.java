package controllers;

import models.User;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import static play.data.Form.form;
import play.mvc.*;
import views.html.*;

/**
 * Created by MoustafaElshaabiny on 11/24/15.
 */

public class UserAuth extends Controller {

    public Result index() {
        return ok(views.html.userauth.index.render());
    }

    public Result login() {
        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = User.find.where().eq("username", username).findUnique();

        if (user != null && user.authenticate(password)) {
            session("user_id", user.id.toString());
            flash("success", "Welcome back " + user.username);
        } else {
            flash("error", "Invalid login. Check your username and password.");
        }

        return redirect(routes.Application.index());
    }
    //@Security.Authenticated(SecAuth.class)
    public Result signup() {
        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = User.createUser(username, password);

        if (user == null) {
            flash("error", "Invalid user");
            return redirect(routes.Application.index());
        }

        user.save();

        flash("success", "Welcome new user " + user.username);
        session("user_id", user.id.toString());
        return redirect(routes.Application.index());
    }
}