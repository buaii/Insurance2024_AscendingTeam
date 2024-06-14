package InsuranceValue;

import java.io.IOException;

public interface RequestList {
	public void add(String fileName, RequestInsureInfo reqInfo) throws IOException;
    public void delete();
    public void get();
    public void update();
    public RequestInsureInfo loadList(String[] lineArray) throws IOException ;
}
