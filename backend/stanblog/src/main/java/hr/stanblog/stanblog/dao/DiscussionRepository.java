package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.Discussion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion, Long>{
}
