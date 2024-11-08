package hr.stanblog.stanblog.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserApartmentBuilding  {
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    AppUser user;

    @ManyToOne
    @JoinColumn(name = "apartmentBuildingId")
    ApartmentBuilding apartmentBuilding;

    @Column(name = "isRepresentative")
    boolean isRepresentative;


    public UserApartmentBuilding(AppUser user, ApartmentBuilding apartmentBuilding, boolean isRepresentative) {
        this.user = user;
        this.apartmentBuilding = apartmentBuilding;
        this.isRepresentative = isRepresentative;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return this.user;
    }

    public void setUser(AppUser user) {
        this.user = user;
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
