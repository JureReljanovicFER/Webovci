package hr.stanblog.stanblog.api;
import hr.stanblog.stanblog.exceptions.ResponseObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import hr.stanblog.stanblog.dto.DiscussionDto;
import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.service.DiscussionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Discussions")
@RestController
@RequestMapping("/discussions")
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }


    @ApiOperation(value = "Get all discussions", notes = "Returns a list of all discussions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of discussions"),
            @ApiResponse(code = 500, message = "Internal server error")
    })

    @RequestMapping("/getAll")
    @GetMapping
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        return new ResponseEntity<List<Discussion>>(discussionService.getAllDiscussions(), HttpStatus.OK);
    }

    @RequestMapping("/addNew")
    @PostMapping

    public ResponseEntity<ResponseObj> addNew(@RequestBody DiscussionDto discussionDto) {

        if (discussionService.addNewDiscussion(discussionDto)) {
            return new ResponseEntity<>(new ResponseObj("Diskusija uspjesno dodana"), HttpStatus.OK);
        }


        return null;

        /**
         * primjer dodavanja diskusije
         * {
         *   "creatorUserId": {
         *     "id": 1
         *   },
         *   "title": "Example Title",
         *   "description": "Example Description",
         *   "apartmentBuildingId": {
         *     "id": 1
         *   },
         *   "visibilities": [
         *     {
         *       "userId": 1,
         *       "canUserSee": true,
         *       "canUserParticipate": true
         *     },
         *     {
         *       "userId": 2,
         *       "canUserSee": true,
         *       "canUserParticipate": true
         *     }
         *   ]
         * }
         */
    }


}
