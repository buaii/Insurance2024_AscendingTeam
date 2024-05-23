package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class ContractProcessing extends Employee {

	private String memberList;
	public Insurance m_Insurance;
	public UnderwritingReviewing m_UnderwritingReviewing;

	public ContractProcessing(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void manageContract(){

	}

	public void requestUnderwrite(){

	}

	public String getMemberList() {
		return memberList;
	}

	public void setMemberList(String memberList) {
		this.memberList = memberList;
	}

}