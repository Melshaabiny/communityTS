package controllers;

import models.Gadget;
import models.ToolType;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Bishwo on 12/7/15.
 */
public class ToolTypes extends Controller {

    //list all of the tooltypes
    public Result index() {
        List<ToolType> tooltypes = ToolType.find.all();
        return ok(views.html.tooltypes.index.render(tooltypes));

    }

   // @Security.Authenticated(SecAuth.class)
    public Result create() {
        ToolType tooltype = Form.form(ToolType.class).bindFromRequest().get();
        tooltype.save();
        flash("success", "Saved new ToolType: " + tooltype.name);
        return redirect(routes.ToolTypes.index());
    }

    public Result show(Long id) {
        ToolType tooltype = ToolType.find.byId(id);
        if(tooltype == null) {
            return notFound("not found");

        } else {
            List<Gadget> gadgets = tooltype.gadgetList;
            return ok(views.html.tooltypes.show.render(tooltype, gadgets));
        }
    }
}
