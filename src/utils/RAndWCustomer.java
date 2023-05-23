package src.utils;

import src.models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RAndWCustomer {
    public static final String FILE_PATH = "D:\\V.An\\FuramaResort\\src\\data\\customer.csv";
    public List<Customer> readFileCSV() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        String line;
        String[] temp;
        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            String customerCode = temp[0];
            String name = temp[1];
            String birthday = temp[2];
            String gender = temp[3];
            String identityCard = temp[4];
            String numberPhone = temp[5];
            String email = temp[6];
            String typeGuest = temp[7];
            String address = temp[8];
            customer = new Customer(customerCode, name, birthday, gender, identityCard, numberPhone, email, typeGuest, address);
            customerList.add(customer);
        }
        bufferedReader.close();
        return customerList;
    }

    public void writeCSV(List<Customer> customers) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Customer customer : customers) {
            bufferedWriter.write(customer.getCustomerCode() + "," + customer.getName() + "," + customer.getBirthday() + "," + customer.getGender() + "," + customer.getIdentityCard()
                    + "," + customer.getNumberPhone() + "," + customer.getEmail() + "," + customer.getTypeGuest() + "," + customer.getAddress());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
