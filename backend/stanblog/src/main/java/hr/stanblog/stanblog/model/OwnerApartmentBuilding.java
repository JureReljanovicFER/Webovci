package hr.stanblog.stanblog.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OwnerApartmentBuilding  {
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_owner_id")
    ApartmentOwner apartmentOwner;

    @ManyToOne
    @JoinColumn(name = "apartment_building_id")
    ApartmentBuilding apartmentBuilding;

    @Column(name = "is_representative")
    boolean isRepresentative;


    public OwnerApartmentBuilding(ApartmentOwner apartmentOwner, ApartmentBuilding apartmentBuilding, boolean isRepresentative) {
        this.apartmentOwner = apartmentOwner;
        this.apartmentBuilding = apartmentBuilding;
        this.isRepresentative = isRepresentative;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApartmentOwner getApartmentOwner() {
        return this.apartmentOwner;
    }

    public void setApartmentOwner(ApartmentOwner apartmentOwner) {
        this.apartmentOwner = apartmentOwner;
    }

    public ApartmentBuilding getApartmentBuilding() {
        return this.apartmentBuilding;
    }

    public void setApartmentBuilding(ApartmentBuilding apartmentBuilding) {
        this.apartmentBuilding = apartmentBuilding;
    }

    public boolean isIsRepresentative() {
        return this.isRepresentative;
    }

    public boolean getIsRepresentative() {
        return this.isRepresentative;
    }

    public void setIsRepresentative(boolean isRepresentative) {
        this.isRepresentative = isRepresentative;
    }
    

}
