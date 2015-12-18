package models;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Created by Bishwo on 12/17/15.
 */
@Entity
public class Comment extends Model {
        @Id
        public Long id;

        @Constraints.Required
        //public String title;

        public String body;
        public Long comment;

       // @ManyToOne
        //public ToolType tooltype;

        public static Finder<Long, Comment> find = new Finder<Long, Comment>(Comment.class);
    }
