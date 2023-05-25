package src.utils;

import src.models.Booking;

public class BookingComparator {
    public int compare(Booking o1, Booking o2) {
        int dateBooking = o2.getStartDay().compareTo(o1.getEndDate());
        if (dateBooking != 0) {
            return dateBooking;
        } else {
            return o2.getStartDay().compareTo(o1.getEndDate());
        }

    }
}
