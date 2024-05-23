package Domain;


/**
 * @author NB69
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public class CustomerInfo {

	private String HP;
	private String name;

	public CustomerInfo(){

	}

	public void finalize() throws Throwable {

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

}