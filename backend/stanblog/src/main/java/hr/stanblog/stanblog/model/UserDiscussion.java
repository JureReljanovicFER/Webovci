package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

@Entity
@Table
public class UserDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "userApartmentBuildingId")
    UserApartmentBuilding userApartmentBuildingId;
    @ManyToOne
    @JoinColumn(name = "discussionId")
    Discussion discussionId;

    boolean canUserSeeDiscussion;
    boolean canUserParticipateInDiscussion;

}
