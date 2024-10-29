package hr.stanblog.stanblog.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ApartmentOwner {
    @Id
    Long id;

    String firstName;

    String lastName;

    String email;

        
    
}
