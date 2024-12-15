package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

@Entity
@Table
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "creatorUserId")
    AppUser creatorUserId;

    String title;
    String description;
    @ManyToOne
    @JoinColumn(name = "apartmentBuildingId")
    ApartmentBuilding apartmentBuildingId;


    public Discussion(AppUser creatorUserId, String title, String description, ApartmentBuilding apartmentBuildingId) {
        this.creatorUserId = creatorUserId;
        this.title = title;
        this.description = description;
        this.apartmentBuildingId = apartmentBuildingId;
    }

    public Discussion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(AppUser creatorUserId) {
        this.creatorUserId = creatorUserId;
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

    public ApartmentBuilding getApartmentBuildingId() {
        return apartmentBuildingId;
    }

    public void setApartmentBuildingId(ApartmentBuilding apartmentBuildingId) {
        this.apartmentBuildingId = apartmentBuildingId;
    }
}
