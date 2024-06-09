package Service;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MarketingService {

    public void strategyDevelop(BufferedReader reader) throws IOException {
        System.out.println("마케팅 전략 개발을 선택하셨습니다.\n");
        
        System.out.println("[ 마케팅 전략 정보를 입력하세요 ]");
        System.out.print("제목: ");
        String title = reader.readLine();
        System.out.print("판매 채널: ");
        String type = reader.readLine();
        System.out.print("매출 목표: ");
        String saleGoal = reader.readLine();
        System.out.print("예산: ");
        String budget  = reader.readLine();
        
        System.out.println("[ 사업 계획 파일 업로드 ]");
        System.out.println("파일 경로를 입력하고 Enter를 눌러 제출");
        System.out.print("사업 계획 파일 경로: ");
        String businessFilePathString = reader.readLine();
        Path businessFilePath = Paths.get(businessFilePathString);
        
        System.out.println("[ 판매 정책 파일 업로드 ]");
        System.out.println("파일 경로를 입력하고 Enter를 눌러 제출");
        System.out.print("판매 정책 파일 경로: ");
        String salesFilePathString = reader.readLine();
        Path salesFilePath = Paths.get(salesFilePathString);
        
        System.out.println("제출이 완료되었습니다.\n검토 완료 시 결과를 안내해드리겠습니다.\n");
        
        System.out.println("--------------------------------\n");
        
        System.out.println("[알림] 기획자로부터 마케팅 전략이 제출되었습니다.");
        System.out.println("Enter를 눌러 확인하십시오.");
        
        System.out.println("[ 마케팅 전략 정보 ] ");
        System.out.println("제목: " + title);
        System.out.println("판매 채널: " + type);
        System.out.println("매출 목표: " + saleGoal);
        System.out.println("예산: " + budget + "\n");
        
        System.out.println("제출된 사업 계획 파일을 저장할 경로를 입력하세요.");
        System.out.print("파일 저장 경로: ");
        String businessFileTargetPathString = reader.readLine();
        Path businessFileTargetPath = Paths.get(businessFileTargetPathString);
        
        System.out.println("제출된 판매 정책 파일을 저장할 경로를 입력하세요.");
        System.out.print("파일 저장 경로: ");
        String salesFileTargetPathString = reader.readLine();
        Path salesFileTargetPath = Paths.get(salesFileTargetPathString);
        
       
        Files.copy(businessFilePath, businessFileTargetPath,
        			StandardCopyOption.REPLACE_EXISTING);
        Files.copy(salesFilePath, salesFileTargetPath,
        			StandardCopyOption.REPLACE_EXISTING);
        System.out.println("파일이 성공적으로 저장되었습니다.");
        
        
        while (true) {
           System.out.println("기획 검토 후 해당 버튼을 클릭하세요.");
           System.out.println("1. 기획 승인");
           System.out.println("2. 기획 거절");
        
           String choice = reader.readLine().trim();
        
           switch (choice) {
              case "1":
            	 System.out.println("마케팅 기획이 승인되었습니다.\n");
            	 System.out.println("--------------------------------\n");
            	 System.out.println("[알림] 경영 관리자로부터 마케팅 기획이 승인되었습니다.");
     	         break;
              case "2":
            	 System.out.println("구현");
     	         break;
              default:
     	         System.out.println("유효하지 않은 값입니다. 다시 선택해주세요.");
     	         continue;
           }
        }
    }

    public void marketAnalysis(BufferedReader reader) throws IOException {
        System.out.println("시장 분석을 선택하셨습니다.");
        // 메소드 구
    }
}
