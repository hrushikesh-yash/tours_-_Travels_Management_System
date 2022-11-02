package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.masterStatus;

public interface MasterStatusManager {
	public List<masterStatus> findAllStatus(short statusIsDeleted);

	public masterStatus addStatus(masterStatus status);

	public masterStatus findById(int statusId);

}
