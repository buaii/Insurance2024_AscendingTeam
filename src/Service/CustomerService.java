package Service;

import java.io.*;

public class CustomerService {

    private static final String CUSTOMER_NUMBER_FILE = "Data/customerNumber.txt";
    private int customerNumber;

    public CustomerService() {
        try {
            File file = new File(CUSTOMER_NUMBER_FILE);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                customerNumber = Integer.parseInt(reader.readLine());
                reader.close();
            } else {
                customerNumber = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNextCustomerNumber() {
        int nextCustomerNumber = customerNumber++;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_NUMBER_FILE));
            writer.write(String.valueOf(customerNumber));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nextCustomerNumber;
    }
}
