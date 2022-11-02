package com.yash.tms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tms.dao.BookingHistoryRepository;
import com.yash.tms.entity.BookingHistory;
import com.yash.tms.entity.MasterActor;
import com.yash.tms.exception.RecordNotfoundException;

@Service
public class BookingHistoryManagerImpl implements BookingHistoryManager {
	
	private final static Logger log = LoggerFactory.getLogger(BookingHistoryManagerImpl.class);

	@Autowired
	private BookingHistoryRepository bookingHistoryRepository;
	
	@Override
	public List<BookingHistory> findAllBookingHistory(short bookingHistoryIsDeleted) {
		log.info("BookingHistoryManagerImpl :: findAllActors function started.");
		try {
			
			return bookingHistoryRepository.findAllBookingHistory(bookingHistoryIsDeleted);
		}
		catch (Exception e) {
			log.error("BookingHistoryManagerImpl :: findAllActors error while find all actors. "+e.getMessage());
			log.error("BookingHistoryManagerImpl :: findAllActors Stacktrace :: "+e.getStackTrace());
		}
		return null;
	}

	@Override
	public BookingHistory addBookingHistory(BookingHistory history) {
		log.info("BookingHistoryManagerImpl :: addActor function started.");
		try {
			
			 return bookingHistoryRepository.save(history);
		}
		catch (Exception e) {
			log.error("BookingHistoryManagerImpl :: addBookingHistory error while adding history. "+e.getMessage());
			log.error("BookingHistoryManagerImpl :: addBookingHistory Stacktrace :: "+e.getStackTrace());
			return null;
		}
	}
	
	@Override
	public BookingHistory findById(int bookingHistoryId) {
		log.info("BookingHistoryManagerImpl :: findById function started.");
		try {
			BookingHistory history=bookingHistoryRepository.findById(bookingHistoryId).orElseThrow(() -> new RecordNotfoundException("history Id not found."));
			 return history;
		}
		catch (Exception e) {
			log.error("BookingHistoryManagerImpl :: findById error while find by history id ::"+bookingHistoryId+" "+e.getMessage());
			log.error("BookingHistoryManagerImpl :: findById Stacktrace :: "+e.getStackTrace());
			return null;
		}
		
	}

}
