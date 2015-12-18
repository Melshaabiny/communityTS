package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Gadget extends Model {
    @Id
    public Long id;
    public String title;
    public String body;

    @Constraints.Required
    public Long rating;
    public List<Comment> comments;

    @ManyToOne
    public ToolType tooltype;

    public static Finder<Long, Gadget> find = new Finder<Long, Gadget>(Gadget.class);
}
