package hr.stanblog.stanblog.dto;

public class ApartmentBuildingDto {
    private Long id;

    private String address;

    private int zipCode;

    private String city;

    private int numberOfIndividualApartments;

    public ApartmentBuildingDto(Long id, String address, int zipCode, String city, int numberOfIndividualApartments) {
        this.id = id;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.numberOfIndividualApartments = numberOfIndividualApartments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfIndividualApartments() {
        return numberOfIndividualApartments;
    }

    public void setNumberOfIndividualApartments(int numberOfIndividualApartments) {
        this.numberOfIndividualApartments = numberOfIndividualApartments;
    }
}
