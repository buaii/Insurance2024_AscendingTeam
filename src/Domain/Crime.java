package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class Crime {

	private boolean crimeStatus;
	private String period;
	private String type;

	public Crime(){

	}

	public void finalize() throws Throwable {

	}

	public boolean isCrimeStatus() {
		return crimeStatus;
	}

	public void setCrimeStatus(boolean crimeStatus) {
		this.crimeStatus = crimeStatus;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}