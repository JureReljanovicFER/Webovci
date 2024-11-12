package hr.stanblog.stanblog.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ApartmentBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String address;

    int zipCode;

    String city;

    int numberOfIndividualApartments;


    public ApartmentBuilding(String address, int zipCode, String city, int numberOfIndividualApartments) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.numberOfIndividualApartments = numberOfIndividualApartments;
    }

    public ApartmentBuilding() {

    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfIndividualApartments() {
        return this.numberOfIndividualApartments;
    }

    public void setNumberOfIndividualApartments(int numberOfIndividualApartments) {
        this.numberOfIndividualApartments = numberOfIndividualApartments;
    }
    
}
