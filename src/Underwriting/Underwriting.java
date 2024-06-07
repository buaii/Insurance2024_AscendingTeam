package Underwriting;

public class Underwriting {
    private String customerNumber;
    private String name;
    private String applicationDate;
    private String status;

    public Underwriting(String customerNumber, String name, String applicationDate, String status) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Underwriting{" +
                "customerNumber='" + customerNumber + '\'' +
                ", name='" + name + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
