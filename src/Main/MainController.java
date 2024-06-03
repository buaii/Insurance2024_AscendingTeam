package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Service.CustomerService;
import Service.CustomerSupportService;
import Service.InsuranceService;
import Service.MarketingService;
import Service.MenuService;
import Service.ProductDevelopmentService;

public class MainController {
    private BufferedReader reader;
    private InsuranceService insuranceService;
    private CustomerSupportService customerSupportService;
    private ProductDevelopmentService productDevelopmentService;
    private MarketingService marketingService;
    private MenuService menuService;
    private CustomerService customerService;

    public MainController() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        customerService = new CustomerService();
        insuranceService = new InsuranceService(customerService);
        customerSupportService = new CustomerSupportService();
        productDevelopmentService = new ProductDevelopmentService();
        marketingService = new MarketingService();
        menuService = new MenuService();
    }

    public void start() {
        try {
            while (true) {
                menuService.showMenu();
                String choice = reader.readLine().trim();
                switch (choice) {
                    case "1":
                        insuranceService.handleInsuranceMenu(reader);
                        break;
                    case "2":
                        insuranceService.requestPayment(reader);
                        break;
                    case "3":
                        customerSupportService.roadsideAssist(reader);
                        break;
                    case "4":
                        customerSupportService.requestSupport(reader);
                        break;
                    case "5":
                        productDevelopmentService.productDevelop(reader);
                        break;
                    case "6":
                        marketingService.strategyDevelop(reader);
                        break;
                    case "7":
                        marketingService.marketAnalysis(reader);
                        break;
                    case "8":
                        insuranceService.requestUnderwrite(reader);
                        break;
                    case "9":
                        insuranceService.underwrite(reader);
                        break;
                    case "10":
                        insuranceService.reviewCoverage(reader);
                        break;
                    case "11":
                        insuranceService.approvePayment(reader);
                        break;
                    case "12":
                        insuranceService.insurancePayment(reader);
                        break;
                    case "13":
                        insuranceService.contractManage(reader);
                        break;
                    case "14":
                        insuranceService.infoManage(reader);
                        break;
                    case "15":
                        insuranceService.personnelManage(reader);
                        break;
                    case "16":
                        insuranceService.salesMenEdu(reader);
                        break;
                    case "17":
                        customerSupportService.happyCall(reader);
                        break;
                    case "18":
                        customerSupportService.offerSupport(reader);
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("\n유효하지 않은 값입니다.\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            this.pauseAndReturnToMain();
        }
    }
    
    private void pauseAndReturnToMain() {
        try {
            System.out.println("\n아무 키나 눌러 초기화면으로 돌아갑니다.");
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
