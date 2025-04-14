package tn.sesame.hotel_mnagament.services;
import tn.sesame.hotel_mnagament.entity.Booking;

import java.util.List;

public interface IBookingServices {
    public List<Booking> getBookings();
    public Booking getBooking(long id);
    public Booking addBooking(Booking booking);
    public Booking updateBooking(Booking booking);
    public void deleteBooking(long id);
}
