package src.models;

public class Customer extends Person{
    private String customerCode ;
    private String name ;
    private String birthday ;
    private String gender ;
    private String identityCard ;
    private String numberPhone ;
    private String email ;
    private String typeGuest ;
    private String address ;

    public Customer() {
    }

    public Customer(String customerCode, String name, String birthday, String gender, String identityCard, String numberPhone, String email, String typeGuest, String address) {
        this.customerCode = customerCode;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identityCard = identityCard;
        this.numberPhone = numberPhone;
        this.email = email;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                ", typeGuest='" + typeGuest + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
