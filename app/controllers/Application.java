package controllers;

import models.User;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }


}
