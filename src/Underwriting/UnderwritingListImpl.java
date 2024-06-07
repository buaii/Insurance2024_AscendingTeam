package Underwriting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Customer.Customer;

public class UnderwritingListImpl implements UnderwritingList {

    private String filePath;
    private List<Customer> customers;

    public UnderwritingListImpl(String filePath) throws IOException {
        this.filePath = filePath;
        this.customers = new ArrayList<>();
        loadCustomers();
    }

    private void loadCustomers() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 22) { // Expecting 22 fields
                    continue;
                }
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
                    parts[20].trim(), // insuranceType
                    parts[21].trim()  // insuranceName
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

    @Override
    public List<Customer> getUnderwritings() {
        return customers;
    }

    @Override
    public void removeUnderwriting(Customer customer) throws IOException {
        customers.remove(customer);
        saveCustomers();
    }

    @Override
    public void rejectUnderwriting(Customer customer, String reason) throws IOException {
        try (FileWriter writer = new FileWriter("거절고객.txt", true)) {
            writer.write(customer.toString() + ", 거절 사유: " + reason + "\n");
        }
        removeUnderwriting(customer);
    }

    @Override
    public void holdUnderwriting(Customer customer, String holdInfo) throws IOException {
        try (FileWriter writer = new FileWriter("보류고객.txt", true)) {
            writer.write(customer.toString() + ", 요청 서류: " + holdInfo + "\n");
        }
        removeUnderwriting(customer);
    }

    private void saveCustomers() throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Customer customer : customers) {
                writer.write(customer.toString() + "\n");
            }
        }
    }

    @Override
    public void reviewUnderwritingRequests(BufferedReader reader) throws IOException {
        if (customers.isEmpty()) {
            System.out.println("인수 심사 요청이 없습니다.");
            return;
        }

        List<Customer> customersCopy = new ArrayList<>(customers);

        for (Customer customer : customersCopy) {
            System.out.println("\n고객 이름: " + customer.getName() +
                    " / 나이: " + customer.getAge() + " 세" +
                    " / 성별: " + customer.getGender() +
                    " / 주소: " + customer.getAddress() +
                    " / 전화번호: " + customer.getPhoneNumber() +
                    " / 직업: " + customer.getJob() +
                    " / 이메일 주소: " + customer.getEmail() +
                    " / 생일: " + customer.getBirthdate() +
                    " / 선택한 보험: " + customer.getSelectedInsuranceName() +
                    " / 보험 종류: " + customer.getSelectedInsuranceType());

            String insuranceType = customer.getSelectedInsuranceType();

            if (insuranceType.equals("생명보험")) {
                System.out.print("질병: " + customer.getDisease());
                System.out.println(" / 음주 여부: " + (customer.isDrink() ? "유" : "무"));
            } else if (insuranceType.equals("손해보험")) {
                System.out.print("운전 여부: " + customer.getDrive());
                System.out.println(" / 범죄 기록: " + customer.getCrime());
            } else if (insuranceType.equals("제3보험")) {
                System.out.print("해외 체류 여부: " + customer.getAbroad());
                System.out.println(" / 군 복무 여부: " + (customer.isMiltary() ? "유" : "무"));
            } else {
                System.out.println("알 수 없는 보험 종류입니다.");
            }
            System.out.println("\n------------인수 심사------------");
            System.out.println("0. 돌아가기");
            System.out.println("1. 승인");
            System.out.println("2. 거절");
            System.out.println("3. 보류");
            System.out.println("4. 다음 고객");
            System.out.print("\n원하시는 서비스를 선택하세요: ");
            String decision = reader.readLine().trim();
            if (decision.equals("0")) {
                return;
            } else if (decision.equals("1")) {
                approveUnderwriting(customer);
            } else if (decision.equals("2")) {
                System.out.print("\n거절 사유를 입력하세요: ");
                String reason = reader.readLine().trim();
                rejectUnderwriting(customer, reason);
            } else if (decision.equals("3")) {
                System.out.print("\n보류 사유와 제출해야 할 서류를 입력하세요: ");
                String holdInfo = reader.readLine().trim();
                holdUnderwriting(customer, holdInfo);
            } else if (decision.equals("4")) {
                continue;
            } else {
                System.out.println("유효하지 않은 값입니다. 다음 고객으로 넘어갑니다.");
            }
        }

        saveCustomers();
    }

    private void approveUnderwriting(Customer customer) throws IOException {
        try (FileWriter writer = new FileWriter("고객명단.txt", true)) {
            writer.write(customer.toString() + "\n");
        }
        customers.remove(customer);
        saveCustomers();
    }
}
