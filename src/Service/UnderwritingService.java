package Service;

import Underwriting.UnderwritingListImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Customer.Customer;

public class UnderwritingService {

    private UnderwritingListImpl underwritingList;
    private UnderwritingListImpl reUnderwritingList;

    public UnderwritingService() {
        try {
            this.underwritingList = new UnderwritingListImpl("인수심사대기자.txt");
            this.reUnderwritingList = new UnderwritingListImpl("재심사대기자.txt");
        } catch (IOException e) {
            System.out.println("초기화 중 오류 발생: " + e.getMessage());
            this.underwritingList = null;
            this.reUnderwritingList = null;
        }
    }

    public void showUnderwritingMenu(BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("\n--------인수 심사 메뉴--------");
            System.out.println("0. 초기화면");
            System.out.println("1. 인수 심사 요청 확인");
            System.out.println("2. 재심사 요청 확인");
            System.out.println("3. 인수 심사 결과 확인");
            System.out.print("\n원하시는 서비스를 선택하세요: ");
            String choice = reader.readLine().trim();
            switch (choice) {
                case "0":
                    return;
                case "1":
                    if (underwritingList != null) {
                        underwritingList.reviewUnderwritingRequests(reader);
                    } else {
                        System.out.println("인수 심사 데이터를 불러올 수 없습니다.");
                    }
                    break;
                case "2":
                    if (reUnderwritingList != null) {
                        reUnderwritingList.reviewUnderwritingRequests(reader);
                    } else {
                        System.out.println("재심사 데이터를 불러올 수 없습니다.");
                    }
                    break;
                case "3":
                    checkUnderwritingResult(reader);
                    break;
                default:
                    System.out.println("\n유효하지 않은 값입니다. 다시 선택해주세요.\n");
            }
        }
    }

    public void checkUnderwritingResult(BufferedReader reader) throws IOException {
        System.out.print("아이디를 입력하세요: ");
        String id = reader.readLine().trim();
        System.out.print("비밀번호를 입력하세요: ");
        String password = reader.readLine().trim();

        Customer customer = findCustomer(id, password);
        if (customer == null) {
            System.out.println("고객 정보를 찾을 수 없습니다.");
            return;
        }

        String status = "보류";
        String reason = "";

        if (isCustomerInFile(customer, "고객명단.txt")) {
            status = "승인";
        } else if (isCustomerInFile(customer, "거절고객.txt")) {
            status = "거절";
            reason = getReasonFromFile(customer, "거절고객.txt");
        } else if (isCustomerInFile(customer, "보류고객.txt")) {
            reason = getReasonFromFile(customer, "보류고객.txt");
        }

        System.out.println("이름: " + customer.getName());
        System.out.println("나이: " + customer.getAge());
        System.out.println("성별: " + customer.getGender());
        System.out.println("전화번호: " + customer.getPhoneNumber());
        System.out.println("이메일: " + customer.getEmail());
        System.out.println("보험 상품명: " + customer.getSelectedInsuranceName());
        System.out.println("승인여부: " + status);

        if (!reason.isEmpty()) {
            System.out.println(reason);
        }

        if (status.equals("보류")) {
            System.out.println("파일을 제출하시겠습니까?");
            System.out.println("1. 제출");
            System.out.println("2. 보류");
            String decision = reader.readLine().trim();
            if (decision.equals("1")) {
                moveCustomerToReunderwriting(customer);
            }
        }
    }

    public Customer findCustomer(String id, String password) throws IOException {
        List<Customer> allCustomers = new ArrayList<>();
        allCustomers.addAll(loadCustomersFromFile("고객명단.txt"));
        allCustomers.addAll(loadCustomersFromFile("거절고객.txt"));
        allCustomers.addAll(loadCustomersFromFile("보류고객.txt"));

        for (Customer customer : allCustomers) {
            if (customer.getId().equals(id) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    private List<Customer> loadCustomersFromFile(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 22) { 
                    Customer customer = new Customer(
                        parts[1].trim(),
                        parts[2].trim(),
                        Integer.parseInt(parts[0].trim()),
                        parts[3].trim(),
                        Integer.parseInt(parts[4].trim()),
                        parts[5].trim(),
                        parts[6].trim(),
                        parts[7].trim(),
                        parts[8].trim(),
                        parts[9].trim(),
                        parts[10].trim(),
                        parts[20].trim(),
                        parts[21].trim(),
                        parts[22].trim()
                    );
                    customer.setCreditRating(parts[11].trim());
                    customer.setAbroad(parts[12].trim());
                    customer.setConstractStatus(parts[13].trim());
                    customer.setCrime(parts[14].trim());
                    customer.setDisease(parts[15].trim());
                    customer.setDrink(parts[16].trim().equalsIgnoreCase("유"));
                    customer.setDrive(parts[17].trim());
                    customer.setIdentityNum(parts[18].trim());
                    customer.setMiltary(parts[19].trim().equalsIgnoreCase("유"));
                    customers.add(customer);
                }
            }
        }
        return customers;  
    }

    private boolean isCustomerInFile(Customer customer, String filePath) throws IOException {
        List<Customer> customers = loadCustomersFromFile(filePath);
        for (Customer c : customers) {
            if (c.getId().equals(customer.getId()) && c.getPassword().equals(customer.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private String getReasonFromFile(Customer customer, String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(customer.getId())) {
                    String[] parts = line.split(",");
                    return parts[parts.length - 1].trim();
                }
            }
        }
        return "";
    }

    private void moveCustomerToReunderwriting(Customer customer) throws IOException {
        removeCustomerFromFile(customer, "보류고객.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("재심사대기자.txt", true))) {
            writer.write(customer.toString());
            writer.newLine();
        }
        System.out.println("재심사 대기자로 이동되었습니다.");
    }

    private void removeCustomerFromFile(Customer customer, String filePath) throws IOException {
        List<Customer> customers = loadCustomersFromFile(filePath);
        customers.removeIf(c -> c.getId().equals(customer.getId()) && c.getPassword().equals(customer.getPassword()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer c : customers) {
                writer.write(c.toString());
                writer.newLine();
            }
        }
    }
}
