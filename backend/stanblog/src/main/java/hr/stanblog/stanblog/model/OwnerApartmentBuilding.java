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

}
