package Customer;

import Constract.Constract;
import CustomerValue.*;
import Insurance.Insurance;

public class Customer {
    private String id;
    private String password;
    private int customerNumber;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;
    private String job;
    private String email;
    private String birthdate;
    private String creditRating;
    private String abroad;
    private String constractStatus;
    private String crime;
    private String disease;
    private boolean drink;
    private String drive;
    private String identityNum;
    private boolean miltary;
    public Abroad m_Abroad;
    public Drive m_Drive;
    public Insurance m_Insurance;
    public Crime m_Crime;
    public Disease m_Disease;
    public Constract m_Constract;
    public Military m_Military;
    private String selectedInsuranceType;
    private String selectedInsuranceName;

    public Customer() {
        this.id = "idNA";
        this.password = "passwordNA";
        this.customerNumber = 0;
        this.name = "N/A";
        this.age = 0;
        this.gender = "N/A";
        this.address = "N/A";
        this.phoneNumber = "N/A";
        this.job = "N/A";
        this.email = "N/A";
        this.birthdate = "N/A";
        this.creditRating = "creditNA";
        this.abroad = "N/A";
        this.constractStatus = "N/A";
        this.crime = "N/A";
        this.disease = "N/A";
        this.drink = false;
        this.drive = "N/A";
        this.identityNum = "N/A";
        this.miltary = false;
        this.selectedInsuranceType = "N/A";
        this.selectedInsuranceName = "N/A";
    }

    public Customer(String id, String password, int customerNumber, String name, int age, String gender, String address, 
                    String phoneNumber, String job, String email, String birthdate, String selectedInsuranceType, String selectedInsuranceName) {
        this.id = id;
        this.password = password;
        this.customerNumber = customerNumber;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.email = email;
        this.birthdate = birthdate;
        this.creditRating = "creditNA"; 
        this.abroad = "N/A";
        this.constractStatus = "N/A";
        this.crime = "N/A";
        this.disease = "N/A";
        this.drink = false;
        this.drive = "N/A";
        this.identityNum = "N/A";
        this.miltary = false;
        this.selectedInsuranceType = selectedInsuranceType;
        this.selectedInsuranceName = selectedInsuranceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public String getAbroad() {
        return abroad;
    }

    public void setAbroad(String abroad) {
        this.abroad = abroad;
    }

    public String getConstractStatus() {
        return constractStatus;
    }

    public void setConstractStatus(String constractStatus) {
        this.constractStatus = constractStatus;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public boolean isDrink() {
        return drink;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public boolean isMiltary() {
        return miltary;
    }

    public void setMiltary(boolean miltary) {
        this.miltary = miltary;
    }

    public String getSelectedInsuranceType() {
        return selectedInsuranceType;
    }

    public void setSelectedInsuranceType(String selectedInsuranceType) {
        this.selectedInsuranceType = selectedInsuranceType;
    }

    public String getSelectedInsuranceName() {
        return selectedInsuranceName;
    }

    public void setSelectedInsuranceName(String selectedInsuranceName) {
        this.selectedInsuranceName = selectedInsuranceName;
    }

    @Override
    public String toString() {
        return customerNumber + "," + id + "," + password + "," + name + "," + age + "," + gender + "," + address + ","
                + phoneNumber + "," + job + "," + email + "," + birthdate + "," + creditRating + "," + abroad + ","
                + constractStatus + "," + crime + "," + disease + "," + (drink ? "유" : "무") + "," + drive + "," + identityNum + ","
                + (miltary ? "유" : "무") + "," + selectedInsuranceType + "," + selectedInsuranceName;
    }
}
