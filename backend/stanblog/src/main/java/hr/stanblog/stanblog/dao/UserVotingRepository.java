package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.UserVoting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVotingRepository extends JpaRepository<UserVoting, Long> {
}
