package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.ApartmentBuildingRepository;
import hr.stanblog.stanblog.dao.UserApartmentBuildingRepository;
import hr.stanblog.stanblog.dao.UserRepository;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchBuildingException;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserApartmentBuildingRepository userApartmentBuildingRepository;
    private final ApartmentBuildingRepository apartmentBuildingRepository;
    private final EmailService emailService;

    @Autowired
    public UserService(UserRepository userRepository, UserApartmentBuildingRepository userApartmentBuildingRepository, ApartmentBuildingRepository apartmentBuildingRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.userApartmentBuildingRepository = userApartmentBuildingRepository;
        this.apartmentBuildingRepository = apartmentBuildingRepository;
        this.emailService = emailService;
    }

    public boolean addNewUser(AppUser appUser) {

        System.out.println(appUser.toString());


        userRepository.save(appUser);
        emailService.sendEmail(appUser.getEmail(),"Usješna Registracija","Uspješno ste registrirani u aplikaciju stanblog");

        return true;
    }


    public boolean addUserApartmentBuilding(UserApartmentBuilding userApartmentBuilding) {

        if(apartmentBuildingRepository.findById(userApartmentBuilding.getApartmentBuilding().getId()).isEmpty()) throw new NoSuchBuildingException("Building with id: "+userApartmentBuilding.getApartmentBuilding().getId()+" does not exist" );
        List<AppUser> list;
        list=userRepository.findByEmail(userApartmentBuilding.getUser().getEmail());
        if (list.isEmpty()) {
            addNewUser(new AppUser(userApartmentBuilding.getUser().getFirstName(), userApartmentBuilding.getUser().getLastName(), userApartmentBuilding.getUser().getEmail(), userApartmentBuilding.getUser().getUserRole()));
            list=userRepository.findByEmail(userApartmentBuilding.getUser().getEmail());
        }
            userApartmentBuilding.getUser().setId(list.get(0).getId());



        userApartmentBuildingRepository.save(userApartmentBuilding);

        return true;
    }




}
