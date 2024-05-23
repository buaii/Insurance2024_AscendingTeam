package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class Employee {

	private String accountNum;
	private String department;
	private String email;
	private String empolyeeID;
	private String HP;
	private String name;
	private String position;
	public Insurance m_Insurance;

	public Employee(){

	}

	public void finalize() throws Throwable {

	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpolyeeID() {
		return empolyeeID;
	}

	public void setEmpolyeeID(String empolyeeID) {
		this.empolyeeID = empolyeeID;
	}

	public String getHP() {
		return HP;
	}

	public void setHP(String hP) {
		HP = hP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}