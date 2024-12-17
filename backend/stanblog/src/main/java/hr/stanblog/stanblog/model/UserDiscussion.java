package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

@Entity
@Table
public class UserDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "discussionId")
    Discussion discussion;

    boolean canUserSeeDiscussion;
    boolean canUserParticipateInDiscussion;

    public UserDiscussion(Discussion discussion, boolean canUserSeeDiscussion, boolean canUserParticipateInDiscussion) {
        this.discussion = discussion;
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

    public Discussion getDiscussionId() {
        return discussion;
    }

    public void setDiscussionId(Discussion discussionId) {
        this.discussion = discussionId;
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
