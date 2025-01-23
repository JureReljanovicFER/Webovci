package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

@Entity
@Table
public class DiscussionVisibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "discussionId")
    Discussion discussion;

    @ManyToOne
    AppUser appUser;

    private boolean canUserSee;
    private boolean canUserParticipate;

    public DiscussionVisibility(Discussion discussion, AppUser appUser, boolean canUserSee, boolean canUserParticipate, boolean canUserSeeDiscussion, boolean canUserParticipateInDiscussion) {
        this.discussion = discussion;
        this.appUser = appUser;
        this.canUserSee = canUserSee;
        this.canUserParticipate = canUserParticipate;
        this.canUserSeeDiscussion = canUserSeeDiscussion;
        this.canUserParticipateInDiscussion = canUserParticipateInDiscussion;
    }

    public boolean isCanUserSee() {
        return canUserSee;
    }

    public void setCanUserSee(boolean canUserSee) {
        this.canUserSee = canUserSee;
    }

    public boolean isCanUserParticipate() {
        return canUserParticipate;
    }

    public void setCanUserParticipate(boolean canUserParticipate) {
        this.canUserParticipate = canUserParticipate;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    boolean canUserSeeDiscussion;
    boolean canUserParticipateInDiscussion;

    public DiscussionVisibility(Discussion discussion, AppUser appUser, boolean canUserSeeDiscussion, boolean canUserParticipateInDiscussion) {
        this.discussion = discussion;
        this.appUser = appUser;
        this.canUserSeeDiscussion = canUserSeeDiscussion;
        this.canUserParticipateInDiscussion = canUserParticipateInDiscussion;
    }

    public DiscussionVisibility() {
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
