package Constract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Customer.Customer;
import Service.CustomerService;

public class ConstractListImpl implements ConstractList {

    private CustomerService customerService;

    public ConstractListImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void applyForInsurance(Customer customer, String insuranceType) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            customer.setId(getSimpleValidatedInput(reader, "아이디 (예: user123): "));
            customer.setPassword(getSimpleValidatedInput(reader, "패스워드 (예: password123): "));
            customer.setName(getSimpleValidatedInput(reader, "이름 (예: 홍길동): "));
            customer.setAge(Integer.parseInt(getSimpleValidatedInput(reader, "나이 (예: 30): ", "^[0-9]{1,3}$")));
            customer.setGender(getSimpleValidatedInput(reader, "성별 (예: 남자/여자): ", "^(남자|여자)$"));
            customer.setAddress(getSimpleValidatedInput(reader, "주소 (예: 서울특별시 강남구): "));
            customer.setPhoneNumber(getSimpleValidatedInput(reader, "전화번호 (예: 010-1234-5678): ", "^(010-\\d{3,4}-\\d{4})$"));
            customer.setJob(getSimpleValidatedInput(reader, "직업 (예: 회사원): "));
            customer.setEmail(getSimpleValidatedInput(reader, "이메일 주소 (예: user@example.com): ", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
            customer.setBirthdate(getSimpleValidatedInput(reader, "생일 (예: YYYY-MM-DD): ", "^(19|20)\\d{2}-\\d{2}-\\d{2}$"));

            switch (insuranceType) {
                case "생명보험":
                    customer.setDisease(getSimpleValidatedInput(reader, "질병 (예: 고혈압): "));
                    customer.setDrink(getSimpleValidatedInput(reader, "음주 여부 (유/무): ", "^(유|무)$").equals("유"));
                    customer.setSmoke(getSimpleValidatedInput(reader, "흡연 여부 (유/무): ", "^(유|무)$").equals("유"));
                    break;

                case "손해보험":
                    customer.setDrive(getSimpleValidatedInput(reader, "운전 여부 (유/무): ", "^(유|무)$"));
                    customer.setCrime(getSimpleValidatedInput(reader, "범죄 기록 (유/무): ", "^(유|무)$"));
                    break;

                case "제3보험":
                    customer.setAbroad(getSimpleValidatedInput(reader, "해외 체류 여부 (유/무): ", "^(유|무)$"));
                    customer.setMiltary(getSimpleValidatedInput(reader, "군 복무 여부 (유/무): ", "^(유|무)$").equals("유"));
                    customer.setHobby(getSimpleValidatedInput(reader, "취미 (예: 등산): "));
                    break;

                default:
                    System.out.println("잘못된 보험 종류를 선택하셨습니다.");
                    return;
            }

            customer.setCustomerNumber(customerService.getNextCustomerNumber());

            saveCustomerToPendingApproval(customer, insuranceType);

            System.out.println("보험 가입 신청이 완료되었습니다. 인수 심사 후에 처리됩니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다. 초기화면으로 돌아갑니다.");
        } finally {
            pauseAndReturnToMain(reader);
        }
    }

