package Domain;


/**
 * @author NB69
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class LocationInfo {

	private String address;
	private String GPS;

	public LocationInfo(){

	}

	public void finalize() throws Throwable {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String gPS) {
		GPS = gPS;
	}

}