package src.repository.Impl;

import src.models.Customer;
import src.repository.ICustomerRepository;
import src.utils.RAndWCustomer;

import java.io.IOException;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    RAndWCustomer rAndWCustomer = new RAndWCustomer();
    public List<Customer> findAll() throws IOException {
        return rAndWCustomer.readFileCSV();
    }

    @Override
    public boolean checkID(String code) throws IOException {
        List<Customer> customerList = rAndWCustomer.readFileCSV();
        for (Customer customer : customerList) {
            if (code.equals(customer.getCustomerCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addCustomer(Customer customer) throws IOException {
        List<Customer> customerList = rAndWCustomer.readFileCSV();
        customerList.add(customer);
        rAndWCustomer.writeCSV(customerList);
    }

    @Override
    public void setCustomerList(Customer customer, String customerCode) throws IOException {
        List<Customer> customerList = rAndWCustomer.readFileCSV();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerCode().equals(customerCode)) {
                customerList.set(i, customer);
                break;
            }
        }
        rAndWCustomer.writeCSV(customerList);
    }


}
