package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class Drive {

	private String accidentHistory;
	private String frequency;
	private String periodOfLicense;
	private String time;

	public Drive(){

	}

	public void finalize() throws Throwable {

	}

	public String getAccidentHistory() {
		return accidentHistory;
	}

	public void setAccidentHistory(String accidentHistory) {
		this.accidentHistory = accidentHistory;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPeriodOfLicense() {
		return periodOfLicense;
	}

	public void setPeriodOfLicense(String periodOfLicense) {
		this.periodOfLicense = periodOfLicense;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}