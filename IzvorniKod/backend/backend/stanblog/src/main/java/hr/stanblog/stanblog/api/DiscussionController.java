package hr.stanblog.stanblog.api;
import hr.stanblog.stanblog.dto.DiscussionBasicDto;
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
@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app", "https://webovci-1.onrender.com"})
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
    public ResponseEntity<List<DiscussionBasicDto>> getAllDiscussions() {
        return new ResponseEntity<List<DiscussionBasicDto>>(discussionService.getAllDiscussionsBasic(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    @GetMapping
    public ResponseEntity<ResponseObj> getAllDiscussionsFull(@PathVariable Long id) {
        try {
            DiscussionDto discussionDto = discussionService.getDiscussionsById(id);
            return new ResponseEntity<>(new ResponseObj("success", discussionDto), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ResponseObj(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping("/addNew")
    @PostMapping

    public ResponseEntity<ResponseObj> addNew(@RequestBody DiscussionBasicDto discussionDto) {
        try {
            Discussion addedDiscussion = discussionService.addNewDiscussion(discussionDto);
            return new ResponseEntity<>(new ResponseObj("Diskusija uspjesno dodana", addedDiscussion), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObj("Diskusija nije mogla biti dodana", null), HttpStatus.BAD_REQUEST);
        }

        /**
         * primjer dodavanja diskusije
         * {
         *   "creatorUserId": 1,
         *   "title": "Example Title",
         *   "description": "Example Description",
         *   "apartmentBuildingId": 1,
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
