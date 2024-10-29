package hr.stanblog.stanblog.model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
class Admin {
    @Id
    Long id;

    String email;

    String password;
}   