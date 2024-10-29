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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}   