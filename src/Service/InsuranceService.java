package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;
import Constract.ConstractListImpl;
import Customer.Customer;

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

    public void approvePayment(BufferedReader reader) throws IOException {
    	ArrayList<Customer> customerList2 = constractList.loadCustomer("보험금지급승인요청목록.txt");
    	String choice;
    	
    	System.out.println("\n------------보험금 지급 승인 메뉴------------");
    	for (int i = 0; i < customerList2.size(); ++i) {
            System.out.println((i + 1) + ". " + customerList2.get(i).getName() + " / " + customerList2.get(i).getId());
        }
    	System.out.println("\n승인 대상을 선택하세요:");
    	choice = reader.readLine().trim();
    	
    	Customer customer2 = customerList2.get(Integer.parseInt(choice)-1);
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("보험금지급대기목록.txt", true))) {
    		writer.write(customer2.toString());
            writer.newLine();
            
            System.out.println("보험금 지급 승인이 완료되었습니다.");
            customerList2.remove(Integer.parseInt(choice) - 1);
            if (customerList2.isEmpty()) {
            	try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("보험금지급승인요청목록.txt"))) {
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
            } else {
            	for (Customer cus : customerList2) {
            		try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("보험금지급승인요청목록.txt"))) {
    	                writer2.write(cus.toString());
    	                writer2.newLine();
    	            } catch (IOException e) {
    	                e.printStackTrace();
    	            }
            	}
            }
        	
        } catch (IOException e) {
        	System.out.println("서류를 불러오는데 실패했씁니다.");
            e.printStackTrace();
        }
    }

    public void insurancePayment(BufferedReader reader) throws IOException {
    	System.out.println("\n------------보험금 지급 메뉴------------");
        System.out.println("1. 보험금 지급 승인 요청");
        System.out.println("2. 보험금 지급");
        System.out.println("\n원하는 서비스를 선택하세요:");
        String choice = reader.readLine().trim();
        
        
        switch (choice) {
	        case "1":
	        	ArrayList<Customer> customerList = constractList.loadCustomer("고객명단.txt");
	        	System.out.println("\n------------보험금 지급 승인 요청 메뉴------------");
	        	for (int i = 0; i < customerList.size(); ++i) {
	                System.out.println((i + 1) + ". " + customerList.get(i).getName() + " / " + customerList.get(i).getId());
	            }
	        	System.out.println("\n승인 요청 대상을 선택하세요:");
	        	choice = reader.readLine().trim();
	        	
	        	Customer customer = customerList.get(Integer.parseInt(choice)-1);
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("보험금지급승인요청목록.txt", true))) {
	                writer.write(customer.toString());
	                writer.newLine();
	                System.out.println("보험금 지급 승인 요청이 완료되었습니다.");
	            } catch (IOException e) {
	            	System.out.println("화면 로드에 실패했습니다. 다시 시도해 주세요.");
	                e.printStackTrace();
	            }
	            break;
	        case "2":
	        	ArrayList<Customer> customerList3 = constractList.loadCustomer("보험금지급대기목록.txt");
	        	System.out.println("\n------------보험금 지급 메뉴------------");
	        	for (int i = 0; i < customerList3.size(); ++i) {
	                System.out.println((i + 1) + ". " + customerList3.get(i).getName() + " / " + customerList3.get(i).getId());
	            }
	        	System.out.println("\n지급 대상을 선택하세요:");
	        	choice = reader.readLine().trim();
	        	
	        	Customer customer3 = customerList3.get(Integer.parseInt(choice)-1);
	        	
	        	ArrayList<Insurance> inslist;
	        	switch (customer3.getSelectedInsuranceType()) {
		            case "생명보험":
		            	inslist = insuranceList.loadInsurance("Data/Life.txt");
		                break;
		            case "손해보험":
		            	inslist = insuranceList.loadInsurance("Data/property.txt");
		                break;
		            case "제3보험":
		            	inslist = insuranceList.loadInsurance("Data/thirdParty.txt");
		                break;
		            default:
		                System.out.println("\n올바르지 않은 값입니다. 다시 입력해주세요. \n");
		                this.showInsuranceInfo(reader, null);
		                return;
	        	}
	        	ArrayList<Insurance> insList2 = new ArrayList<Insurance>();
	        	for (int i = 0; i < inslist.size(); ++i) {
	                if (customer3.getSelectedInsuranceName().equals(inslist.get(i).getName())) {
	                	insList2.add(inslist.get(i));
	                }
	            }
	        	
	        	System.out.println(customer3.getName()+"님의 "+customer3.getAccount()+" 계좌로 "+insList2.get(0).getCoverage()+" 보험금이 지급되었습니다.");
	        	System.out.println("보험금 지급 절차가 완료되었습니다.");
	        	
	        	customerList3.remove(Integer.parseInt(choice) - 1);
	            if (customerList3.isEmpty()) {
	            	try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("보험금지급대기목록.txt"))) {
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
	            } else {
	            	for (Customer cus : customerList3) {
	            		try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("보험금지급대기목록.txt"))) {
	    	                writer2.write(cus.toString());
	    	                writer2.newLine();
	    	            } catch (IOException e) {
	    	                e.printStackTrace();
	    	            }
	            	}
	            }
	        	
	            break;            
	        default:
	            System.out.println("\n유효하지 않은 값입니다. 다시 입력해주세요.\n");
        }
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
