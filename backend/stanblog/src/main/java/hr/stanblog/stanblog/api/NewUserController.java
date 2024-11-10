package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import hr.stanblog.stanblog.service.EmailService;
import hr.stanblog.stanblog.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    public class NewUserController {
        private final NewUserService newUserService;
        private final EmailService emailService;
        @Autowired
        public NewUserController(NewUserService newUserService, EmailService emailService) {
            this.newUserService = newUserService;
            this.emailService = emailService;
        }
        @RequestMapping("/addNew")
        @PostMapping
        public void addNewUser(@RequestBody AppUser appUser) {
            if(newUserService.addNewUser(appUser))emailService.sendEmail(appUser.getEmail(),"Usješna Registracija","Uspješno ste registrirani u aplikaciju stanblog");
        }
        @RequestMapping("/addUserBuilding")
        @PostMapping
        public void addUserToABuilding(@RequestBody UserApartmentBuilding userApartmentBuilding) {

            newUserService.addUserApartmentBuilding(userApartmentBuilding);

            /**
             * Primjer dodavanja usera u zgradu
             * {
             *   "user": {
             *     "id": 1
             *   },
             *   "apartmentBuilding": {
             *     "id": 2
             *   },
             *   "isRepresentative": true
             * }
             */

        }



    }


