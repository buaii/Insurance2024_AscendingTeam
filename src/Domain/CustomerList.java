package Domain;


/**
 * @author khs66
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public interface CustomerList {

	/**
	 * 
	 * @param Customer
	 */
	public void add(Customer Customer);

	/**
	 * 
	 * @param Customer
	 */
	public void delete(Customer Customer);

	/**
	 * 
	 * @param Customer
	 */
	public void get(Customer Customer);

	/**
	 * 
	 * @param Customer
	 */
	public void update(Customer Customer);

}