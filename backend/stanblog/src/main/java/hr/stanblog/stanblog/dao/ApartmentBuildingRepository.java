package hr.stanblog.stanblog.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import hr.stanblog.stanblog.model.ApartmentBuilding;

import java.util.List;

@Repository
public interface ApartmentBuildingRepository extends JpaRepository<ApartmentBuilding, Long>{

}
