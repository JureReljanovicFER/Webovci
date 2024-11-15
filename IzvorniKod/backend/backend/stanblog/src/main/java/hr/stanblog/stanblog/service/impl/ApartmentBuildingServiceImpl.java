package hr.stanblog.stanblog.service.impl;

import hr.stanblog.stanblog.dto.ApartmentBuildingDto;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.service.ApartmentBuildingService;
import hr.stanblog.stanblog.dao.ApartmentBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentBuildingServiceImpl implements ApartmentBuildingService {
    private final ApartmentBuildingRepository apartmentBuildingRepository;

    @Autowired
    public ApartmentBuildingServiceImpl(ApartmentBuildingRepository apartmentBuildingRepository){
        this.apartmentBuildingRepository = apartmentBuildingRepository;
    }

    @Override
    public ApartmentBuilding saveApartmentBuilding(ApartmentBuildingDto apartmentBuildingDto) {
        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(
                apartmentBuildingDto.getAddress(),
                apartmentBuildingDto.getZipCode(),
                apartmentBuildingDto.getCity(),
                apartmentBuildingDto.getNumberOfIndividualApartments()
        );
        return apartmentBuildingRepository.save(apartmentBuilding);
    }

    @Override
    public List<ApartmentBuilding> getAllBuildings(){
        return apartmentBuildingRepository.findAll();
    }
}
