package models;

/**
 * Created by MoustafaElshaabiny on 11/24/15.
 */
import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {
    @Id
    public String id;

    public String name;
}
