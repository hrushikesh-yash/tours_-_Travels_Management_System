package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.masterActor;


public interface MasterActorDao extends JpaRepository<masterActor, Integer> {

	@Query(value="from masterActor where actorIsDeleted =?1")
	public List<masterActor> findAllActors(short actorIsDeleted);

}
