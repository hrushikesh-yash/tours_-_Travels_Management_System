package com.yash.tms.services;

import java.util.List;

import com.yash.tms.entity.BookingHistory;

public interface BookingHistoryManager {

	List<BookingHistory> findAllBookingHistory(int bookingHistoryIsDeleted);

	BookingHistory addBookingHistory(BookingHistory history);

	BookingHistory findById(int bookingHistoryId);

	List<BookingHistory> findBookingByUserId(int userId);

}
