package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:19
 */
public class AccidentReviewing extends Employee {

	private String accidentRegistrationList;
	private String partnershipList;
	private String reviewCaseList;
	public AccidentReview m_AccidentReview;
	public RequestInsureInfo m_RequestInsureInfo;

	public AccidentReviewing(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void receive(){

	}

	public String getAccidentRegistrationList() {
		return accidentRegistrationList;
	}

	public void setAccidentRegistrationList(String accidentRegistrationList) {
		this.accidentRegistrationList = accidentRegistrationList;
	}

	public String getPartnershipList() {
		return partnershipList;
	}

	public void setPartnershipList(String partnershipList) {
		this.partnershipList = partnershipList;
	}

	public String getReviewCaseList() {
		return reviewCaseList;
	}

	public void setReviewCaseList(String reviewCaseList) {
		this.reviewCaseList = reviewCaseList;
	}

}