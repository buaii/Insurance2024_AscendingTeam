package Insurance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

    public ArrayList<Insurance> insurances;

    public InsuranceListImpl() {
        this.insurances = new ArrayList<>();
    }

    public ArrayList<Insurance> loadInsurance(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<Insurance> insuranceList = new ArrayList<>();
        StringBuilder insInfo = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                insInfo.append(line).append("\n");
            }
        }
        insuranceList.add(new Insurance(insInfo.toString()));
        reader.close();
        return insuranceList;
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
        
    }

    @Override
    public void update(Insurance insurance) {
        // TODO: Implement update functionality
    }
}
