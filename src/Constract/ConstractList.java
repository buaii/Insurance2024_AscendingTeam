package Constract;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.IOException;

import Customer.Customer;

/**
 * @author khs66
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public interface ConstractList {
	public void applyForInsurance(Customer customer, String insuranceType) throws IOException;
    public void showInsuranceInfo(String typeChoice, BufferedReader reader) throws IOException;
    public void selectInsuranceTypeAndApply(BufferedReader reader) throws IOException;

	/**
	 * 
	 * @param Contract
	 */
	public void add(Constract Contract);

	public void delete();

	public void get();

	public void update();

}