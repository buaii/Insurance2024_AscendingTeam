package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class Customer {

	private String abroad;
	private String address;
	private String constractStatus;
	private String crime;
	private String disease;
	private String dob;
	private boolean drink;
	private String drive;
	private String gender;
	private String hobby;
	private String hp;
	private String identityNum;
	private String job;
	private boolean miltary;
	private String name;
	private boolean smoke;
	public Abroad m_Abroad;
	public Drive m_Drive;
	public Insurance m_Insurance;
	public Crime m_Crime;
	public Disease m_Disease;
	public Contract m_Constract;
	public Military m_Military;

	public Customer(){

	}

	public void finalize() throws Throwable {

	}

	public void requestInsuranceInfo(){

	}

	public String getAbroad() {
		return abroad;
	}

	public void setAbroad(String abroad) {
		this.abroad = abroad;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConstractStatus() {
		return constractStatus;
	}

	public void setConstractStatus(String constractStatus) {
		this.constractStatus = constractStatus;
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public boolean isDrink() {
		return drink;
	}

	public void setDrink(boolean drink) {
		this.drink = drink;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public boolean isMiltary() {
		return miltary;
	}

	public void setMiltary(boolean miltary) {
		this.miltary = miltary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

}