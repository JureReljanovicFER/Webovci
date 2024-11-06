package hr.stanblog.stanblog.dto;

public class ApartmentBuildingDto {
    String address;

    int zipCode;

    String city;

    int numberOfIndividualApartments;

    public ApartmentBuildingDto(String address, int zipCode, String city, int numberOfIndividualApartments) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.numberOfIndividualApartments = numberOfIndividualApartments;
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
