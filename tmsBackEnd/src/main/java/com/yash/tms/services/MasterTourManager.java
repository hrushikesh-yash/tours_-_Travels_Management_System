package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.masterTour;

public interface MasterTourManager {

	List<masterTour> findAlltours(short tourIsDeleted);

	masterTour addTour(masterTour tour);

	masterTour findById(int tourId);

}
