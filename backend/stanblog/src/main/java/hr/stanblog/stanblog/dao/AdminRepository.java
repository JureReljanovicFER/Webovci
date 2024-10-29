package hr.stanblog.stanblog.dao;
import hr.stanblog.stanblog.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    
}
