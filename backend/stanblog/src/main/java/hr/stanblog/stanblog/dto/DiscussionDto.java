package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.AppUser;
import jakarta.persistence.*;


public class DiscussionDto {


        private AppUser creatorUserId;

        private String title;
        private String description;

        private ApartmentBuilding apartmentBuildingId;
        private Visibility[] visibilities;

        public DiscussionDto(AppUser creatorUserId, String title, String description, ApartmentBuilding apartmentBuildingId, Visibility[] visibilities) {
                this.creatorUserId = creatorUserId;
                this.title = title;
                this.description = description;
                this.apartmentBuildingId = apartmentBuildingId;
                this.visibilities = visibilities;
        }

        public DiscussionDto() {
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

        public Visibility[] getVisibilities() {
                return visibilities;
        }

        public void setVisibilities(Visibility[] visibilities) {
                this.visibilities = visibilities;
        }

        public class Visibility {
                private Long userId;
                private boolean canUserSee;
                private boolean canUserParticipate;

                public Visibility(Long userId, boolean canUserSee, boolean canUserParticipate) {
                        this.userId = userId;
                        this.canUserSee = canUserSee;
                        this.canUserParticipate = canUserParticipate;
                }

                public Visibility() {
                }

                public Long getUserId() {
                        return userId;
                }

                public void setUserId(Long userId) {
                        this.userId = userId;
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
        }




}
