package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.AppUser;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserApartmentBuildingRepository extends JpaRepository<UserApartmentBuilding,Long> {

    boolean existsByUserIdAndAndApartmentBuildingId(Long userId, Long ApartmentBuildingId);
}

