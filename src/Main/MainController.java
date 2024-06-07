package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Service.CustomerSupportService;
import Service.InsuranceService;
import Service.MarketingService;
import Service.MenuService;
import Service.ProductDevelopmentService;
import Service.UnderwritingService;
import Service.CustomerService;

public class MainController {
    private BufferedReader reader;
    private InsuranceService insuranceService;
    private CustomerSupportService customerSupportService;
    private ProductDevelopmentService productDevelopmentService;
    private MarketingService marketingService;
    private MenuService menuService;
    private CustomerService customerService;
    private UnderwritingService underwritingService;

    public MainController() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        customerService = new CustomerService();
        insuranceService = new InsuranceService(customerService);
        customerSupportService = new CustomerSupportService();
        productDevelopmentService = new ProductDevelopmentService();
        marketingService = new MarketingService();
        underwritingService = new UnderwritingService();
        menuService = new MenuService();
    }

    public void start() {
        try {
            while (true) {
                menuService.showMainMenu();
                String choice = reader.readLine().trim();
                switch (choice) {
                    case "1":
                        handleCustomerLogin();
                        break;
                    case "2":
                        handleEmployeeLogin();
                        break;
                    case "3":
                        handleConstract();
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("\n유효하지 않은 값입니다.\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void handleCustomerLogin() throws IOException {
        while (true) {
            menuService.showCustomerMenu();
            String choice = reader.readLine().trim();
            switch (choice) {
                case "1":
                    customerSupportService.roadsideAssist(reader);
                    break;
                case "2":
                    customerSupportService.requestSupport(reader);
                    break;
                case "x":
                    return;
                default:
                    System.out.println("\n유효하지 않은 값입니다.\n");
            }
        }
    }

    private void handleEmployeeLogin() throws IOException {
        while (true) {
            menuService.showEmployeeMenu();
            String choice = reader.readLine().trim();
            switch (choice) {
                case "1":
                    productDevelopmentService.productDevelop(reader);
                    break;
                case "2":
                    marketingService.strategyDevelop(reader);
                    break;
                case "3":
                    marketingService.marketAnalysis(reader);
                    break;
                case "4":
                    insuranceService.requestUnderwrite(reader);
                    break;
                case "5":
                    underwritingService.showUnderwritingMenu(reader);
                    break;
                case "6":
                    insuranceService.reviewCoverage(reader);
                    break;
                case "7":
                    insuranceService.approvePayment(reader);
                    break;
                case "8":
                    insuranceService.insurancePayment(reader);
                    break;
                case "9":
                    insuranceService.contractManage(reader);
                    break;
                case "10":
                    insuranceService.infoManage(reader);
                    break;
                case "11":
                    insuranceService.personnelManage(reader);
                    break;
                case "12":
                    insuranceService.salesMenEdu(reader);
                    break;
                case "13":
                    customerSupportService.happyCall(reader);
                    break;
                case "14":
                    customerSupportService.offerSupport(reader);
                    break;
                case "x":
                    return;
                default:
                    System.out.println("\n유효하지 않은 값입니다.\n");
            }
        }
    }

    private void handleConstract() throws IOException {
        while (true) {
            menuService.showConstractMenu();
            String choice = reader.readLine().trim();
            switch (choice) {
                case "1":
                    insuranceService.handleInsuranceMenu(reader);
                    break;
                case "2":
                    underwritingService.checkUnderwritingResult(reader);
                    break;
                case "x":
                    return;
                default:
                    System.out.println("\n유효하지 않은 값입니다.\n");
            }
        }
    }
}
