package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.dto.ApartmentBuildingDto;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.service.ApartmentBuildingService;
import hr.stanblog.stanblog.service.impl.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app", "https://webovci-1.onrender.com"})
@RestController
@RequestMapping("/voting")
public class VotingController {
    private final VotingService votingService;

    @Autowired
    public VotingController(VotingService votingService){
        this.votingService = votingService;
    }

    @PostMapping("/new")
    public ResponseEntity<ApartmentBuilding> createVoting(@RequestBody VotingDto votingDto){
        try {
            ApartmentBuilding apartmentBuilding = votingService.saveVoting(votingDto);
            return new ResponseEntity<>(apartmentBuilding, HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
