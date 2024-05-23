package Domain;


/**
 * @author khs66
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public interface InsuranceList {

	/**
	 * 
	 * @param Insurance
	 */
	public void add(Insurance Insurance);

	/**
	 * 
	 * @param Insurance
	 */
	public void delete(Insurance Insurance);

	/**
	 * 
	 * @param Insurance
	 */
	public void get(Insurance Insurance);

	/**
	 * 
	 * @param Insurance
	 */
	public void update(Insurance Insurance);

}