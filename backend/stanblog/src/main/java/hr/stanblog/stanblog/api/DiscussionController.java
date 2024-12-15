package hr.stanblog.stanblog.api;


import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.service.DiscussionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService discussionService){
        this.discussionService = discussionService;
    }

    @GetMapping
    public ResponseEntity<List<Discussion>> getAllDiscussions(){
        return new ResponseEntity<List<Discussion>>(discussionService.getAllDiscussions(), HttpStatus.OK);

    }
}
