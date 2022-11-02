package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.tms.entity.MasterActor;


public interface MasterActorDao extends JpaRepository<MasterActor, Integer> {

	@Query(value="from MasterActor where actorIsDeleted =?1")
	public List<MasterActor> findAllActors(short actorIsDeleted);

}
