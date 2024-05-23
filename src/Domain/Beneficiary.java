package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:19
 */
public class Beneficiary extends Member {

	private String accountNum;
	private String HP;
	private String Name;

	public Beneficiary(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getHP() {
		return HP;
	}

	public void setHP(String hP) {
		HP = hP;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}