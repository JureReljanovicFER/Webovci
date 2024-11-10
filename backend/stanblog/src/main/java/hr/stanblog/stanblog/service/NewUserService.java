package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.UserApartmentBuildingRepository;
import hr.stanblog.stanblog.dao.UserReposity;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewUserService {

    private final UserReposity userReposity;
    private final UserApartmentBuildingRepository userApartmentBuildingRepository;

    @Autowired
    public NewUserService(UserReposity userReposity, UserApartmentBuildingRepository userApartmentBuildingRepository) {
        this.userReposity = userReposity;
        this.userApartmentBuildingRepository = userApartmentBuildingRepository;
    }

    public boolean addNewUser(AppUser appUser) {

        System.out.println(appUser.toString());


        userReposity.save(appUser);


        return true;
    }


    public boolean addUserApartmentBuilding(UserApartmentBuilding userApartmentBuilding) {

        userApartmentBuildingRepository.save(userApartmentBuilding);

        return true;
    }




}
