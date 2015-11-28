package controllers;

import models.User;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
   @Security.Authenticated(SecAuth.class)
    public Result index() {
        return ok(index.render(
                User.find.byId(request().username())
        ));
    }
    public Result indexUnAuth(){
        return ok(views.html.unauth.index.render());
    }
}
