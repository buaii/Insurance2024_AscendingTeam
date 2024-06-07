package Underwriting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import Customer.Customer;

public interface UnderwritingList {
    public List<Customer> getUnderwritings();
    public void removeUnderwriting(Customer customer) throws IOException;
    public void rejectUnderwriting(Customer customer, String reason) throws IOException;
    public void holdUnderwriting(Customer customer, String holdInfo) throws IOException;
    public void reviewUnderwritingRequests(BufferedReader reader) throws IOException;
}
