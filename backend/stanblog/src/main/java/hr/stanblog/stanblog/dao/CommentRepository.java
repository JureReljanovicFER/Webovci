package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.Comment;
import hr.stanblog.stanblog.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select v from Comment v where v.discussion = ?1")
    List<Comment> findCommentsByDiscussion(Discussion discussion);
}
