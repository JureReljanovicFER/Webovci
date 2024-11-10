package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.UserReposity;
import hr.stanblog.stanblog.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewUserService {

    private final UserReposity userReposity;
    @Autowired
    public NewUserService(UserReposity userReposity) {
        this.userReposity = userReposity;
    }

    public boolean addNewUser(AppUser appUser) {

        System.out.println(appUser.toString());


        userReposity.save(appUser);


        return true;
    }


}
