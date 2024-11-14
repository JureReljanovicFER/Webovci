package hr.stanblog.stanblog.dao;

import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserApartmentBuildingRepository extends JpaRepository<UserApartmentBuilding,Long> {

    boolean existsByUserIdAndAndApartmentBuildingId(Long userId, Long ApartmentBuildingId);

    List<ApartmentBuilding> findBuildingsByUserId(Long userId);
}

