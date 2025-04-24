package com.airline.service;

import com.airline.dao.BookingDao;

public class BookingService
{
	private BookingDao bookingDao;
	
	public BookingService()
	{
		bookingDao = new BookingDao();
	}
	public boolean bookFlight(int userId, int flightId)
	{
		return bookingDao.save(userId, flightId);
	}

}
