package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Employee.ProductDevelopmentPlan;


public class ProductDevelopmentService {
	
	private ArrayList<ProductDevelopmentPlan> planList = new ArrayList<ProductDevelopmentPlan>();
	private ArrayList<ProductDevelopmentPlan> denialList = new ArrayList<ProductDevelopmentPlan>();	
    public void productDevelop(BufferedReader reader) throws IOException {
        try {
            System.out.println("----------보험 상품 개발 메뉴----------");
            System.out.println("1. 컨셉트 보고서 & 시장조사 정보 확인");
            System.out.println("2. 상품유형 선택");
            System.out.println("3. 보험 재설계");
            System.out.println("4. 최종 판매 승인");
            String choice = reader.readLine().trim();
    
            if (choice.equals("1")) {
                System.out.println("----------컨셉트 보고서 & 시장조사 정보----------");
                System.out.println("컨셉트 보고서(example)");
                System.out.println("시장조사 정보(example)(시장 크기 및 전망, 고객 분석, 경쟁 분석, 위험도 분석, 규제 환경 기술, 기술 트렌드");
                System.out.println("1. 확인");
                choice = reader.readLine().trim();
                
                if (choice.equals("1")) {
                    productDevelop(reader);
                }
                
            } else if (choice.equals("2")) {
                System.out.println("----------상품유형 선택----------");
                System.out.println("1. 손해보험");
                System.out.println("2. 생명보험");
                System.out.println("3. 제3보험");
                choice = reader.readLine().trim();
                
                if (choice.equals("1")) {
                	ProductDevelopmentPlan productDevelopmentPlan = new ProductDevelopmentPlan();
                	System.out.println("----------보험 컨셉트 정보 입력----------");
                	productDevelopmentPlan.setType("손해보험");
                	productDevelopSub(reader, productDevelopmentPlan);
                	return;
                } else if (choice.equals("2")) {
                	ProductDevelopmentPlan productDevelopmentPlan = new ProductDevelopmentPlan();
                	System.out.println("----------보험 컨셉트 정보 입력----------");
                	productDevelopmentPlan.setType("생명보험");
                	productDevelopSub(reader, productDevelopmentPlan);
                	return;
                } else if (choice.equals("3")) {
                	ProductDevelopmentPlan productDevelopmentPlan = new ProductDevelopmentPlan();
                	System.out.println("----------보험 컨셉트 정보 입력----------");
                	productDevelopmentPlan.setType("제3보험");
                	productDevelopSub(reader, productDevelopmentPlan);
                	return;
                }
                
            } else if (choice.equals("3")) {
            	System.out.println("----------보험 재설계----------");
            	int i = 0;
            	for (ProductDevelopmentPlan productDevelopmentPlan : denialList){
            		System.out.println(Integer.toString(i+1)+". "+productDevelopmentPlan.getName());
            	}
            	choice = reader.readLine().trim();
            	if (choice != "0") {
            		int index = Integer.parseInt(choice)-1;
            		ProductDevelopmentPlan productDevelopmentPlan = planList.get(Integer.parseInt(choice)-1);
            		System.out.println("----------보험 컨셉트 정보----------");
            		System.out.print("1. 가제목: ");
                	System.out.println(productDevelopmentPlan.getName());
                	System.out.print("2. 설명: ");
                	System.out.println(productDevelopmentPlan.getDescription());
                	System.out.print("3. 보험료: ");
                	System.out.println(productDevelopmentPlan.getPremium());
                	System.out.print("4. 보상 한도: ");
                	System.out.println(productDevelopmentPlan.getCoverage());
                	System.out.print("5. 기간: ");
                	System.out.println(productDevelopmentPlan.getTerm());
                	System.out.print("6. 최대 나이: ");
                	System.out.println(productDevelopmentPlan.getMaxAge());
                	System.out.print("7. 제외 사항: ");
                	System.out.println(productDevelopmentPlan.getExclusion());
                	System.out.print("8. 수정을 원하는 정보 선택: ");
                	choice = reader.readLine().trim();
                	
                	if (choice.equals("1")) {
                		System.out.print("1. 가제목 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setName(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                		
                	} else if (choice.equals("2")) {
                		System.out.print("1. 설명 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setDescription(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                		
                	} else if (choice.equals("3")) {
                		System.out.print("1. 보험료 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setPremium(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                		
                	} else if (choice.equals("4")) {
                		System.out.print("1. 보상 한도 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setCoverage(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                		
                	} else if (choice.equals("5")) {
                		System.out.print("1. 기간 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setTerm(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                		
                	} else if (choice.equals("6")) {
                		System.out.print("1. 최대 나이 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setMaxAge(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                		
                	} else if (choice.equals("7")) {
                		System.out.print("1. 제외 사항 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setExclusion(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                	}
                	
                	System.out.println("----------예상 위험률 및 보험료----------");
                	System.out.println("예상 위험률(example) 높음");
                	System.out.println("예상 보험료(example) "+productDevelopmentPlan.getPremium());
                	System.out.println("1. 다음");
                	choice = reader.readLine().trim();
                	
                	System.out.println("----------파일 업로드 창----------");
                	System.out.println("1. 파일 업로드: ");
                	choice = reader.readLine().trim();
                	System.out.println("2. 제출: ");
                	choice = reader.readLine().trim();
                	planList.set(index, productDevelopmentPlan);
                	System.out.println("금융감독원 최종 판매 가능 결과가 나왔습니다. 확인해주세요.");
            	}
            } else if (choice.equals("4")) {
            	System.out.println("----------최종 판매 승인----------");
            	int i = 0;
            	for (ProductDevelopmentPlan productDevelopmentPlan : planList){
            		System.out.println(Integer.toString(i+1)+". "+productDevelopmentPlan.getName());
            	}
            	choice = reader.readLine().trim();
            	if (choice != "0") {
            		ProductDevelopmentPlan productDevelopmentPlan = planList.get(Integer.parseInt(choice)-1);
            		System.out.println("1. 최종상품 파일 업로드: ");
                	choice = reader.readLine().trim();
                	System.out.println("2. 내부 판매 준비 파일 업로드: ");
                	choice = reader.readLine().trim();
                	System.out.println("3. 승인 ");
                	System.out.println("4. 거절 ");
                	choice = reader.readLine().trim();
                	if (choice.equals("3")) {
                		productRegistration(productDevelopmentPlan);
                		System.out.println("신규 상품 개발이 정상적으로 완료되었습니다.");
                	} else if (choice.equals("4")) {
                		denialList.add(productDevelopmentPlan);
                		System.out.println("신규 상품 승인이 거절되었습니다.");
                	}
                	return;
            	}
            	
            } else {
                System.out.println("\n유효하지 않은 값입니다. 초기 화면으로 돌아갑니다.\n");
                return;
            }
        } catch(Exception e) {
            System.out.println("시스템에 문제가 생겨서 화면이 나오지 않습니다. 다시 시도해주세요");
        }
    }
    
    private void productRegistration(ProductDevelopmentPlan productDevelopmentPlan) {
    	String type = productDevelopmentPlan.getType();
    	String filePath;
    	switch (type) {
	    	case "생명보험":
	    		filePath = "Data/Life.txt";
	    		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
	    			
	    			bw.newLine();
	                bw.write(productDevelopmentPlan.getName());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getDescription());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getPremium());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getCoverage());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getTerm());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getMaxAge());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getExclusion());
	                
	                break;
	                
	            } catch (IOException e) {
	                System.out.println("오류로 인해 상품 등록에 실패했습니다. 다시 시도해 주세요.");
	                e.printStackTrace();
	            }
	    	case "손해보험":
	    		filePath = "Data/property.txt";
	    		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

	    			bw.newLine();
	                bw.write(productDevelopmentPlan.getName());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getDescription());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getPremium());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getCoverage());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getTerm());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getMaxAge());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getExclusion());
	                
	                break;
	                
	            } catch (IOException e) {
	                System.out.println("오류로 인해 상품 등록에 실패했습니다. 다시 시도해 주세요.");
	                e.printStackTrace();
	            }
	    	case "제3보험":
	    		filePath = "Data/thirdParty.txt";
	    		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
	    			
	    			bw.newLine();
	                bw.write(productDevelopmentPlan.getName());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getDescription());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getPremium());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getCoverage());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getTerm());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getMaxAge());
	                bw.newLine();
	                bw.write(productDevelopmentPlan.getExclusion());
	                
	                break;
	                
	            } catch (IOException e) {
	                System.out.println("오류로 인해 상품 등록에 실패했습니다. 다시 시도해 주세요.");
	                e.printStackTrace();
	            }
	    	default:
	    		System.out.println("보험 유형이 잘못되었습니다. 다시 확인해주세요.");
    	}
	}

	@SuppressWarnings("unused")
	private void productDevelopSub(BufferedReader reader, ProductDevelopmentPlan productDevelopmentPlan) throws IOException {
    	String choice;
    	System.out.println("가제목 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setName(choice);
    	System.out.println("설명 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setDescription(choice);
    	System.out.println("보험료 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setPremium(choice);
    	System.out.println("보상한도 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setCoverage(choice);
    	System.out.println("기간 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setTerm(choice);
    	System.out.println("최대 나이 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setMaxAge(choice);
    	System.out.println("제외 사항 입력:");
    	choice = reader.readLine().trim();
    	productDevelopmentPlan.setExclusion(choice);
    
    	System.out.println("1. 다음");
    	System.out.println("2. 취소");
    	choice = reader.readLine().trim();
    	if (choice == "2") {
    		productDevelop(reader);
    	}
    	
    	System.out.println("----------예상 위험률 및 보험료----------");
    	System.out.println("예상 위험률(example) 높음");
    	
    	System.out.println("예상 보험료(example) "+productDevelopmentPlan.getPremium());
    	System.out.println("1. 다음");
    	choice = reader.readLine().trim();
    	
    	System.out.println("----------파일 업로드 창----------");
    	System.out.println("1. 파일 업로드: ");
    	choice = reader.readLine().trim();
    	System.out.println("2. 제출: ");
    	choice = reader.readLine().trim();
    	planList.add(productDevelopmentPlan);
    	System.out.println("금융감독원 최종 판매 가능 결과가 나왔습니다. 확인해주세요.");
    }
}
