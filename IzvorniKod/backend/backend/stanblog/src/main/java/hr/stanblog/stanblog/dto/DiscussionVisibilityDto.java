package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.Discussion;
import jakarta.persistence.*;

public class DiscussionVisibilityDto {
    private Long userId;

    private boolean canUserSeeDiscussion;
    private boolean canUserParticipateInDiscussion;

    public DiscussionVisibilityDto(Long userId, boolean canUserSeeDiscussion, boolean canUserParticipateInDiscussion) {
        this.userId = userId;
        this.canUserSeeDiscussion = canUserSeeDiscussion;
        this.canUserParticipateInDiscussion = canUserParticipateInDiscussion;
    }

    public DiscussionVisibilityDto() {

    }

    public Long getAppUser() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean getCanUserSeeDiscussion() {
        return canUserSeeDiscussion;
    }

    public void setCanUserSeeDiscussion(boolean canUserSeeDiscussion) {
        this.canUserSeeDiscussion = canUserSeeDiscussion;
    }

    public boolean getCanUserParticipateInDiscussion() {
        return canUserParticipateInDiscussion;
    }

    public void setCanUserParticipateInDiscussion(boolean canUserParticipateInDiscussion) {
        this.canUserParticipateInDiscussion = canUserParticipateInDiscussion;
    }
}
