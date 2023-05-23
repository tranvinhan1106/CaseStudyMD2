package src.repository;

import src.models.Customer;

import java.io.IOException;

public interface ICustomerRepository {
    boolean checkID(String code) throws IOException;

    void addCustomer(Customer customer) throws IOException;

    void setCustomerList(Customer customer, String customerCode) throws IOException;
}
