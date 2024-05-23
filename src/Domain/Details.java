package Domain;

import java.util.StringTokenizer;

/**
 * @author NB69
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class Details {

	private String joinCondition;
	private String premiumStandard;
	private String compensationLimit;
	private String compensationProcedure;
	private String compensationHistory;
	public CompensationHistory m_CompensationHistory;

	public Details(String inputString){
		StringTokenizer stringTokenizer = new StringTokenizer(inputString, "/");
		this.joinCondition = stringTokenizer.nextToken().trim();
		this.premiumStandard = stringTokenizer.nextToken().trim();
		this.compensationLimit = stringTokenizer.nextToken().trim();
		this.compensationProcedure = stringTokenizer.nextToken().trim();
		while (stringTokenizer.hasMoreTokens()) {
			this.compensationHistory += stringTokenizer.nextToken() + "/";
		}
		this.m_CompensationHistory = new CompensationHistory(this.compensationHistory);
	}

	public void finalize() throws Throwable {

	}

	public String getCompensationHistory() {
		return compensationHistory;
	}

	public void setCompensationHistory(String compensationHistory) {
		this.compensationHistory = compensationHistory;
	}

	public String getCompensationLimit() {
		return compensationLimit;
	}

	public void setCompensationLimit(String compensationLimit) {
		this.compensationLimit = compensationLimit;
	}

	public String getCompensationProcedure() {
		return compensationProcedure;
	}

	public void setCompensationProcedure(String compensationProcedure) {
		this.compensationProcedure = compensationProcedure;
	}

	public String getJoinCondition() {
		return joinCondition;
	}

	public void setJoinCondition(String joinCondition) {
		this.joinCondition = joinCondition;
	}

	public String getPremiumStandard() {
		return premiumStandard;
	}

	public void setPremiumStandard(String premiumStandard) {
		this.premiumStandard = premiumStandard;
	}

}