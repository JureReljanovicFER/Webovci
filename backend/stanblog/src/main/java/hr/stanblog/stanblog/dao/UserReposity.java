package hr.stanblog.stanblog.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import hr.stanblog.stanblog.model.AppUser;

@Repository
public interface UserReposity extends JpaRepository<AppUser, Long> {
    
}
