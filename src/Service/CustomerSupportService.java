package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

import Employee.Complaints;

public class CustomerSupportService {

    public void roadsideAssist(BufferedReader reader) throws IOException {
        System.out.println("긴급 출동 요청을 선택하셨습니다.");
        // 메소드 구현 
    }

    public void requestSupport(BufferedReader reader) throws IOException {
        System.out.println("고객 지원 요청을 선택하셨습니다.");
        // 메소드 구현
    }

    public void happyCall(BufferedReader reader) throws IOException {
        System.out.println("해피콜을 선택하셨습니다.");
        // 메소드 구현
    }

    public void offerSupport(BufferedReader reader) throws IOException {
        try {
            System.out.println("----------고객 지원 메뉴----------");
            System.out.println("1. 민원 신청");
            System.out.println("2. 민원 접수");
            String choice = reader.readLine().trim();
            Complaints complaints = new Complaints();
    
            if (choice.equals("1")) {
                System.out.println("----------민원 신청----------");
                System.out.print("1. 고객 ID 입력 : ");
                choice = reader.readLine().trim();
                complaints.setCustomerID(choice);
                
                System.out.print("2. 고객 정보 입력 : 이름/핸드폰번호");
                choice = reader.readLine().trim();
                if (choice.equals("")) {
                    System.out.println("존재하지 않는 고객 정보입니다. 입력한 내용을 다시 확인해주세요.");
                }
                complaints.setCustomerInfo(choice);
                
                System.out.print("3. 제목 입력 : ");
                choice = reader.readLine().trim();
                complaints.setTitle(choice);
                
                System.out.print("4. 민원 내용 입력 : ");
                choice = reader.readLine().trim();
                complaints.setDetails(choice);
                // 날짜 자동 입력
                LocalDateTime currentDateTime = LocalDateTime.now();
                complaints.setDate(currentDateTime.toString());
                
                System.out.print("5.확인/6.취소 : ");
                choice = reader.readLine().trim();
                if (choice.equals("5")) {
                    System.out.println("민원신청이 완료되었습니다.");
                } else {
                    System.out.println("민원신청이 취소되었습니다.");
                }
                
            } else if (choice.equals("2")) {
                System.out.println("----------민원 확인----------");
                System.out.println("1. 고객 ID : " + complaints.getCustomerID());
                System.out.println("2. 고객 정보 : " + complaints.getCustomerInfo());
                System.out.println("3. 제목 : " + complaints.getTitle());
                System.out.println("4. 접수날짜 : " + complaints.getDate());
                System.out.println("5. 민원 내용 : " + complaints.getDetails());
                System.out.println("----------민원 담당부서 배치----------");
                System.out.print("1. 담당부서 배치 : ");
                choice = reader.readLine().trim();
                complaints.setDepartment(choice);
                System.out.println("담당부서 배치가 완료되었습니다.");
                
            } else {
                System.out.println("\n유효하지 않은 값입니다. 초기 화면으로 돌아갑니다.\n");
                return;
            }
        } catch(Exception e) {
            System.out.println("시스템에 문제가 생겨서 화면이 나오지 않습니다. 다시 시도해주세요");
        }
    }
}
