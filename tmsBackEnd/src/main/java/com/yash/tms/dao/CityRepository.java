package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

	 @Query(value ="select c.cityId,c.cityName,c.pinCode,c.stateId,s.stateName "
	 		+ "from MasterCity  c "
	 		+ "inner join "
	 		+ "c.stateId s "
	 		+ "on c.stateId=s.stateId")
//	 + "where c.cityIsDeleted= ?1") c.pin_code ,c.city_is_deleted ,c.state_id 
	 public List<City> getAllCities();
}
