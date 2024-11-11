package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchBuildingException;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchUserException;
import hr.stanblog.stanblog.exceptions.individualExceptions.UserAlreadyExistsException;
import hr.stanblog.stanblog.exceptions.individualExceptions.UserIsAlreadyInThatBuildingException;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import hr.stanblog.stanblog.service.EmailService;
import hr.stanblog.stanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
        public String addNewUser(@RequestBody AppUser appUser) {
            try {
                userService.addNewUser(appUser);
                return "Uspješna registracija";
            } catch (UserAlreadyExistsException e) {

                return "Korisnik s emailom: " + appUser.getEmail() + " već postoji";
            }
        }
        @RequestMapping("/addUserBuilding")
        @PostMapping
        public String addUserToABuilding(@RequestBody UserApartmentBuilding userApartmentBuilding) {


            try {
                userService.addUserApartmentBuilding(userApartmentBuilding);
                return "Korisnik uspješno dodan u zgradu";
            } catch (UserIsAlreadyInThatBuildingException e) {

                return "Korisnik s emailom: " + userApartmentBuilding.getUser().getEmail() + " je već u zgradi s Id-om: " + userApartmentBuilding.getApartmentBuilding().getId();
            } catch (NoSuchUserException e2) {
                return "Korisnik s emailom: " + userApartmentBuilding.getUser().getEmail() + " ne postoji";
            } catch (NoSuchBuildingException e3) {
                return "Zgrada s Id-om: "+userApartmentBuilding.getApartmentBuilding().getId()+ " ne postoji";
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

        @RequestMapping("/addNewUserBuilding")
        @PostMapping
        public String addNewUserToABuilding(@RequestBody UserApartmentBuilding userApartmentBuilding) {


            try {
                userService.addNewUserApartmentBuilding(userApartmentBuilding);
                return "Korisnik uspješno dodan u zgradu";
            } catch (UserAlreadyExistsException e) {
                return "Korisnik s emailom: " + userApartmentBuilding.getUser().getEmail() + " već postoji";
            } catch (NoSuchBuildingException e2) {
                return "Zgrada s Id-om: "+userApartmentBuilding.getApartmentBuilding().getId()+ " ne postoji";
            }

            /**
             * Primjer dodavanja usera u zgradu
             * {
             *   "user": {
             *     "email": "ivoivic@gmail.com",
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



    }


