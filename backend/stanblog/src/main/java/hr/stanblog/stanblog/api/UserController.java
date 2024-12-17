package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.dto.UserApartmentBuildingDto;
import hr.stanblog.stanblog.dto.UserDto;
import hr.stanblog.stanblog.exceptions.ResponseObj;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchBuildingException;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchUserException;
import hr.stanblog.stanblog.exceptions.individualExceptions.UserAlreadyExistsException;
import hr.stanblog.stanblog.exceptions.individualExceptions.UserIsAlreadyInThatBuildingException;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import hr.stanblog.stanblog.service.EmailService;
import hr.stanblog.stanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app"})
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final EmailService emailService;

    @Autowired
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping("/addNew")
    @PostMapping
    public ResponseEntity<ResponseObj> addNewUser(@RequestBody UserDto userDto) {
        AppUser appUser = new AppUser(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getUserRole());
        try {
            userService.addNewUser(appUser);
            return new ResponseEntity<>(new ResponseObj("Uspješna registracija"), HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(new ResponseObj("Korisnik s emailom: " + appUser.getEmail() + " već postoji"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/addUserBuilding")
    @PostMapping
    public ResponseEntity<ResponseObj> addUserToABuilding(@RequestBody UserApartmentBuildingDto userApartmentBuildingDto) {
        System.err.println(userApartmentBuildingDto.isRepresentative());
        UserApartmentBuilding userApartmentBuilding = new UserApartmentBuilding(new AppUser(), new ApartmentBuilding(), userApartmentBuildingDto.isRepresentative());
        userApartmentBuilding.getUser().setEmail(userApartmentBuildingDto.getUserEMail());
        userApartmentBuilding.getApartmentBuilding().setId(userApartmentBuildingDto.getBuildingID());
        userApartmentBuilding.setIsRepresentative(userApartmentBuildingDto.isRepresentative());

        try {
            userService.addUserApartmentBuilding(userApartmentBuilding);
            return new ResponseEntity<>(new ResponseObj("Korisnik uspješno dodan u zgradu"), HttpStatus.OK);
        } catch (UserIsAlreadyInThatBuildingException e) {
            return new ResponseEntity<>(new ResponseObj("Korisnik s emailom: " + userApartmentBuilding.getUser().getEmail() + " je već u zgradi s Id-om: " + userApartmentBuilding.getApartmentBuilding().getId()), HttpStatus.BAD_REQUEST);
        } catch (NoSuchUserException e2) {
            return new ResponseEntity<>(new ResponseObj("Korisnik s emailom: " + userApartmentBuilding.getUser().getEmail() + " ne postoji"), HttpStatus.BAD_REQUEST);
        } catch (NoSuchBuildingException e3) {
            return new ResponseEntity<>(new ResponseObj("Zgrada s Id-om: "+userApartmentBuilding.getApartmentBuilding().getId()+ " ne postoji"), HttpStatus.BAD_REQUEST);
        }
                    /**
         * Primjer dodavanja usera u zgradu
         * {
         *     "userEMail": "ivoivic@gmail.com",
         *     "buildingID": 1
         *      "isRepresentative": true
         * }
         *
         *
         */
    }

    @RequestMapping("/addNewUserBuilding")
    @PostMapping
    public ResponseEntity<ResponseObj> addNewUserToABuilding(@RequestBody UserApartmentBuilding userApartmentBuilding) {
        try {
            userService.addNewUserApartmentBuilding(userApartmentBuilding);
            return new ResponseEntity<>(new ResponseObj("Korisnik uspješno dodan u zgradu"), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(new ResponseObj("Korisnik s emailom: " + userApartmentBuilding.getUser().getEmail() + " već postoji"), HttpStatus.BAD_REQUEST);
        } catch (NoSuchBuildingException e2) {
            return new ResponseEntity<>(new ResponseObj("Zgrada s Id-om: "+userApartmentBuilding.getApartmentBuilding().getId()+ " ne postoji"), HttpStatus.BAD_REQUEST);
        }

        /**
         * Primjer dodavanja usera u zgradu
         * {
         *   "user": {
         *     "firstName": "ivo",
         *     "lastName": "ivic",
         *     "email": "ivoivic@gmail.com",
         *     "userRole": "NORMAL_USER"
         *   },
         *   "apartmentBuilding": {
         *     "id": 1
         *   },
         *   "isRepresentative": true
         * }
         *
         *
         */

    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getApartmentBuilding(@PathVariable Long userId){

        try {
            UserDto userDto = userService.findUserById(userId);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoSuchUserException e) {
            return ResponseEntity.badRequest().body(null);
        }


    }
}





