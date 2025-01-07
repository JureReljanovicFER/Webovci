package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.UserVoting;
import hr.stanblog.stanblog.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVotingRepository extends JpaRepository<UserVoting, Long> {
    List<UserVoting> findUserVotingByVoting(Voting voting);
}
