package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.CommentRepository;
import hr.stanblog.stanblog.dao.DiscussionRepository;
import hr.stanblog.stanblog.dao.UserRepository;
import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.Comment;
import hr.stanblog.stanblog.model.Discussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addCommentToDiscussion(Long discussionId, Long userId, String content){
        Discussion discussion = discussionRepository.findById(discussionId).orElseThrow(() -> new RuntimeException("Discussion not found!"));
        AppUser user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        Comment comment = new Comment();
        comment.setDiscussion(discussion);
        comment.setAuthor(user);
        comment.setContent(content);

        return commentRepository.save(comment);
    }

    public Comment addReplyToComment(Long parentCommentId, Long userId, String content){
        Comment parentComment = commentRepository.findById(parentCommentId).orElseThrow(() ->  new RuntimeException("Parent comment not found!"));
        AppUser user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        Comment reply = new Comment();
        reply.setAuthor(user);
        reply.setContent(content);

        return commentRepository.save(reply);
    }
}
