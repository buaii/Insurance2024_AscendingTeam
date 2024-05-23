package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class Disease {

	private String medicalHistory;
	private String period;
	private String type;

	public Disease(){

	}

	public void finalize() throws Throwable {

	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
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