package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.dto.ApartmentBuildingDto;

public interface ApartmentBuildingService {

    ApartmentBuilding saveApartmentBuilding(ApartmentBuildingDto apartmentBuildingDto);
}
