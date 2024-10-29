package hr.stanblog.stanblog.model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
class Admin {
    @Id
    Long id;

    String email;

    String password;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    
}   