package hr.stanblog.stanblog.api;

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
        public void addNewUser(@RequestBody AppUser appUser) {
            userService.addNewUser(appUser);
        }
        @RequestMapping("/addUserBuilding")
        @PostMapping
        public void addUserToABuilding(@RequestBody UserApartmentBuilding userApartmentBuilding) {



            userService.addUserApartmentBuilding(userApartmentBuilding);

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



    }


