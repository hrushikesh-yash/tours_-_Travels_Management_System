package com.yash.tms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tms.entity.BookingHistory;
import com.yash.tms.services.BookingHistoryManager;

@RestController
@RequestMapping("/bookingHistory")
@CrossOrigin("*")
public class BookingHistoryController {
	private final static Logger log = LoggerFactory.getLogger(BookingHistoryController.class);
	
	@Autowired
	private BookingHistoryManager bookingHistoryManager;
	
	@GetMapping("/findAllBookingHistory")
	public List<BookingHistory> findAllBookingHistory() {
		log.info("BookingHistoryController :: findAllActors function started.");
		List<BookingHistory> bookingHistoryList = null;
		try {
			int bookingHistoryIsDeleted = 0;
			bookingHistoryList = bookingHistoryManager.findAllBookingHistory(bookingHistoryIsDeleted);
			log.info("Booking list :: "+bookingHistoryList.size());
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
			bookingHistoryToUpdate.setUser(history.getUser());
			bookingHistoryToUpdate.setVehicle(history.getVehicle());
//			bookingHistoryToUpdate.setHotelId(history.getHotelId());
			bookingHistoryToUpdate.setStatus(history.getStatus());
			bookingHistoryToUpdate.setBookingDate(history.getBookingDate());
			bookingHistoryToUpdate.setTravelStartDate(history.getTravelStartDate());
			bookingHistoryToUpdate.setTravelEndDate(history.getTravelEndDate());
			bookingHistoryToUpdate.setTravelAmount(history.getTravelAmount());
			bookingHistoryToUpdate.setBookingIsDeleted(history.getBookingIsDeleted());
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
			bookingHistoryToUpdate.setBookingIsDeleted(1);
			bookingHistoryManager.addBookingHistory(bookingHistoryToUpdate);

			return "actor deleted sucessfully";

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in deleteHistory function." + e.getMessage());

		}
		return null;

	}
	
	@GetMapping("/findBookingByUserId/{userId}")
	public List<BookingHistory> findBookingByUserId(@PathVariable(value = "userId") int userId)
	{
		log.info("BookingHistoryController :: findBookingByUserId function started.");
		
		try {

			return bookingHistoryManager.findBookingByUserId(userId);
			
			

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in findBookingByUserId function." + e.getMessage());
			return null;
		}
	}
	
	@GetMapping("/findByStatusId/{statusId}")
	public BookingHistory findByStatusId(@PathVariable(value = "statusId") int statusId)
	{
		log.info("BookingHistoryController :: findBookingByUserId function started.");
		
		try {

			return bookingHistoryManager.findByStatusId(statusId);
			
			

		} catch (Exception e) {
			log.error("BookingHistoryController :: error in findBookingByUserId function." + e.getMessage());
			return null;
		}
	}
	
}
