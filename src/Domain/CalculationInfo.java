package Domain;


/**
 * @author NB69
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:19
 */
public class CalculationInfo {

	private String investmentCapital;
	private String premium;
	private String risk;

	public CalculationInfo(){

	}

	public void finalize() throws Throwable {

	}

	public String getInvestmentCapital() {
		return investmentCapital;
	}

	public void setInvestmentCapital(String investmentCapital) {
		this.investmentCapital = investmentCapital;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

}