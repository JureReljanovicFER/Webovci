package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.model.DiscussionVisibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionVisibilityRepository extends JpaRepository<DiscussionVisibility, Long> {

    List<DiscussionVisibility> findAllByDiscussion(Discussion discussion);
}
