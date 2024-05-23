package Domain;


/**
 * @author NB69
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class Rejection extends ProductDevelopmentPlan {

	private String reason;

	public Rejection(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}