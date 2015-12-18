package controllers;

import models.Gadget;
import models.ToolType;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.data.Form.form;

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
        List<ToolType> tooltypes = ToolType.find.all();
        return ok(views.html.tool.index.render(gadgets, tooltypes));
    }

    // Route: GET/tools/new
    // Displays the form for creating a tool.
//    public Result form() {
//        return ok(views.html.tool.form.render());
//    }

    // Route: POST /tools
    //  Creates a tool from user request input.
//    public Result create() {
//        //Retrieve user input and save a new gadget
//        Gadget gadget = Form.form(Gadget.class).bindFromRequest().get();
//        gadget.save();
//
//        // redirect to the newly created tool
//        return redirect(routes.Tool.show(gadget.id));
//    }



    public Result create() {
        Form<Gadget> gadgetForm = form(Gadget.class).bindFromRequest();

        String tooltype_id = gadgetForm.data().get("tooltype_id");

        ToolType tooltype = ToolType.find.byId(Long.parseLong(tooltype_id));
        if(tooltype == null) {
            flash("error", "Invalid ToolType: " + tooltype_id + " Try again.");
            return redirect(routes.Tool.index());
        }

        Gadget gadget = gadgetForm.get();
        gadget.tooltype = tooltype;
        gadget.save();
        flash("success", "Saved new Tool: " + gadget.title);
        return redirect(routes.Tool.index());
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
