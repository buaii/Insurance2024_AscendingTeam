package Insurance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

    public ArrayList<Insurance> insurances;

    public InsuranceListImpl(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        this.insurances = new ArrayList<>();
        String insInfo;
        while ((insInfo = reader.readLine()) != null) {
            if (!insInfo.trim().isEmpty()) {
                this.insurances.add(new Insurance(insInfo));
            }
        }
        reader.close();
    }

    @Override
    public void add(Insurance insurance) {
        // TODO: Implement add functionality
    }

    @Override
    public void delete(Insurance insurance) {
        // TODO: Implement delete functionality
    }

    @Override
    public void get(Insurance insurance) {
        for (Insurance ins : insurances) {
            if (ins.getName().equals(insurance.getName())) {
                System.out.println("Insurance Details:");
                System.out.println("ID: " + ins.getId());
                System.out.println("Type: " + ins.getType());
                System.out.println("Name: " + ins.getName());
                System.out.println("Premium: " + ins.getPremium());
                System.out.println("Compensation: " + ins.getCompensation());
                System.out.println("Introduction: " + ins.getIntroduction());
                System.out.println("Terms: " + ins.getTerms());
                System.out.println("Details: " + ins.getDetails());
                return;
            }
        }
        System.out.println("Insurance not found.");
    }

    @Override
    public void update(Insurance insurance) {
        // TODO: Implement update functionality
    }

    public ArrayList<Insurance> getLifeInsurance() {
        ArrayList<Insurance> lifeInsurances = new ArrayList<>();
        for (Insurance ins : this.insurances) {
            if (ins.getType().equals("L")) {
                lifeInsurances.add(ins);
            }
        }
        return lifeInsurances;
    }

    public ArrayList<Insurance> getPropertyInsurance() {
        ArrayList<Insurance> propertyInsurances = new ArrayList<>();
        for (Insurance ins : this.insurances) {
            if (ins.getType().equals("P")) {
                propertyInsurances.add(ins);
            }
        }
        return propertyInsurances;
    }
}


