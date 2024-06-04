package Service;

import java.util.Scanner;

import Constract.ConstractListImpl;
import Customer.Customer;

public class MenuService {
	
    public void showMenu() {
        System.out.println("\n----------고객 메뉴----------");
        System.out.println("1. 보험 상품 메뉴");
        System.out.println("2. 보험금 청구 요청");
        System.out.println("3. 긴급 출동 요청");
        System.out.println("4. 고객 지원");
        System.out.println("\n----------직원 메뉴----------");
        System.out.println("5. 보험 상품 개발");
        System.out.println("6. 마케팅 전략 개발");
        System.out.println("7. 시장 분석");
        System.out.println("8. 언더라이팅 요청");
        System.out.println("9. 언더라이팅 처리");
        System.out.println("10. 보상 검토");
        System.out.println("11. 보험금 지급 승인");
        System.out.println("12. 보험금 지급");
        System.out.println("13. 계약 관리");
        System.out.println("14. 정보 관리");
        System.out.println("15. 인사 관리");
        System.out.println("16. 영업 사원 교육");
        System.out.println("17. 해피콜");
        System.out.println("18. 지원 제공");
        System.out.println("x. 종료");
        System.out.println("---------------------------------");
        System.out.print("\n원하는 서비스를 선택하세요 : ");
    }

    public void showInsuranceMenu() {
        System.out.println("\n-----------보험 상품 메뉴-----------");
        System.out.println("1. 상품 정보 요청");
        System.out.println("2. 보험 가입");
        System.out.println("---------------------------------");
        System.out.print("\n원하는 서비스를 선택하세요 : ");
    }

    public void showInsuranceTypeMenu() {
        System.out.println("\n-----------상품 정보 메뉴-----------");
        System.out.println("1. 생명보험");
        System.out.println("2. 손해보험");
        System.out.println("3. 제3보험");
        System.out.println("---------------------------------");
        System.out.print("\n원하는 상품 번호를 입력하세요 : ");
    }

    
    
}
