package Service;

import java.io.BufferedReader;
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
                choice = reader.readLine().trim();
                
                if (choice.equals("1")) {
                	ProductDevelopmentPlan productDevelopmentPlan = new ProductDevelopmentPlan();
                	System.out.println("----------보험 컨셉트 정보 입력----------");
                	productDevelopmentPlan.setType("손해보험");
                	System.out.println("1. 가제목 입력:");
                	choice = reader.readLine().trim();
                	productDevelopmentPlan.setName(choice);
                	System.out.println("2. 타깃 시장 입력:");
                	choice = reader.readLine().trim();
                	productDevelopmentPlan.setMarketInfo(choice);
                	System.out.println("3. 상품 수익성 기대치 입력:");
                	choice = reader.readLine().trim();
                	productDevelopmentPlan.setCalculationInfo(choice);
                	System.out.println("4. 다음");
                	choice = reader.readLine().trim();
                	
                	System.out.println("----------예상 위험률 및 보험료----------");
                	System.out.println("예상 위험률(example) 높음");
                	System.out.println("예상 보험료(example) 19,000원");
                	System.out.println("1. 다음");
                	choice = reader.readLine().trim();
                	
                	System.out.println("----------파일 업로드 창----------");
                	System.out.println("1. 파일 업로드: ");
                	choice = reader.readLine().trim();
                	System.out.println("2. 제출: ");
                	choice = reader.readLine().trim();
                	planList.add(productDevelopmentPlan);
                	System.out.println("금융감독원 최종 판매 가능 결과가 나왔습니다. 확인해주세요.");
                	return;
                } else if (choice.equals("2")) {
                	ProductDevelopmentPlan productDevelopmentPlan = new ProductDevelopmentPlan();
                	System.out.println("----------보험 컨셉트 정보 입력----------");
                	productDevelopmentPlan.setType("생명보험");
                	System.out.println("1. 가제목 입력:");
                	choice = reader.readLine().trim();
                	productDevelopmentPlan.setName(choice);
                	System.out.println("2. 타깃 시장 입력:");
                	choice = reader.readLine().trim();
                	productDevelopmentPlan.setMarketInfo(choice);
                	System.out.println("3. 상품 수익성 기대치 입력:");
                	choice = reader.readLine().trim();
                	productDevelopmentPlan.setCalculationInfo(choice);
                	System.out.println("4. 다음");
                	choice = reader.readLine().trim();
                	
                	System.out.println("----------예상 위험률 및 보험료----------");
                	System.out.println("예상 위험률(example) 높음");
                	System.out.println("예상 보험료(example) 19,000원");
                	System.out.println("1. 다음");
                	choice = reader.readLine().trim();
                	
                	System.out.println("----------파일 업로드 창----------");
                	System.out.println("1. 파일 업로드: ");
                	choice = reader.readLine().trim();
                	System.out.println("2. 제출: ");
                	choice = reader.readLine().trim();
                	planList.add(productDevelopmentPlan);
                	System.out.println("금융감독원 최종 판매 가능 결과가 나왔습니다. 확인해주세요.");
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
                	System.out.print("2. 타깃 시장: ");
                	System.out.println(productDevelopmentPlan.getMarketInfo());
                	System.out.print("3. 상품 수익성 기대치: ");
                	System.out.println(productDevelopmentPlan.getCalculationInfo());
                	System.out.print("4. 수정을 원하는 정보 선택: ");
                	choice = reader.readLine().trim();
                	if (choice.equals("1")) {
                		System.out.print("1. 가제목 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setName(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                	} else if (choice.equals("2")) {
                		System.out.print("1. 타깃 시장 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setMarketInfo(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                	} else if (choice.equals("3")) {
                		System.out.print("1. 상품 수익성 기대치 수정: ");
                		choice = reader.readLine().trim();
                		productDevelopmentPlan.setCalculationInfo(choice);
                		System.out.print("2. 확인 ");
                		choice = reader.readLine().trim();
                	}
                	System.out.println("----------예상 위험률 및 보험료----------");
                	System.out.println("예상 위험률(example) 높음");
                	System.out.println("예상 보험료(example) 19,000원");
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
}
