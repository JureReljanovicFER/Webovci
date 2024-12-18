package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "creatorUserId")
    AppUser creatorUser;

    String title;
    String description;
    @ManyToOne
    @JoinColumn(name = "apartmentBuildingId")
    ApartmentBuilding apartmentBuilding;

    public AppUser getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(AppUser creatorUser) {
        this.creatorUser = creatorUser;
    }

    public ApartmentBuilding getApartmentBuilding() {
        return apartmentBuilding;
    }

    public void setApartmentBuilding(ApartmentBuilding apartmentBuilding) {
        this.apartmentBuilding = apartmentBuilding;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discussion(AppUser creatorUser, String title, String description, ApartmentBuilding apartmentBuilding) {
        this.creatorUser = creatorUser;
        this.title = title;
        this.description = description;
        this.apartmentBuilding = apartmentBuilding;
    }

    public Discussion() {
    }

}
