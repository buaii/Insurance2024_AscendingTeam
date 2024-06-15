package InsuranceValue;

import java.io.IOException;

public interface RequestList {
	public void add(String fileName, RequestInsureInfo reqInfo) throws IOException;
    public void delete(int index) throws IOException;
    public void get();
    public void update(String fileName) throws IOException;
    public RequestInsureInfo loadList(String[] lineArray) throws IOException;
    public int findRequestIndexBySSN(String ssn);
}
