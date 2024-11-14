package hr.stanblog.stanblog.dto;

public class UserApartmentBuildingDto {
    private String userEMail;
    private Long buildingID;
    private boolean isRepresentative;

    public UserApartmentBuildingDto(String userEMail, Long buildingID, boolean isRepresentative) {
        this.userEMail = userEMail;
        this.buildingID = buildingID;
        this.isRepresentative = isRepresentative;
    }

    public String getUserEMail() {
        return userEMail;
    }

    public void setUserEMail(String userEMail) {
        this.userEMail = userEMail;
    }

    public Long getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Long buildingID) {
        this.buildingID = buildingID;
    }

    public boolean isRepresentative() {
        return isRepresentative;
    }

    public void setRepresentative(boolean representative) {
        isRepresentative = representative;
    }
}
