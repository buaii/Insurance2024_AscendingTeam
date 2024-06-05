package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import Constract.ConstractListImpl;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;
import InsuranceValue.AccidentInfo;
import InsuranceValue.RequestInsureInfo;

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

    public void requestPayment(BufferedReader reader) throws IOException {
    	
    	RequestInsureInfo reqInfo = new RequestInsureInfo();
    	AccidentInfo accInfo = new AccidentInfo();
    	
    	System.out.println("\n---------- 보험금 청구 요청 ----------\n");
    	
    	System.out.println("[ 보험 계약자 정보를 입력하세요 ]");
    	System.out.print("이름: ");
    	String memInfo = reader.readLine() + "\n";
    	System.out.print("주민등록번호: ");
    	String ssn = reader.readLine().trim();
    	memInfo += ssn + "\n";
    	System.out.print("휴대폰 번호: ");
    	memInfo += reader.readLine().trim() + "\n";
    	reqInfo.setMemberInfo(memInfo);
    	
    	System.out.println("\n[ 사고 정보를 입력하세요 ]");
    	System.out.print("사고 유형: ");
    	String input = reader.readLine();
    	String accInfoStr = input + "\n";
    	accInfo.setType(input);
    	System.out.print("청구 유형: ");
    	input = reader.readLine();
    	accInfoStr += input + "\n";
    	accInfo.setBillType(input);
    	System.out.print("사고 날짜: ");
    	input = reader.readLine();
    	accInfoStr += input + "\n";
    	accInfo.setDate(input);
    	System.out.print("사고 경위: ");
    	input = reader.readLine();
    	accInfoStr += input + "\n";
    	accInfo.setDetails(input);
    	System.out.print("진단 병원명: ");
    	input = reader.readLine();
    	accInfoStr += input + "\n";
    	accInfo.setNameOfHospital(input);
    	System.out.print("진단명: ");
    	input = reader.readLine();
    	accInfoStr += input + "\n";
    	accInfo.setNameOfDisease(input);
    	/* System.out.print("사고 현장 사진: ");
    	accInfo.setScenePhoto(null); */
    	reqInfo.setAccidentInfo(accInfoStr);
    	reqInfo.m_AccidentInfo = accInfo;
    	
    	System.out.println("\n[ 보험 수익자 정보를 입력하세요 ]");
    	System.out.print("이름: ");
    	String beneInfo = reader.readLine() + "\n";
    	System.out.print("계좌 번호: ");
    	beneInfo += reader.readLine().trim() + "\n";
    	System.out.print("휴대폰 번호: ");
    	beneInfo += reader.readLine().trim() + "\n";
    	reqInfo.setBeneficiaryInfo(beneInfo);
    	
    	// 보험 가입자인지 체크
    	// ContractList에서 UserID로 가입자 찾기
    	// 보험 가입자가 아니면 청구 접수 불가 출력
    	
    	System.out.println("\n청구 접수가 완료되었습니다. 담당자가 고객님의 휴대폰으로 연락드리겠습니다.");
    	System.out.println("\n------------------------------------\n");
    	
    	System.out.println("[알림] 고객으로부터 사고가 접수되었습니다.");
    	System.out.println("Enter를 눌러 확인하십시오.");
    	
    	if (!reader.readLine().trim().equals("")) return;
    	
    	System.out.println("----------- 청구 정보 -----------\n");
    	System.out.println("[ 보험 계약자 정보 ]");
    	System.out.println(reqInfo.getMemberInfo());
    	System.out.println("[ 사고 정보 ]");
    	System.out.println(reqInfo.getAccidentInfo());
    	System.out.println("[ 보험 수익자 정보 ]");
    	System.out.println(reqInfo.getBeneficiaryInfo());
    	System.out.println("Enter를 눌러 사고 관련 보험 약관을 확인하십시오.");
    	
    	if (!reader.readLine().trim().equals("")) return;
    	
    	// 해당 고객이 가입한 보험의 약관을 출력
    	

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
