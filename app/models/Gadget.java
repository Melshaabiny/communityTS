package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gadget extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String title;

    public String body;
    public Long rating;
    public Long comment;
    public String category;

    @ManyToOne
    public ToolType tooltype;

    public static Finder<Long, Gadget> find = new Finder<Long, Gadget>(Gadget.class);
}
