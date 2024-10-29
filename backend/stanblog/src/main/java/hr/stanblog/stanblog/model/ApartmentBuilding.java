package hr.stanblog.stanblog.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ApartmentBuilding {
    @Id
    Long id;

    String address;

    int zipCode;

    String city;

    int numberOfIndividualApartments;
    
}
