package Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Insurance.Insurance;
import Insurance.InsuranceListImpl;

public class InsuranceService {

    public void insuranceInfo(BufferedReader reader) throws FileNotFoundException, IOException {
        System.out.println("----------보험 상품 메뉴----------");
        System.out.println("1. 생명 보험");
        System.out.println("2. 손해 보험");
        String choice = reader.readLine().trim();
        InsuranceListImpl insuranceList = new InsuranceListImpl("insurances.txt");
        ArrayList<Insurance> list;
        if (choice.equals("1")) {
            list = insuranceList.getLifeInsurance();
        } else if (choice.equals("2")) {
            list = insuranceList.getPropertyInsurance(); 
        } else {
            System.out.println("\n유효하지 않은 값입니다. 초기 화면으로 돌아갑니다.\n");
            return;
        }
        if (list.size() == 0) {
            System.out.println("\n해당 종류의 보험이 존재하지 않습니다. 초기 화면으로 돌아갑니다.\n");
            return;
        }
        System.out.println("----------상품 목록----------");
        for (int i = 0; i < list.size(); ++i) {
            System.out.println("[" + list.get(i).getName() + "]");
            System.out.println(list.get(i).getIntroduction());
            System.out.println("* 보험료 확인");
            System.out.println("* 상품 세부 정보");
            System.out.println("* 상품 가입");
        }
        handleInsuranceSelection(reader, list);
    }

    private void handleInsuranceSelection(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("원하는 작업을 선택하세요:");
        System.out.println("1. 보험료 확인");
        System.out.println("2. 상품 세부 정보");
        System.out.println("3. 상품 가입");
        String choice = reader.readLine().trim();
        
        switch (choice) {
            case "1":
                checkInsurancePremium(reader, list);
                break;
            case "2":
                viewInsuranceDetails(reader, list);
                break;
            case "3":
                applyForInsurance(reader, list);
                break;
            default:
                System.out.println("\n유효하지 않은 값입니다. 초기 화면으로 돌아갑니다.\n");
                break;
        }
    }

    private void checkInsurancePremium(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("보험료를 확인할 상품의 번호를 입력하세요:");
        int index = Integer.parseInt(reader.readLine().trim()) - 1;
        if (index >= 0 && index < list.size()) {
            System.out.println("[" + list.get(index).getName() + "]의 보험료는 " + list.get(index).getPremium() + "입니다.");
        } else {
            System.out.println("\n유효하지 않은 번호입니다. 초기 화면으로 돌아갑니다.\n");
        }
    }

    private void viewInsuranceDetails(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("세부 정보를 확인할 상품의 번호를 입력하세요:");
        int index = Integer.parseInt(reader.readLine().trim()) - 1;
        if (index >= 0 && index < list.size()) {
            System.out.println("[" + list.get(index).getName() + "]의 세부 정보는 다음과 같습니다:");
            System.out.println(list.get(index).getDetails());
        } else {
            System.out.println("\n유효하지 않은 번호입니다. 초기 화면으로 돌아갑니다.\n");
        }
    }

    private void applyForInsurance(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
        System.out.println("가입할 상품의 번호를 입력하세요:");
        int index = Integer.parseInt(reader.readLine().trim()) - 1;
        if (index >= 0 && index < list.size()) {
            System.out.println("[" + list.get(index).getName() + "]에 가입되었습니다.");
            // 메소드 구현 
        } else {
            System.out.println("\n유효하지 않은 번호입니다. 초기 화면으로 돌아갑니다.\n");
        }
    }
    
    public void requestPayment(BufferedReader reader) {
        // 메소드 구현 
    }

    public void requestUnderwrite(BufferedReader reader) {
        // 메소드 구현 
    }

    public void underwrite(BufferedReader reader) {
        // 메소드 구현 
    }

    public void reviewCoverage(BufferedReader reader) {
        // 메소드 구현 
    }

    public void approvePayment(BufferedReader reader) {
        // 메소드 구현 
    }

    public void insurancePayment(BufferedReader reader) {
        // 메소드 구현 
    }

    public void contractManage(BufferedReader reader) {
        // 메소드 구현 
    }

    public void infoManage(BufferedReader reader) {
        // 메서드 내용 비워두기
    }

    public void personnelManage(BufferedReader reader) {
        // 메서드 내용 비워두기
    }

    public void salesMenEdu(BufferedReader reader) {
        // 메서드 내용 비워두기
    }
    
    
}
