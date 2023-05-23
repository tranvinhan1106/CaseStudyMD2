package src.models;

public class Employee extends Person {
    private String employeeCode;
    private String name;
    private String birthday;
    private String gender;
    private String identityCard;
    private String phoneNumber;
    private String Email;
    private String Level;
    private String location;
    private long wage;

    public Employee() {
    }

    public Employee(String employeeCode, String name, String birthday, String gender, String identityCard, String phoneNumber, String email, String level, String location, long wage) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        Email = email;
        Level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Level='" + Level + '\'' +
                ", location='" + location + '\'' +
                ", wage=" + wage +
                '}';
    }
}
