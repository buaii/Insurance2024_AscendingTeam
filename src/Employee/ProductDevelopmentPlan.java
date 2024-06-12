package Employee;

import EmployeeValue.CalculationInfo;
import EmployeeValue.InsuranceConceptInfo;
import EmployeeValue.MarketResearchingInfo;

/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class ProductDevelopmentPlan {

	private String name;
	private String description;
	private String premium;
	private String coverage;
	private String term;
	private String maxAge;
	private String exclusion;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public String getExclusion() {
		return exclusion;
	}

	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}

}