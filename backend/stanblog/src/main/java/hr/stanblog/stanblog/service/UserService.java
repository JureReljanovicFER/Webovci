package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.ApartmentBuildingRepository;
import hr.stanblog.stanblog.dao.UserApartmentBuildingRepository;
import hr.stanblog.stanblog.dao.UserRepository;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchBuildingException;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchUserException;
import hr.stanblog.stanblog.exceptions.individualExceptions.UserAlreadyExistsException;
import hr.stanblog.stanblog.exceptions.individualExceptions.UserIsAlreadyInThatBuildingException;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import hr.stanblog.stanblog.model.UserRole;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean addNewUser(AppUser appUser)throws UserAlreadyExistsException {

        System.out.println(appUser.toString());
            if(!userRepository.findByEmail(appUser.getEmail()).isEmpty()) {
                throw new UserAlreadyExistsException("User with email: " + appUser.getEmail() + " already exists");
            }
        userRepository.save(appUser);
        //emailService.sendEmail(appUser.getEmail(), "Usješna Registracija", "Poštovani korisniče" + appUser.getLastName() + "\nUspješno ste registrirani u aplikaciju stanblog");

        return true;
    }
    public boolean addUserApartmentBuilding(UserApartmentBuilding userApartmentBuilding) throws UserIsAlreadyInThatBuildingException,NoSuchUserException {
        if(apartmentBuildingRepository.findById(userApartmentBuilding.getApartmentBuilding().getId()).isEmpty()) throw new NoSuchBuildingException("Building with id: "+userApartmentBuilding.getApartmentBuilding().getId()+" does not exist" );
        List<AppUser> list;
        list = userRepository.findByEmail(userApartmentBuilding.getUser().getEmail());
        if(list.isEmpty()) throw new NoSuchUserException("This user does not exist");
        AppUser appUser = list.get(0);
        userApartmentBuilding.setUser(appUser);
        if(userApartmentBuildingRepository.existsByUserIdAndAndApartmentBuildingId(userApartmentBuilding.getUser().getId(),userApartmentBuilding.getApartmentBuilding().getId()))
            throw new UserIsAlreadyInThatBuildingException("User with email: " + userApartmentBuilding.getUser().getEmail() + " is already in a building with id:" + userApartmentBuilding.getApartmentBuilding().getId());
        userApartmentBuildingRepository.save(userApartmentBuilding);


        return true;

    }

    public boolean addNewUserApartmentBuilding(UserApartmentBuilding userApartmentBuilding) throws UserAlreadyExistsException, NoSuchBuildingException {

        if(apartmentBuildingRepository.findById(userApartmentBuilding.getApartmentBuilding().getId()).isEmpty()) throw new NoSuchBuildingException("Building with id: "+userApartmentBuilding.getApartmentBuilding().getId()+" does not exist" );
        
            try {
                addNewUser(new AppUser(userApartmentBuilding.getUser().getFirstName(), userApartmentBuilding.getUser().getLastName(), userApartmentBuilding.getUser().getEmail(), userApartmentBuilding.getUser().getUserRole()));
            } catch (UserAlreadyExistsException e) {
                throw e;
            }
        List<AppUser> list = userRepository.findByEmail(userApartmentBuilding.getUser().getEmail());

        userApartmentBuilding.setUser(list.get(0));

        userApartmentBuildingRepository.save(userApartmentBuilding);

        return true;
    }

    public boolean isUserAdmin(Long id){
        Optional<AppUser> optionalUser = userRepository.findById(id);
        AppUser user = optionalUser.orElse(null);
        return user != null && user.getUserRole().equals(UserRole.ADMIN);
    }










    }
