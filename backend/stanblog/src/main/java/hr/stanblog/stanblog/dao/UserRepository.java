package hr.stanblog.stanblog.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import hr.stanblog.stanblog.model.AppUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByEmail(String email);

    Optional<AppUser> findById(Long Id);


}
