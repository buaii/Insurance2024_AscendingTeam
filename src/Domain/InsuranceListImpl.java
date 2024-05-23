package Domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

	public ArrayList<Insurance> insurances;
	
	public InsuranceListImpl(String fileName) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		this.insurances = new ArrayList<Insurance>();
		String insInfo = "";
		while (reader.ready()) {
			insInfo += reader.readLine();
			if (!insInfo.equals("")) {
				this.insurances.add(new Insurance(insInfo));
				insInfo = "";
			}
		}
		reader.close();
	}
	
	@Override
	public void add(Insurance Insurance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Insurance Insurance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get(Insurance Insurance) {
		
		
	}

	@Override
	public void update(Insurance Insurance) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Insurance> getLifeInsurance() {
		ArrayList<Insurance> lifeInsurances = new ArrayList<>();
		for (int i = 0; i < this.insurances.size(); i++) {
			Insurance ins = (Insurance) this.insurances.get(i);
			if ((ins.getType()).equals("L")) lifeInsurances.add(ins);
		}
		return lifeInsurances;
	}
	
	public ArrayList<Insurance> getPropertyInsurance() {
		ArrayList<Insurance> propertyInsurance = new ArrayList<>();;
		for (int i = 0; i < this.insurances.size(); i++) {
			Insurance ins = (Insurance) this.insurances.get(i);
			if ((ins.getType()).equals("P")) propertyInsurance.add(ins);
		}
		return propertyInsurance;
	}

}