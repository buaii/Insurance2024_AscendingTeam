package InsuranceValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Customer.Customer;
import Service.UnderwritingService;

public class RequestListImpl implements RequestList {
	
	public ArrayList<RequestInsureInfo> requestList;
	
	public RequestListImpl(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		this.requestList = new ArrayList<>();
		RequestInsureInfo request;
		String[] lineArray = new String[30];
		String line;
		int i = 0;
		while ((line = reader.readLine()) != null) {
			if (!line.equals("")) {
				lineArray[i] = line;
				++i;
			} else {
				request = loadList(lineArray);
				this.requestList.add(request);
				lineArray = new String[30];
				i = 0;
			}
		}
		reader.close();
	}

	@Override
	public void add(String fileName, RequestInsureInfo reqInfo) throws IOException {
		FileWriter writer = new FileWriter(fileName, true);
    	writer.write(reqInfo.getMemberInfo());
    	writer.write(reqInfo.getAccidentInfo());
    	writer.write(reqInfo.getBeneficiaryInfo());
    	writer.write("\n\n");
    	writer.close();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RequestInsureInfo loadList(String[] lineArray) throws IOException {
		
		// if (lineArray[0].equals(null)) return null;
		
		RequestInsureInfo request = new RequestInsureInfo();
		String infoString = "";
		int i = 0;
		
		UnderwritingService toGetFindCustomerMethod = new UnderwritingService();
    	Customer customer = toGetFindCustomerMethod.findCustomer(lineArray[i], lineArray[++i]);
    	request.m_Customer = customer;
		
		for (int n=0; n<3; ++n) {
			infoString += lineArray[++i] + "\n";
		} // name, phone number, SSN
		
		request.setSSN(lineArray[i]);
		request.setMemberInfo(infoString);
		
		AccidentInfo accInfo = new AccidentInfo();
		infoString = "";
		accInfo.setType(lineArray[++i]);
		infoString += lineArray[i] + "\n";
		accInfo.setBillType(lineArray[++i]);
		infoString += lineArray[i] + "\n";
		accInfo.setDate(lineArray[++i]);
		infoString += lineArray[i] + "\n";
		accInfo.setDetails(lineArray[++i]);
		infoString += lineArray[i] + "\n";
		accInfo.setNameOfHospital(lineArray[++i]);
		infoString += lineArray[i] + "\n";
		accInfo.setNameOfDisease(lineArray[++i]);
		infoString += lineArray[i] + "\n";
		
		request.m_AccidentInfo = accInfo;
		request.setAccidentInfo(infoString);
		
		infoString = "";
		for (int n=0; n<3; ++n) {
			infoString += lineArray[++i] + "\n";
		} // beneficiary's name, account, phone number
		
		request.setBeneficiaryInfo(infoString);
		
		return request;
	}

}
