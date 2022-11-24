package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.BookingHistory;
import com.yash.tms.entity.MasterUser;

public interface BookingHistoryManager {

	List<BookingHistory> findAllBookingHistory(int bookingHistoryIsDeleted);

	BookingHistory addBookingHistory(BookingHistory history);

	BookingHistory findById(int bookingHistoryId);

	List<BookingHistory> findBookingByUserId(int userId);

	BookingHistory findByStatusId(int statusId);

}
