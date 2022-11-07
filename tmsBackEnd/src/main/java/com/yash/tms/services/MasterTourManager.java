package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.MasterTour;

public interface MasterTourManager {

	List<MasterTour> findAlltours(int tourIsDeleted);

	MasterTour addTour(MasterTour tour);

	MasterTour findById(int tourId);

}
