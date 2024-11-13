package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.dto.ApartmentBuildingDto;

import java.util.List;

public interface ApartmentBuildingService {

    ApartmentBuilding saveApartmentBuilding(ApartmentBuildingDto apartmentBuildingDto);

    List<ApartmentBuilding> getAllBuildings();
}
