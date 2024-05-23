package Domain;

import java.util.ArrayList;

/**
 * @author khs66
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public interface CustomerListImpl extends CustomerList {

	public static final ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	public static final Customer m_Customer = new Customer();

	public void finalize() throws Throwable;
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