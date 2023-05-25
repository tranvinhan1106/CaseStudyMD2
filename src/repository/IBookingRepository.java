package src.repository;

import java.io.IOException;

public interface IBookingRepository {
    void display();

    void add(Object o) throws IOException;
}
