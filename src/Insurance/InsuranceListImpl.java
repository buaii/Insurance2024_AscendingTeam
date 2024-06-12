package Insurance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

    public ArrayList<Insurance> insurances;

    public InsuranceListImpl() {
        this.insurances = new ArrayList<>();
    }

    public ArrayList<Insurance> loadInsurance(String fileName) throws IOException {
    	ArrayList<Insurance> insuranceList = new ArrayList<>();
        StringBuilder insInfo = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    insInfo.append(line).append("\n");
                } else {
                    // 빈 줄을 만나면 보험 항목을 리스트에 추가
                    if (insInfo.length() > 0) {
                        insuranceList.add(new Insurance(insInfo.toString().trim()));
                        insInfo.setLength(0); // StringBuilder 초기화
                    }
                }
            }
            // 마지막 항목 추가
            if (insInfo.length() > 0) {
                insuranceList.add(new Insurance(insInfo.toString().trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
