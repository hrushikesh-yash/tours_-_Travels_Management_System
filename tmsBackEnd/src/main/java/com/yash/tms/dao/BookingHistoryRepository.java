package com.yash.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.tms.entity.BookingHistory;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer> {

	@Query(value = "from BookingHistory where bookingHistoryIsDeleted=?1")
	List<BookingHistory> findAllBookingHistory(short bookingHistoryIsDeleted);

}
