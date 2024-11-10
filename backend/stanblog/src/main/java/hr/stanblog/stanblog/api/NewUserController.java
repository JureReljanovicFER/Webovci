package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.dto.UserDto;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.service.NewUserService;
import hr.stanblog.stanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hr.stanblog.stanblog.service.NewUserService;


    @RequestMapping("/addNew")
    @RestController
    public class NewUserController {
        private final NewUserService newUserService;

        @Autowired
        public NewUserController(NewUserService newUserService) {
            this.newUserService = newUserService;
        }

        @PostMapping
        public void addNewUser(@RequestBody AppUser appUser) {
            newUserService.addNewUser(appUser);
        }


    }


