package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;
import Constract.ConstractListImpl;

public class InsuranceService {

    private InsuranceListImpl insuranceList;
    private MenuService menuService;
    private ConstractListImpl constractList;
    
    public InsuranceService(CustomerService customerService) {
        this.insuranceList = new InsuranceListImpl();
        this.menuService = new MenuService();
        this.constractList = new ConstractListImpl(customerService);
    }

    public void handleInsuranceMenu(BufferedReader reader) throws IOException {
        menuService.showInsuranceMenu();
        String choice = reader.readLine().trim();
        switch (choice) {
            case "1":
                menuService.showInsuranceTypeMenu();
                String typeChoice = reader.readLine().trim();
               this.showInsuranceInfo(reader, typeChoice);
                break;
            case "2":
            	constractList.selectInsuranceTypeAndApply(reader);
                break;
            default:
                System.out.println("\n올바르지 않은 입력입니다. 다시 입력해주세요");
                this.handleInsuranceMenu(reader);
                
        }
    }
    

    public void showInsuranceInfo(BufferedReader reader, String typeChoice) throws IOException {
        ArrayList<Insurance> list;
        switch (typeChoice) {
            case "1":
                list = insuranceList.loadInsurance("Data/Life.txt");
                break;
            case "2":
                list = insuranceList.loadInsurance("Data/property.txt");
                break;
            case "3":
                list = insuranceList.loadInsurance("Data/thirdParty.txt");
                break;
            default:
                System.out.println("\n유효하지 않은 값입니다. 초기 화면으로 돌아갑니다.\n");
                return;
        }

        if (list.size() == 0) {
            System.out.println("\n해당 종류의 보험이 존재하지 않습니다. 초기 화면으로 돌아갑니다.\n");
            return;
        }

        System.out.println("\n------------상품 목록------------");
        for (int i = 0; i < list.size(); ++i) {
            System.out.println("[" + list.get(i).getName() + "]");
            System.out.println(list.get(i).getDescription());
        }
        handleInsuranceSelection(reader, list);
    }

    private void handleInsuranceSelection(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("\n1. 보험료 확인");
        System.out.println("2. 상품 세부 정보");
        System.out.println("3. 상품 가입");
        System.out.println("\n원하는 서비스를 선택하세요:");
        String choice = reader.readLine().trim();

        switch (choice) {
            case "1":
                checkInsurancePremium(reader, list);
                break;
            case "2":
                viewInsuranceDetails(reader, list);
                break;
            case "3":
            	constractList.selectInsuranceTypeAndApply(reader);
                break;
            default:
                System.out.println("\n유효하지 않은 값입니다. 다시 입력해주세요.\n");
                this.handleInsuranceSelection(reader, list);
        }
    }

    private void checkInsurancePremium(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("\n보험료를 확인할 상품의 번호를 입력하세요:");
        for (int i = 0; i < list.size(); ++i) {
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        int index = Integer.parseInt(reader.readLine().trim()) - 1;
        if (index >= 0 && index < list.size()) {
            System.out.println("\n[" + list.get(index).getName() + "]의 보험료는 " + list.get(index).getPremium() + "입니다.");
            this.handleInsuranceSelection(reader, list);
        } else {
            System.out.println("\n유효하지 않은 번호입니다. 다시 입력해주세요.");
            this.checkInsurancePremium(reader, list);
        }
    }

    private void viewInsuranceDetails(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("\n세부 정보를 확인할 상품의 번호를 입력하세요:");
        for (int i = 0; i < list.size(); ++i) {
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        int index = Integer.parseInt(reader.readLine().trim()) - 1;
        if (index >= 0 && index < list.size()) {
            System.out.println("\n[" + list.get(index).getName() + "]의 세부 정보는 다음과 같습니다:");
            System.out.println("설명: " + list.get(index).getDescription());
            System.out.println("보험료: " + list.get(index).getPremium());
            System.out.println("보상 한도: " + list.get(index).getCoverage());
            System.out.println("기간: " + list.get(index).getTerm());
            System.out.println("최대 나이: " + list.get(index).getMaxAge());
            System.out.println("제외 사항: " + list.get(index).getExclusions());
            this.handleInsuranceSelection(reader, list);
        } else {
        	System.out.println("\n유효하지 않은 번호입니다. 다시 입력해주세요.");
        	this.viewInsuranceDetails(reader, list);
        }
    }

    public void requestPayment(BufferedReader reader) {
        // 구현
    }

    public void requestUnderwrite(BufferedReader reader) {
        // 구현
    }

    public void underwrite(BufferedReader reader) {
        // 구현
    }

    public void reviewCoverage(BufferedReader reader) {
        // 구현
    }

    public void approvePayment(BufferedReader reader) {
        // 구현
    }

    public void insurancePayment(BufferedReader reader) {
        // 구현
    }

    public void contractManage(BufferedReader reader) {
        // 구현
    }

    public void infoManage(BufferedReader reader) {
        // 구현
    }

    public void personnelManage(BufferedReader reader) {
        // 구현
    }

    public void salesMenEdu(BufferedReader reader) {
        // 구현
    }
}
