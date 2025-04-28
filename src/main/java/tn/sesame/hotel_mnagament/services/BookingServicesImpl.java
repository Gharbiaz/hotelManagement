import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sesame.hotel_mnagament.entity.Booking;
import tn.sesame.hotel_mnagament.repository.IBookingRepository;
import java.util.List;

@Service
public class BookingServicesImpl implements  IBookingServices {

@Autowired
    IBookingRepository bookingRepository;

    @Override
    public List<Booking> getBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);

    }

   
}
