package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.DiscussionVisibility;
import jakarta.persistence.*;

import java.util.List;


public class DiscussionBasicDto {
    private Long id;
    private Long creatorUserId;

    private String title;
    private String description;

    private Long apartmentBuildingId;
    private List<DiscussionVisibilityDto> discussionVisibilities;

    public DiscussionBasicDto(Long id, Long creatorUserId, String title, String description, Long apartmentBuildingId, List<DiscussionVisibilityDto> discussionVisibilities) {
        this.id = id;
        this.creatorUserId = creatorUserId;
        this.title = title;
        this.description = description;
        this.apartmentBuildingId = apartmentBuildingId;
        this.discussionVisibilities = discussionVisibilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DiscussionVisibilityDto> getDiscussionVisibilities() {
        return discussionVisibilities;
    }

    public void setDiscussionVisibilities(List<DiscussionVisibilityDto> discussionVisibilities) {
        this.discussionVisibilities = discussionVisibilities;
    }

    public DiscussionBasicDto() {
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Long creatorUserId) {
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

    public Long getApartmentBuildingId() {
        return apartmentBuildingId;
    }

    public void setApartmentBuildingId(Long apartmentBuildingId) {
        this.apartmentBuildingId = apartmentBuildingId;
    }

    public List<DiscussionVisibilityDto> getVisibilities() {
        return discussionVisibilities;
    }

    public void setVisibilities(List<DiscussionVisibilityDto> discussionVisibilities) {
        this.discussionVisibilities = discussionVisibilities;
    }

}
