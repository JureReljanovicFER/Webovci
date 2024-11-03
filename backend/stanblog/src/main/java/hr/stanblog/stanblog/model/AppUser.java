package hr.stanblog.stanblog.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@TABLE
public class AppUser {
    @Id
    Long id;

    String firstName;

    String lastName;

    String email;

    UserRole userRole;

    public AppUser( String firstName, String lastName, String email, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }
        

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
}
