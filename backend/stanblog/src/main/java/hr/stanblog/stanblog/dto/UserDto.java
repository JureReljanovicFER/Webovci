package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.UserRole;
import java.util.Objects;

public class UserDto {

    private String firstName;

    private String lastName;

    private String email;

    private UserRole userRole;


    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String email, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserDto firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserDto lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserDto email(String email) {
        setEmail(email);
        return this;
    }

    public UserDto userRole(UserRole userRole) {
        setUserRole(userRole);
        return this;
    }


    
    
}
