package Domain;

import java.util.StringTokenizer;

/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class CompensationHistory {

	private String accidentType;
	private String compensationSystem;
	private String insurancePeriod;
	private String IndemnificationProvision;

	public CompensationHistory(String inputString){
		StringTokenizer stringTokenizer = new StringTokenizer(inputString, "/");
		this.accidentType = stringTokenizer.nextToken().trim();
		this.compensationSystem = stringTokenizer.nextToken().trim();
		this.insurancePeriod = stringTokenizer.nextToken().trim();
		this.IndemnificationProvision = stringTokenizer.nextToken().trim();
	}

	public void finalize() throws Throwable {

	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	public String getCompensationSystem() {
		return compensationSystem;
	}

	public void setCompensationSystem(String compensationSystem) {
		this.compensationSystem = compensationSystem;
	}

	public String getIndemnificationProvision() {
		return IndemnificationProvision;
	}

	public void setIndemnificationProvision(String indemnificationProvision) {
		IndemnificationProvision = indemnificationProvision;
	}

	public String getInsurancePeriod() {
		return insurancePeriod;
	}

	public void setInsurancePeriod(String insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}

}