package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class Military {

	private boolean exemption;
	private String period;
	private boolean serviceStatus;

	public Military(){

	}

	public void finalize() throws Throwable {

	}

	public boolean isExemption() {
		return exemption;
	}

	public void setExemption(boolean exemption) {
		this.exemption = exemption;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public boolean isServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(boolean serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}