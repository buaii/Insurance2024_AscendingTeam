package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class InsuranceConceptInfo {

	private String profitExpectation;
	private String regulation;
	private String targetCust;
	private String targetMarket;
	private String tempTitle;

	public InsuranceConceptInfo(){

	}

	public void finalize() throws Throwable {

	}

	public String getProfitExpectation() {
		return profitExpectation;
	}

	public void setProfitExpectation(String profitExpectation) {
		this.profitExpectation = profitExpectation;
	}

	public String getRegulation() {
		return regulation;
	}

	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}

	public String getTargetCust() {
		return targetCust;
	}

	public void setTargetCust(String targetCust) {
		this.targetCust = targetCust;
	}

	public String getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(String targetMarket) {
		this.targetMarket = targetMarket;
	}

	public String getTempTitle() {
		return tempTitle;
	}

	public void setTempTitle(String tempTitle) {
		this.tempTitle = tempTitle;
	}

}