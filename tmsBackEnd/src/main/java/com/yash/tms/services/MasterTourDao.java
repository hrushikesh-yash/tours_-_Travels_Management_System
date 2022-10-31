package com.yash.tms.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.masterTour;

@Repository
public interface MasterTourDao extends JpaRepository<masterTour, Integer> {

	@Query(value = "from masterTour where tourIsDeleted=?1")
	List<masterTour> findAlltours(short tourIsDeleted);

}
