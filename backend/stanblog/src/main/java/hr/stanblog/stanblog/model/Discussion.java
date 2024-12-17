package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "creatorUserId")
    AppUser creatorUser;

    String title;
    String description;
    @ManyToOne
    @JoinColumn(name = "apartmentBuildingId")
    ApartmentBuilding apartmentBuilding;

    @OneToMany
    List<UserDiscussion> userDiscussions;

    @OneToMany
    List<Comment> comments;

    @OneToOne
    Voting voting;

    public Discussion(AppUser creatorUserId, String title, String description, ApartmentBuilding apartmentBuildingId) {
        this.creatorUser = creatorUserId;
        this.title = title;
        this.description = description;
        this.apartmentBuilding = apartmentBuildingId;
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
        return creatorUser;
    }

    public void setCreatorUserId(AppUser creatorUserId) {
        this.creatorUser = creatorUserId;
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
        return apartmentBuilding;
    }

    public void setApartmentBuildingId(ApartmentBuilding apartmentBuildingId) {
        this.apartmentBuilding = apartmentBuildingId;
    }
}
