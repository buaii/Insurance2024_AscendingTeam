package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class ProductDevelopmentPlan {

	private String calculationInfo;
	private String insuranceConceptInfo;
	private String marketInfo;
	private String name;
	private String type;
	public InsuranceConceptInfo m_InsuranceConceptInfo;
	public MarketResearchingInfo m_MarketResearchingInfo;
	public FinancialSupervisoryService m_FinancialSupervisoryService;
	public CalculationInfo m_CalculationInfo;

	public ProductDevelopmentPlan(){

	}

	public void finalize() throws Throwable {

	}

	public void design(){

	}

	public void reDesign(){

	}

	public void requestSalesPermission(){

	}

	public String getCalculationInfo() {
		return calculationInfo;
	}

	public void setCalculationInfo(String calculationInfo) {
		this.calculationInfo = calculationInfo;
	}

	public String getInsuranceConceptInfo() {
		return insuranceConceptInfo;
	}

	public void setInsuranceConceptInfo(String insuranceConceptInfo) {
		this.insuranceConceptInfo = insuranceConceptInfo;
	}

	public String getMarketInfo() {
		return marketInfo;
	}

	public void setMarketInfo(String marketInfo) {
		this.marketInfo = marketInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}