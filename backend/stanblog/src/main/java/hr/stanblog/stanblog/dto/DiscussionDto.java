package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.*;

import java.util.List;


public class DiscussionDto {
        private Long id;

        private UserDto creatorUser;

        private String title;
        private String description;

        private ApartmentBuildingDto apartmentBuilding;

        private List<DiscussionVisibilityDto> discussionVisibilities;

        private VotingDto voting;

        private List<CommentDto> comments;

        public DiscussionDto(Long id, UserDto creatorUser, String title, String description, ApartmentBuildingDto apartmentBuilding, List<DiscussionVisibilityDto> discussionVisibilities, VotingDto voting, List<CommentDto> comments) {
                this.id = id;
                this.creatorUser = creatorUser;
                this.title = title;
                this.description = description;
                this.apartmentBuilding = apartmentBuilding;
                this.discussionVisibilities = discussionVisibilities;
                this.voting = voting;
                this.comments = comments;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public UserDto getCreatorUser() {
                return creatorUser;
        }

        public void setCreatorUser(UserDto creatorUser) {
                this.creatorUser = creatorUser;
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

        public ApartmentBuildingDto getApartmentBuilding() {
                return apartmentBuilding;
        }

        public void setApartmentBuilding(ApartmentBuildingDto apartmentBuilding) {
                this.apartmentBuilding = apartmentBuilding;
        }

        public List<DiscussionVisibilityDto> getDiscussionVisibilities() {
                return discussionVisibilities;
        }

        public void setDiscussionVisibilities(List<DiscussionVisibilityDto> discussionVisibilities) {
                this.discussionVisibilities = discussionVisibilities;
        }

        public VotingDto getVoting() {
                return voting;
        }

        public void setVoting(VotingDto voting) {
                this.voting = voting;
        }

        public List<CommentDto> getComments() {
                return comments;
        }

        public void setComments(List<CommentDto> comments) {
                this.comments = comments;
        }
}
