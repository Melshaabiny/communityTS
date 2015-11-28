package models;

/**
 * Created by MoustafaElshaabiny on 11/24/15.
 */
import com.avaje.ebean.Model;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;

@Table(name="users")
@Entity
public class User extends Model {
    @Id
    public Long id;

    public String name;
    public String username;
    public String password_hash;

    // Finder object for easier quering
    public static Finder<Long, User> find = new Finder(Long.class, User.class);

    // NOT FOR PRODUCTION - must ensure this is a valid user first. I have not done that.
    public boolean authenticate(String password){
        return BCrypt.checkpw(password, this.password_hash);
    }

    public static User createUser(String name, String username, String password){

        // requirements for username and password
        if(password==null || username==null || password.length()<8){
            return null;
        }

        // create a password hash
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        // create a new user instance in the database
        // assign the username and passwordHash to the newly created user
        User user = new User();
        user.name = name;
        user.username = username;
        user.password_hash = passwordHash;

        return user;
    }
}
