package com.yash.tms.services;

import java.util.List;
import java.util.Optional;

import com.yash.tms.entity.masterActor;

public interface MasterActorManager {

	public List<masterActor> findAllActors(short actorIsDeleted);

	public masterActor addActor(masterActor actor);

	public masterActor findById(int actorId);

}
