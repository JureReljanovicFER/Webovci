package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.UserDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDiscussionRepository extends JpaRepository<UserDiscussion, Long> {

}
