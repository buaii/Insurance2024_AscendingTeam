package Constract;

import Customer.Customer;

import java.io.BufferedReader;
import java.io.IOException;

public interface ConstractList {
    public void applyForInsurance(Customer customer, String insuranceType, String insuranceName) throws IOException;
    public void add(Constract Contract);
    public void delete();
    public void get();
    public void update();
    public void selectInsuranceTypeAndApply(BufferedReader reader) throws IOException;
    public void showInsuranceInfo(String typeChoice, BufferedReader reader) throws IOException;
}