    private String getSimpleValidatedInput(BufferedReader reader, String prompt, String regex) throws IOException {
        while (true) {
            System.out.print(prompt);
            String input = reader.readLine().trim();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("올바른 형식으로 입력해주세요.");
            }
        }
    }

    private String getSimpleValidatedInput(BufferedReader reader, String prompt) throws IOException {
        while (true) {
            System.out.print(prompt);
            String input = reader.readLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("올바른 형식으로 입력해주세요.");
            }
        }
    }

    private void saveCustomerToPendingApproval(Customer customer, String insuranceType) {
        String customerInfo = customer.toString() + "," + insuranceType;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("인수심사대기자.txt", true))) {
            writer.write(customerInfo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pauseAndReturnToMain(BufferedReader reader) throws IOException {
        System.out.println("아무 키나 눌러 초기화면으로 돌아갑니다.");
        reader.readLine();
    }

    @Override
    public void showInsuranceInfo(String typeChoice, BufferedReader reader) throws IOException {
        String fileName = "";
        String insuranceType = "";
        switch (typeChoice) {
            case "1":
                fileName = "Data/Life.txt";
                insuranceType = "생명보험";
                break;
            case "2":
                fileName = "Data/property.txt";
                insuranceType = "손해보험";
                break;
            case "3":
                fileName = "Data/thirdParty.txt";
                insuranceType = "제3보험";
                break;
            default:
                System.out.println("\n잘못된 보험 종류를 선택하셨습니다.");
                this.selectInsuranceTypeAndApply(reader);
        }

        List<String[]> insuranceList = getInsuranceList(fileName);

        while (true) {
            System.out.println("\n선택한 보험의 목록:");
            System.out.println("0. 상품 정보 요청");
            for (int i = 0; i < insuranceList.size(); i++) {
                System.out.println((i + 1) + ". " + insuranceList.get(i)[0] + " / " + insuranceList.get(i)[1]);
            }

            System.out.print("\n가입하실 보험을 입력하세요: ");
            String input = reader.readLine().trim();
            int selectedInsurance;
            try {
                selectedInsurance = Integer.parseInt(input);
                if (selectedInsurance == 0) {
                    showInsuranceList(fileName, reader);
                } else if (selectedInsurance > 0 && selectedInsurance <= insuranceList.size()) {
                    applyForInsurance(new Customer(), insuranceType);
                    break;
                } else {
                    System.out.println("\n잘못된 보험 종류를 선택하셨습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n올바르지 않은 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private List<String[]> getInsuranceList(String fileName) {
        List<String[]> insuranceList = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] insuranceDetails = new String[7];
                insuranceDetails[0] = line;
                insuranceDetails[1] = fileReader.readLine();
                insuranceDetails[2] = fileReader.readLine();
                insuranceDetails[3] = fileReader.readLine();
                insuranceDetails[4] = fileReader.readLine();
                insuranceDetails[5] = fileReader.readLine();
                insuranceDetails[6] = fileReader.readLine();
                insuranceList.add(insuranceDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insuranceList;
    }

    private void showInsuranceList(String fileName, BufferedReader reader) throws IOException {
        List<String[]> insuranceList = getInsuranceList(fileName);

        System.out.println("\n------------상품 목록------------");
        for (int i = 0; i < insuranceList.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + insuranceList.get(i)[0]);
        }

        System.out.print("\n세부정보를 확인할 보험을 선택하세요 (예: 1): ");
        String input = reader.readLine().trim();
        int selectedInsurance;
        try {
            selectedInsurance = Integer.parseInt(input);
            if (selectedInsurance > 0 && selectedInsurance <= insuranceList.size()) {
                String[] details = insuranceList.get(selectedInsurance - 1);
                System.out.println("\n[" + details[0] + "]의 세부 정보는 다음과 같습니다:");
                System.out.println("설명: " + details[1]);
                System.out.println("보험료: " + details[2]);
                System.out.println("보상 한도: " + details[3]);
                System.out.println("기간: " + details[4]);
                System.out.println("최대 나이: " + details[5]);
                System.out.println("제외 사항: " + details[6]);
            } else {
                System.out.println("\n잘못된 보험 종류를 선택하셨습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("\n올바르지 않은 입력입니다. 다시 입력해주세요.");
        }
    }

    @Override
    public void selectInsuranceTypeAndApply(BufferedReader reader) throws IOException {
        System.out.println("\n------------상품 목록------------");
        System.out.println("1. 생명보험");
        System.out.println("2. 손해보험");
        System.out.println("3. 제3보험");
        System.out.print("\n가입하실 보험을 선택해주세요: ");
        String insuranceChoice = reader.readLine().trim();

        showInsuranceInfo(insuranceChoice, reader);
    }

    @Override
    public void add(Constract Contract) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
    }

    @Override
    public void get() {
        // TODO Auto-generated method stub
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
    }
}
