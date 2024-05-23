package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:22
 */
public class Underwriting extends Employee {

	private String underwritingHistoryList;
	public UnderwritingReviewing m_UnderwritingReviewing;

	public Underwriting(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getUnderwritingHistoryList() {
		return underwritingHistoryList;
	}

	public void setUnderwritingHistoryList(String underwritingHistoryList) {
		this.underwritingHistoryList = underwritingHistoryList;
	}

}