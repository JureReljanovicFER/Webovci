package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.dto.AddCommentDto;
import hr.stanblog.stanblog.dto.CommentDto;
import hr.stanblog.stanblog.exceptions.ResponseObj;
import hr.stanblog.stanblog.model.Comment;
import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app", "https://webovci-1.onrender.com"})
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<Comment> addCommentToDiscussion(@RequestBody AddCommentDto commentDto) {
        try {
            Comment newComment = commentService.addCommentToDiscussion(commentDto.getDiscussionId(), commentDto.getUserId(), commentDto.getContent());
            return new ResponseEntity<>( newComment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

//    @PostMapping
//    public Comment addReplyToComment(Long parentCommentId, Long userId, String content){
//        return commentService.addReplyToComment(parentCommentId, userId, content);
//    }
}
