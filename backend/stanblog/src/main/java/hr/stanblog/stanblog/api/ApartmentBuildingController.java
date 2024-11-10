package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.service.ApartmentBuildingService;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.dto.ApartmentBuildingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartment-buildings")
public class ApartmentBuildingController {
    private final ApartmentBuildingService apartmentBuildingService;

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
}
