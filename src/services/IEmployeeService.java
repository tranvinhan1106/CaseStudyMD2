package src.services;

import java.io.IOException;

public interface IEmployeeService extends Service{
    void addEmployee();

    void findAll() throws IOException;

    boolean checkID() throws IOException;

    void setEmployee();
}
