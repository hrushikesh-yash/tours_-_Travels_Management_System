package com.yash.tms.services;

import java.util.List;
import java.util.Optional;

import com.yash.tms.entity.MasterActor;

public interface MasterActorManager {

	public List<MasterActor> findAllActors(short actorIsDeleted);

	public MasterActor addActor(MasterActor actor);

	public MasterActor findById(int actorId);

}
