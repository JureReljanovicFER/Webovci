package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.model.Voting;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {

    @Query("select v from Voting v where v.discussion.id = ?1")
    Voting findBydiscussion(Long discussionId);
}