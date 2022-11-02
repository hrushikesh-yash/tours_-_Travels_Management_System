package com.yash.tms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.entity.BookingHistory;
import com.yash.tms.entity.MasterActor;
import com.yash.tms.services.BookingHistoryManager;

@RestController
@RequestMapping("/bookingHistory")
public class BookingHistoryController {
	private final static Logger log = LoggerFactory.getLogger(BookingHistoryController.class);
	
	@Autowired
	private BookingHistoryManager bookingHistoryManager;
	
	@GetMapping("/findAllBookingHistory")
	public List<BookingHistory> findAllBookingHistory() {
		log.info("BookingHistoryController :: findAllActors function started.");
		List<BookingHistory> bookingHistoryList = null;
		try {
			short bookingHistoryIsDeleted = 0;
			bookingHistoryList = bookingHistoryManager.findAllBookingHistory(bookingHistoryIsDeleted);
			if (!bookingHistoryList.isEmpty()) {
				return bookingHistoryList;
			}

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in findAllBookingHistory function." + e.getMessage());
			return null;
		}
		return bookingHistoryList;

	}
	
	@PostMapping("/addBookingHistory")
	public BookingHistory addBookingHistory(@RequestBody BookingHistory history) {
		log.info("BookingHistoryController :: addBookingHistory function started.");
		try {

			return bookingHistoryManager.addBookingHistory(history);

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in addBookingHistory function." + e.getMessage());
			return null;
		}

	}
	
	
	@PutMapping("/updateActor/{bookingHistoryId}")
	public BookingHistory updateActor(@PathVariable(value = "bookingHistoryId") int bookingHistoryId, 
			@RequestBody BookingHistory history) {
		log.info("BookingHistoryController :: updateActor function started.");
		try {

			BookingHistory bookingHistoryToUpdate  = bookingHistoryManager.findById(bookingHistoryId);
			bookingHistoryToUpdate.setBookingHistoryId(bookingHistoryId);
			bookingHistoryToUpdate.setUserId(history.getUserId());
			bookingHistoryToUpdate.setVehicleId(history.getVehicleId());
			bookingHistoryToUpdate.setHotelId(history.getHotelId());
			bookingHistoryToUpdate.setStatusId(history.getStatusId());
			bookingHistoryToUpdate.setBookingDate(history.getBookingDate());
			bookingHistoryToUpdate.setTravelStartDate(history.getTravelStartDate());
			bookingHistoryToUpdate.setTravelEndDate(history.getTravelEndDate());
			bookingHistoryToUpdate.setTravelAmount(history.getTravelAmount());
			bookingHistoryToUpdate.setBookingIsDelete(history.getBookingIsDelete());
			return bookingHistoryManager.addBookingHistory(bookingHistoryToUpdate);

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in updateActor function." + e.getMessage());
			return null;
		}

	}

	@PutMapping("/delete/{bookingHistoryId}")
	public String deleteHistory(@PathVariable(value = "bookingHistoryId") int bookingHistoryId) {
		log.info("BookingHistoryController :: deleteHistory function started.");
		try {

			BookingHistory bookingHistoryToUpdate = bookingHistoryManager.findById(bookingHistoryId);
			bookingHistoryToUpdate.setBookingIsDelete((short) 1);
			bookingHistoryManager.addBookingHistory(bookingHistoryToUpdate);

			return "actor deleted sucessfully";

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in deleteHistory function." + e.getMessage());

		}
		return null;

	}
	
}