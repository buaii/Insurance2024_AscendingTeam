package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:22
 */
public class Victim extends Member {

	private String accidentDetails;
	private String accidentType;
	private String locationInfo;
	public RequestInsureInfo m_RequestInsureInfo;
	public LocationInfo m_LocationInfo;

	public Victim(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void requestDispatch(){

	}

	public void requestEnsure(){

	}

	public void requestHospital(){

	}

	public void requestRepair(){

	}

	public String getAccidentDetails() {
		return accidentDetails;
	}

	public void setAccidentDetails(String accidentDetails) {
		this.accidentDetails = accidentDetails;
	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

}