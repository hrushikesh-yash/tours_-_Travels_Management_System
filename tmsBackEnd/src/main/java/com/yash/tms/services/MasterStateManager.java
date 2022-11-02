package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterState;

public interface MasterStateManager {

	public List<MasterState> findAllStates(short stateIsDeleted);

	public MasterState addState(MasterState state);

	public MasterState findById(int stateId);

}
