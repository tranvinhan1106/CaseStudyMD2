package src.services;

import java.io.IOException;

public interface ICustomerService extends Service{
    void addCustomer();

    void findAll() throws IOException;

    void setCustomer();

    boolean checkID() throws IOException;
}
