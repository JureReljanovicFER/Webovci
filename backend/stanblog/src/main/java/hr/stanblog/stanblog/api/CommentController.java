package hr.stanblog.stanblog.api;

import hr.stanblog.stanblog.model.Comment;
import hr.stanblog.stanblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app", "https://webovci-1.onrender.com"})
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addCommentToDiscussion(Long discussionId, Long userId, String content){
        return commentService.addCommentToDiscussion(discussionId, userId, content);
    }

//    @PostMapping
//    public Comment addReplyToComment(Long parentCommentId, Long userId, String content){
//        return commentService.addReplyToComment(parentCommentId, userId, content);
//    }
}
