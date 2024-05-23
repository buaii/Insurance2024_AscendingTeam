package Domain;

import java.util.ArrayList;

/**
 * @author khs66
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:20
 */
public interface ConstractListImpl extends ContractList  {

	public static final ArrayList<Contract> ContractList = new ArrayList<Contract>();
	public static final Contract m_Contract = new Contract();

	public void finalize() throws Throwable;

	/**
	 * 
	 * @param Contract
	 */
	public void add(Contract Contract);

	public void delete();

	public void get();

	public void update();

}