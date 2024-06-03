package Constract;

public class Constract {
    private int customerNumber;
    private String insuranceType; 


    public Constract() {
    }

    public Constract(int customerNumber, String insuranceType) {
        this.customerNumber = customerNumber;
        this.insuranceType = insuranceType;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Override
    public String toString() {
        return customerNumber + "," + insuranceType;
    }
}
