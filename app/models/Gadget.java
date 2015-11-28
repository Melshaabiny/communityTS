package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gadget extends Model {
    @Id
    public Long id;

    public String title;
    public String body;
    public Long rating;
    public String category;

    public static Finder<Long, Gadget> find = new Finder<Long, Gadget>(Gadget.class);
}
