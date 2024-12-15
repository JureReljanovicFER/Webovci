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

    public UserDiscussion(UserApartmentBuilding userApartmentBuildingId, Discussion discussionId, boolean canUserSeeDiscussion, boolean canUserParticipateInDiscussion) {
        this.userApartmentBuildingId = userApartmentBuildingId;
        this.discussionId = discussionId;
        this.canUserSeeDiscussion = canUserSeeDiscussion;
        this.canUserParticipateInDiscussion = canUserParticipateInDiscussion;
    }

    public UserDiscussion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserApartmentBuilding getUserApartmentBuildingId() {
        return userApartmentBuildingId;
    }

    public void setUserApartmentBuildingId(UserApartmentBuilding userApartmentBuildingId) {
        this.userApartmentBuildingId = userApartmentBuildingId;
    }

    public Discussion getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Discussion discussionId) {
        this.discussionId = discussionId;
    }

    public boolean isCanUserSeeDiscussion() {
        return canUserSeeDiscussion;
    }

    public void setCanUserSeeDiscussion(boolean canUserSeeDiscussion) {
        this.canUserSeeDiscussion = canUserSeeDiscussion;
    }

    public boolean isCanUserParticipateInDiscussion() {
        return canUserParticipateInDiscussion;
    }

    public void setCanUserParticipateInDiscussion(boolean canUserParticipateInDiscussion) {
        this.canUserParticipateInDiscussion = canUserParticipateInDiscussion;
    }
}
