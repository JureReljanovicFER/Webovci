package hr.stanblog.stanblog.service.impl;

import hr.stanblog.stanblog.dao.UserApartmentBuildingRepository;
import hr.stanblog.stanblog.dto.ApartmentBuildingDto;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchBuildingException;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import hr.stanblog.stanblog.service.ApartmentBuildingService;
import hr.stanblog.stanblog.dao.ApartmentBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentBuildingServiceImpl implements ApartmentBuildingService {
    private final ApartmentBuildingRepository apartmentBuildingRepository;
    private final UserApartmentBuildingRepository userApartmentBuildingRepository;

    @Autowired
    public ApartmentBuildingServiceImpl(ApartmentBuildingRepository apartmentBuildingRepository, UserApartmentBuildingRepository userApartmentBuildingRepository){
        this.apartmentBuildingRepository = apartmentBuildingRepository;
        this.userApartmentBuildingRepository = userApartmentBuildingRepository;
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

    @Override
    public List<ApartmentBuilding> getAppartmentBuildingsByUserId(Long id) {
        List<ApartmentBuilding> apartmentBuildings = new ArrayList<>();
        userApartmentBuildingRepository.findAll().forEach(userApartmentBuilding -> {
            if (userApartmentBuilding.getUser().getId().equals(id)) {
                apartmentBuildings.add(userApartmentBuilding.getApartmentBuilding());
            }
        });

        return apartmentBuildings;
    }

    @Override
    public List<AppUser> getTenants(Long Id) {
        if (!apartmentBuildingRepository.existsById(Id)) throw new NoSuchBuildingException();

        List<UserApartmentBuilding> list = userApartmentBuildingRepository.findUserApartmentBuildingsByApartmentBuildingId(Id);
        List<AppUser> users = new ArrayList<>();
        for (UserApartmentBuilding elem : list) {
            users.add(elem.getUser());
        }


        return users;
    }


}
