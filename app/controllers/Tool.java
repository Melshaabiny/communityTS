package controllers;

import models.Gadget;
import play.data.Form;
//import play.mvc.Controller;
import play.mvc.*;

import java.util.List;

/**
* This is the Tool Controller. This is where we implement all of the Action
 * methods related to operations on my Tool feature. I am storing tools
 * using a model called Gadget.
 */
public class Tool extends Controller {
    // Route: GET /tools
    //  Lists all tools.
    public Result index() {
        List<Gadget> gadgets = Gadget.find.all();
        return ok(views.html.tool.index.render(gadgets));
    }

    // Route: GET/tools/new
    // Displays the form for creating a tool.
    public Result form() {
        return ok(views.html.tool.form.render());
    }

    // Route: POST /tools
    //  Creates a tool from user request input.
    public Result create() {
        //Retrieve user input and save a new gadget
        Gadget gadget = Form.form(Gadget.class).bindFromRequest().get();
        gadget.save();

        // redirect to the newly created tool
        return redirect(routes.Tool.show(gadget.id));
    }

    //Route: GET /tools/:id
    //  Shows the tool 'id'
    public Result show(Long id) {
        // Query the database for a tool with this id
        Gadget gadget = Gadget.find.byId(id);

        // If the article doesn't exist, then respond with a 404.
        if (gadget == null)
            return notFound("Not Found\n");
        else
            return ok(views.html.tool.show.render(gadget));
    }
}
