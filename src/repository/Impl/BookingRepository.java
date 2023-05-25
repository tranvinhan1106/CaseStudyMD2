package src.repository.Impl;

import src.models.Booking;
import src.repository.IBookingRepository;
import src.utils.RAndWBooking;

import java.io.IOException;
import java.util.TreeSet;

import static src.utils.RAndWBooking.readBooking;

public class BookingRepository implements IBookingRepository {
    public TreeSet<Booking> treeSet;

    {
        try {
            treeSet = readBooking();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    RAndWBooking rAndWBooking = new RAndWBooking();
    @Override
    public void display() {
        for (Booking booking : treeSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void add(Object o) throws IOException {
        if (o instanceof Booking){
            treeSet.add((Booking) o);
            rAndWBooking.writeBooking(treeSet);
        }

    }


//    @Override
//    public void edit(String id) {
//
//    }
}
