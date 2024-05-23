package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class Member extends Customer {

	private String beneficiaryInfo;
	private String insuredRecord;
	private String joinedInsuranceList;
	private String joinedRecord;
	private String paymentDate;
	public Complaints m_Complaints;

	public Member(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void complain(){

	}

	public String getBeneficiaryInfo() {
		return beneficiaryInfo;
	}

	public void setBeneficiaryInfo(String beneficiaryInfo) {
		this.beneficiaryInfo = beneficiaryInfo;
	}

	public String getInsuredRecord() {
		return insuredRecord;
	}

	public void setInsuredRecord(String insuredRecord) {
		this.insuredRecord = insuredRecord;
	}

	public String getJoinedInsuranceList() {
		return joinedInsuranceList;
	}

	public void setJoinedInsuranceList(String joinedInsuranceList) {
		this.joinedInsuranceList = joinedInsuranceList;
	}

	public String getJoinedRecord() {
		return joinedRecord;
	}

	public void setJoinedRecord(String joinedRecord) {
		this.joinedRecord = joinedRecord;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

}