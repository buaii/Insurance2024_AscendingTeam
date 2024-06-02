//package Insurance;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class InsuranceController {
//    private InsuranceView view;
//    private InsuranceListImpl insuranceList;
//
//    public InsuranceController(InsuranceView view) {
//        this.view = view;
//        this.insuranceList = new InsuranceListImpl();
//    }
//
//    public void showInsuranceMenu(int choice) {
//        try {
//            ArrayList<Insurance> list;
//            switch (choice) {
//                case 1:
//                    list = insuranceList.loadInsurance("data/Life.txt");
//                    break;
//                case 2:
//                    list = insuranceList.loadInsurance("Data/property.txt");
//                    break;
//                case 3:
//                    list = insuranceList.loadInsurance("Data/thirdParty.txt");
//                    break;
//                default:
//                    System.out.println("올바르지 않은 입력입니다.");
//                    return;
//            }
//
//            if (list.size() == 0) {
//                System.out.println("\n해당 종류의 보험이 존재하지 않습니다. 초기 화면으로 돌아갑니다.\n");
//                return;
//            }
//
//            System.out.println("----------상품 목록----------");
//            for (int i = 0; i < list.size(); ++i) {
//                System.out.println("[" + list.get(i).getName() + "]");
//                System.out.println(list.get(i).getIntroduction());
//                System.out.println("* 보험료 확인");
//                System.out.println("* 상품 세부 정보");
//                System.out.println("* 상품 가입");
//            }
//            handleInsuranceSelection(list);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void handleInsuranceSelection(ArrayList<Insurance> list) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("원하는 작업을 선택하세요:");
//        System.out.println("1. 보험료 확인");
//        System.out.println("2. 상품 세부 정보");
//        System.out.println("3. 상품 가입");
//        String choice = reader.readLine().trim();
//
//        switch (choice) {
//            case "1":
//                checkInsurancePremium(reader, list);
//                break;
//            case "2":
//                viewInsuranceDetails(reader, list);
//                break;
//            case "3":
//                applyForInsurance(reader, list);
//                break;
//            default:
//                System.out.println("\n유효하지 않은 값입니다. 초기 화면으로 돌아갑니다.\n");
//        }
//    }
//
//    private void checkInsurancePremium(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
//        System.out.println("보험료를 확인할 상품의 번호를 입력하세요:");
//        int index = Integer.parseInt(reader.readLine().trim()) - 1;
//        if (index >= 0 && index < list.size()) {
//            System.out.println("[" + list.get(index).getName() + "]의 보험료는 " + list.get(index).getPremium() + "입니다.");
//        } else {
//            System.out.println("\n유효하지 않은 번호입니다. 초기 화면으로 돌아갑니다.\n");
//        }
//    }
//
//    private void viewInsuranceDetails(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
//        System.out.println("세부 정보를 확인할 상품의 번호를 입력하세요:");
//        int index = Integer.parseInt(reader.readLine().trim()) - 1;
//        if (index >= 0 && index < list.size()) {
//            System.out.println("[" + list.get(index).getName() + "]의 세부 정보는 다음과 같습니다:");
//            System.out.println(list.get(index).getDetails());
//        } else {
//            System.out.println("\n유효하지 않은 번호입니다. 초기 화면으로 돌아갑니다.\n");
//        }
//    }
//
//    private void applyForInsurance(BufferedReader reader, ArrayList<Insurance> list) throws IOException {
//        System.out.println("가입할 상품의 번호를 입력하세요:");
//        int index = Integer.parseInt(reader.readLine().trim()) - 1;
//        if (index >= 0 && index < list.size()) {
//            System.out.println("[" + list.get(index).getName() + "]에 가입되었습니다.");
//            // 가입 로직 구현
//        } else {
//            System.out.println("\n유효하지 않은 번호입니다. 초기 화면으로 돌아갑니다.\n");
//        }
//    }
//}
