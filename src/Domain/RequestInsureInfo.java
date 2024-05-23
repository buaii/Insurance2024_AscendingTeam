package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:22
 */
public class RequestInsureInfo {

	private String accidentInfo;
	private String beneficiaryInfo;
	private String bill;
	private String memberInfo;
	public AccidentInfo m_AccidentInfo;
	public Member m_Member;

	public RequestInsureInfo(){

	}

	public void finalize() throws Throwable {

	}

	public String getAccidentInfo() {
		return accidentInfo;
	}

	public void setAccidentInfo(String accidentInfo) {
		this.accidentInfo = accidentInfo;
	}

	public String getBeneficiaryInfo() {
		return beneficiaryInfo;
	}

	public void setBeneficiaryInfo(String beneficiaryInfo) {
		this.beneficiaryInfo = beneficiaryInfo;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(String memberInfo) {
		this.memberInfo = memberInfo;
	}

}