package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {
    Voting findByDiscussionId(Long discussionId);

}