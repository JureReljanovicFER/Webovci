package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.dto.UserVotingDto;
import hr.stanblog.stanblog.dto.VotingDto;
import hr.stanblog.stanblog.exceptions.ResponseObj;
import hr.stanblog.stanblog.model.Voting;
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
    public ResponseEntity<Voting> createVoting(@RequestBody VotingDto votingDto) {
        try {
            Voting voting = votingService.saveVoting(votingDto);
            return new ResponseEntity<>(voting, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{votingId}")
    public ResponseEntity<ResponseObj> vote(@RequestBody UserVotingDto userVotingDto, @PathVariable Long votingId){
        try {
            votingService.saveVote(votingId, userVotingDto);
            return new ResponseEntity<>(new ResponseObj("Glas pohranjen."), HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(new ResponseObj("Glas pohranjen."), HttpStatus.BAD_REQUEST);
        }
    }
}
