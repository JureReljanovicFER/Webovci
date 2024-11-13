package hr.stanblog.stanblog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.stanblog.stanblog.dto.UserDto;
import hr.stanblog.stanblog.service.AuthService;

@RequestMapping("/oauth")
@RestController
public class AuthController {
    private AuthService userService;

    @Autowired
    public AuthController(AuthService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody UserDto userDto){
        userService.loginUser(userDto);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}

