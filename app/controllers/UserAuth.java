package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by MoustafaElshaabiny on 11/24/15.
 */
public class UserAuth extends Controller {

    public Result index() {
        return ok(views.html.userauth.index.render());
    }

    public Result addUser() {
        User user = Form.form(User.class).bindFromRequest().get();
        user.save();
        return redirect(routes.Application.index());
    }
}
