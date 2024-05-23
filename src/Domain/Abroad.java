package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:19
 */
public class Abroad {

	private String residenceCountry;
	private String residencePeriod;
	private String travelCountry;
	private String travelPeriod;

	public Abroad(){

	}

	public void finalize() throws Throwable {

	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public String getResidencePeriod() {
		return residencePeriod;
	}

	public void setResidencePeriod(String residencePeriod) {
		this.residencePeriod = residencePeriod;
	}

	public String getTravelCountry() {
		return travelCountry;
	}

	public void setTravelCountry(String travelCountry) {
		this.travelCountry = travelCountry;
	}

	public String getTravelPeriod() {
		return travelPeriod;
	}

	public void setTravelPeriod(String travelPeriod) {
		this.travelPeriod = travelPeriod;
	}

}