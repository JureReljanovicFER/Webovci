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

    String description;
    @ManyToOne
    @JoinColumn(name = "apartmentBuildingId")
    ApartmentBuilding apartmentBuildingId;
    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL, orphanRemoval = true)
    UserDiscussion userDiscussion;



}
