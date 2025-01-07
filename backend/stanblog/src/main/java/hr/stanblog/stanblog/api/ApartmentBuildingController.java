package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.exceptions.ResponseObj;
import hr.stanblog.stanblog.exceptions.individualExceptions.NoSuchBuildingException;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.service.ApartmentBuildingService;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.dto.ApartmentBuildingDto;
import hr.stanblog.stanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app", "https://webovci-1.onrender.com"})
@RestController
@RequestMapping("/apartment-buildings")
public class ApartmentBuildingController {
    private final ApartmentBuildingService apartmentBuildingService;

    @Autowired
    private UserService userService;

    @Autowired
    public ApartmentBuildingController(ApartmentBuildingService apartmentBuildingService){
        this.apartmentBuildingService = apartmentBuildingService;
    }

    @PostMapping("/new")
    public ResponseEntity<ApartmentBuilding> createApartmentBuilding(@RequestBody ApartmentBuildingDto apartmentBuildingDto){
        try {
            ApartmentBuilding apartmentBuilding = apartmentBuildingService.saveApartmentBuilding(apartmentBuildingDto);
            return new ResponseEntity<>(apartmentBuilding, HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ApartmentBuilding>> getApartmentBuilding(@PathVariable Long userId){
        try{
            if (userService.isUserAdmin(userId)){
                List<ApartmentBuilding> allBuildings = apartmentBuildingService.getAllBuildings();
                return ResponseEntity.ok(allBuildings);
            } else {
                List<ApartmentBuilding> userBuildings = apartmentBuildingService.getAppartmentBuildingsByUserId(userId);
                return ResponseEntity.ok(userBuildings);
            }
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getTenants/{buildingId}")
    public ResponseEntity<ResponseObj> getTenants(@PathVariable Long buildingId) {
        List<AppUser> users;
        try {
            users=apartmentBuildingService.getTenants(buildingId);
        } catch (NoSuchBuildingException e) {
            return new ResponseEntity<>(new ResponseObj("Zgrada s tim ID-em ne postoji"), HttpStatus.BAD_REQUEST);
        }

        if (!users.isEmpty()) {
            ResponseObj test = new ResponseObj("test", users);
            return new ResponseEntity<>(new ResponseObj(("Dohvaćeni stanari zgrade s ID-om " + buildingId), users), HttpStatus.OK);
        }else
            return new ResponseEntity<>(new ResponseObj("Zgrada je prazna"),HttpStatus.BAD_REQUEST);
    }


}
