package Service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Constract.ConstractListImpl;
import Customer.Customer;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;
import InsuranceValue.AccidentInfo;
import InsuranceValue.RequestInsureInfo;
import InsuranceValue.RequestListImpl;


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
        if(typeChoice==null) {
        	menuService.showInsuranceTypeMenu();
        	typeChoice = reader.readLine().trim();
        }
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
                System.out.println("\n올바르지 않은 값입니다. 다시 입력해주세요. \n");
                this.showInsuranceInfo(reader, null);
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
    	
    	System.out.println("\n보험금 청구 요청(사고 접수)을 선택하셨습니다.");
    	
    	System.out.println("해당 기능은 고객만 이용할 수 있습니다. 로그인을 진행해주세요.\n");
    	System.out.print("아이디를 입력하세요: ");
    	String id = reader.readLine();
    	System.out.print("비밀번호를 입력하세요: ");
    	String pw = reader.readLine();
    	
    	UnderwritingService toGetFindCustomerMethod = new UnderwritingService();
    	Customer customer = toGetFindCustomerMethod.findCustomer(id, pw);
        if (customer == null) {
            System.out.println("\n고객 정보를 찾을 수 없습니다.");
            return;
        }
        
        System.out.println("\n로그인 성공\n");
    	
    	RequestInsureInfo reqInfo = new RequestInsureInfo();
    	AccidentInfo accInfo = new AccidentInfo();
    	ArrayList<String> inputs = new ArrayList<>();
    	
    	reqInfo.m_Customer = customer;
    	
    	System.out.println("[ 보험 계약자 정보를 입력하세요 ]");
    	String memInfoString = id + "\n" + pw + "\n";
    	
    	System.out.print("이름: ");
    	String name = reader.readLine();
    	memInfoString += name + "\n";
    	inputs.add(name);
    	
    	System.out.print("주민등록번호: ");
    	String ssn = reader.readLine().trim();
    	memInfoString += ssn + "\n";
    	inputs.add(ssn);
    	
    	System.out.print("휴대폰 번호: ");
    	String phoneNum = reader.readLine();
    	memInfoString += phoneNum + "\n";
    	inputs.add(phoneNum);
    	
    	reqInfo.setMemberInfo(memInfoString);
    	
    	System.out.println("\n[ 사고 정보를 입력하세요 ]");
    	String accInfoString = "";
    	
    	System.out.print("사고 유형: ");
    	String accType = reader.readLine();
    	accInfoString += accType + "\n";
    	accInfo.setType(accType);
    	inputs.add(accType);
    	
    	System.out.print("청구 유형: ");
    	String billType = reader.readLine();
    	accInfoString += billType + "\n";
    	accInfo.setBillType(billType);
    	inputs.add(billType);
    	
    	System.out.print("사고 날짜: ");
    	String date = reader.readLine();
    	accInfoString += date + "\n";
    	accInfo.setDate(date);
    	inputs.add(date);
    	
    	System.out.print("사고 경위: ");
    	String accDetails = reader.readLine();
    	accInfoString += accDetails + "\n";
    	accInfo.setDetails(accDetails);
    	inputs.add(accDetails);
    	
    	System.out.print("진단 병원명: ");
    	String hospital = reader.readLine();
    	accInfoString += hospital + "\n";
    	accInfo.setNameOfHospital(hospital);
    	inputs.add(hospital);
    	
    	System.out.print("진단명: ");
    	String disease = reader.readLine();
    	accInfoString += disease + "\n";
    	accInfo.setNameOfDisease(disease);
    	inputs.add(disease);
    	
    	System.out.print("사고 현장 사진 - 이미지 파일 경로: ");
    	String imagePathString = reader.readLine();
    	File file = new File(imagePathString);
    	BufferedImage bufferedImage = ImageIO.read(file);
    	Image image = bufferedImage;
    	accInfo.setScenePhoto(image);
    	inputs.add(imagePathString);
    	
    	reqInfo.setAccidentInfo(accInfoString);
    	reqInfo.m_AccidentInfo = accInfo;
    	
    	System.out.println("\n[ 보험 수익자 정보를 입력하세요 ]");
    	String beneInfoString = "";
    	
    	System.out.print("이름: ");
    	String beneName = reader.readLine();
    	beneInfoString += beneName + "\n";
    	inputs.add(beneName);
    	
    	System.out.print("계좌 번호: ");
    	String account = reader.readLine(); 
    	beneInfoString += account + "\n";
    	inputs.add(account);
    	
    	System.out.print("휴대폰 번호: ");
    	String benePhoneNum = reader.readLine();
    	beneInfoString += benePhoneNum;
    	reqInfo.setBeneficiaryInfo(beneInfoString);
    	inputs.add(benePhoneNum);
    	
    	for (int i=0; i<inputs.size(); i++) {
    		if (inputs.get(i).equals("")) {
    			System.out.println("\n입력되지 않은 정보가 있습니다.");
    		    System.out.println("메뉴를 다시 선택해 필수 정보를 모두 입력해주세요.");
    		    return;
    		}
    	}
    	
    	System.out.println("\n청구 접수가 완료되었습니다. 담당자가 고객님의 휴대폰으로 연락드리겠습니다.");
    	System.out.println("\n------------------------------------\n");
    	
    	System.out.println("[알림] 고객으로부터 사고가 접수되었습니다.");
    	System.out.println("Enter를 눌러 정보를 확인하십시오.");
    	
    	while (true) if (reader.readLine().trim().equals("")) break;
    	
    	System.out.println("----------- 청구 정보 -----------\n");
    	System.out.println("[ 보험 계약자 정보 ]");
    	String[] tokens = reqInfo.getMemberInfo().split("\n");
    	printMemberInfo(tokens);
    	
    	System.out.println("[ 사고 정보 ]");
    	tokens = reqInfo.getAccidentInfo().split("\n");
    	printAccInfo(tokens);
    	
    	System.out.print("고객이 제출한 사고 현장 사진을 저장할 폴더 경로를 입력하세요: ");
    	String targetFolderPathString = reader.readLine();
    	Path targetFolderPath = Paths.get(targetFolderPathString);
    	Path imagePath = Paths.get(imagePathString);
    	Path fileName = imagePath.getFileName();
    	Path targetPath = targetFolderPath.resolve(fileName);
    	Files.copy(imagePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    	System.out.println("파일이 성공적으로 저장되었습니다.\n");
    	accInfo.setPhotoPath(targetPath);
    	reqInfo.m_AccidentInfo = accInfo;
    	
    	System.out.println("[ 보험 수익자 정보 ]");
    	tokens = reqInfo.getBeneficiaryInfo().split("\n");
    	printBeneInfo(tokens);
    	
    	System.out.println("Enter를 눌러 보험 약관을 확인하십시오.");
    	
    	while (true) if (reader.readLine().trim().equals("")) break;
    	
    	printGeneralTerm("Data/generalTerm.txt");
    	
    	System.out.println("\n해당 버튼을 눌러주세요.");
    	String choice;
    	
    	while (true) {
    		System.out.println("1. 사고 접수 승인");
        	System.out.println("2. 사고 접수 거부");
    	    choice = reader.readLine().trim();
    	    if (choice.equals("1")) {
    		    System.out.println("사고 접수가 승인되었습니다. 보험금 지급 심사가 요청되었습니다. 고객에게 결과를 알립니다.");
    		    RequestListImpl requestList = new RequestListImpl("coverageRequests.txt");
    		    requestList.add("coverageRequests.txt", reqInfo);
    		    System.out.println("\n------------------------------------\n");
    		    System.out.println("[알림] 보험 회사로부터 사고 접수가 승인되었습니다.");
    		    System.out.println("보험금 지급 심사가 진행 중에 있습니다.");
    		    break;
    	    } else if (choice.equals("2")) {
    		    System.out.println("사고 접수가 거부되었습니다. 고객에게 결과를 알립니다.");
    		    System.out.println("\n------------------------------------\n");
    		    System.out.println("[알림] 보험 회사로부터 사고 접수가 거부되었습니다.");
    		    System.out.println("사유: 사고 정보 미비");
    		    System.out.println("올바르게 정보를 입력해 다시 한 번 접수해주시기 바랍니다.");
    		    break;
    	    } else {
    		    System.out.println("올바르지 않은 값입니다. 다시 입력해주세요.");
    	    }
    	}

    }

    public void requestUnderwrite(BufferedReader reader) {
        // 구현
    }

    public void underwrite(BufferedReader reader) {
        // 구현
    }

    public void reviewCoverage(BufferedReader reader) {
        // 6. 보상 검토
    	// Use case 사고 서류를 심사한다 - Scenario '보험금 지급 심사' 메뉴를 클릭한다
    	System.out.println("\n보험금 지급 심사를 선택하셨습니다.");
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
    
    public void printGeneralTerm(String fileName) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(fileName));
    	String line;
    	while ((line = reader.readLine()) != null) {
    		System.out.println(line);
    	}
    	reader.close();
    }
    
    public void printMemberInfo(String[] tokens) {
    	int i = 0;
    	System.out.println("ID: " + tokens[i++]);
    	System.out.println("PW: " + tokens[i++]);
    	System.out.println("이름: " + tokens[i++]);
    	System.out.println("주민등록번호: " + tokens[i++]);
    	System.out.println("휴대폰 번호: " +  tokens[i++]);
    	System.out.println();
    }
    
    public void printAccInfo(String[] tokens) {
    	int i = 0;
    	System.out.println("사고 유형: " + tokens[i++]);
    	System.out.println("청구 유형: " + tokens[i++]);
    	System.out.println("사고 날짜: " + tokens[i++]);
    	System.out.println("사고 경위: " + tokens[i++]);
    	System.out.println("진단 병원명: " + tokens[i++]);
    	System.out.println("진단명: " + tokens[i++]);
    	System.out.println();
    }
    
    public void printBeneInfo(String[] tokens) {
    	int i = 0;
    	System.out.println("이름: " + tokens[i++]);
    	System.out.println("계좌 번호: " + tokens[i++]);
    	System.out.println("휴대폰 번호: " + tokens[i++]);
    	System.out.println();
    }
}
