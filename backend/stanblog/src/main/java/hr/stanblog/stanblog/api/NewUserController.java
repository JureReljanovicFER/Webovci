package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.dto.UserDto;
import hr.stanblog.stanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class NewUser {
    @RequestMapping("/addNew")
    @RestController
    public class UserController {
        private NewUserService NewUserService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping("/login")
        public ResponseEntity<String> userLogin(@RequestBody UserDto userDto){
            userService.loginUser(userDto);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
    }

}
