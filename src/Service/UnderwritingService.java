package Service;

import Underwriting.UnderwritingListImpl;
import java.io.BufferedReader;
import java.io.IOException;

public class UnderwritingService {

    private UnderwritingListImpl underwritingList;
    private UnderwritingListImpl reUnderwritingList;

    public UnderwritingService() {
        try {
            this.underwritingList = new UnderwritingListImpl("인수심사대기자.txt");
            this.reUnderwritingList = new UnderwritingListImpl("재심사대기자.txt");
        } catch (IOException e) {
            System.out.println("초기화 중 오류 발생: " + e.getMessage());
            this.underwritingList = null;
            this.reUnderwritingList = null;
        }
    }

    public void showUnderwritingMenu(BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("\n--------인수 심사 메뉴--------");
            System.out.println("0. 초기화면");
            System.out.println("1. 인수 심사 요청 확인");
            System.out.println("2. 재심사 요청 확인");
            System.out.print("\n원하시는 서비스를 선택하세요: ");
            String choice = reader.readLine().trim();
            switch (choice) {
            	case "0":
            		return;
                case "1":
                    if (underwritingList != null) {
                        underwritingList.reviewUnderwritingRequests(reader);
                    } else {
                        System.out.println("인수 심사 데이터를 불러올 수 없습니다.");
                    }
                    break;
                case "2":
                    if (reUnderwritingList != null) {
                        reUnderwritingList.reviewUnderwritingRequests(reader);
                    } else {
                        System.out.println("재심사 데이터를 불러올 수 없습니다.");
                    }
                    break;
                default:
                    System.out.println("\n유효하지 않은 값입니다. 다시 선택해주세요.\n");
            }
        }
    }
}
