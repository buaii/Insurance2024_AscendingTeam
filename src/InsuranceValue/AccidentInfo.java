package InsuranceValue;

import java.awt.Image;
import java.nio.file.Path;

/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:19
 */
public class AccidentInfo {

	private String billType;
	private String date;
	private String details;
	private String nameOfDisease;
	private String nameOfHospital;
	private Image scenePhoto;
	private String type;
	private Path photoPath;

	public AccidentInfo(){

	}

	public void finalize() throws Throwable {

	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getNameOfDisease() {
		return nameOfDisease;
	}

	public void setNameOfDisease(String nameOfDisease) {
		this.nameOfDisease = nameOfDisease;
	}

	public String getNameOfHospital() {
		return nameOfHospital;
	}

	public void setNameOfHospital(String nameOfHospital) {
		this.nameOfHospital = nameOfHospital;
	}

	public Image getScenePhoto() {
		return scenePhoto;
	}

	public void setScenePhoto(Image scenePhoto) {
		this.scenePhoto = scenePhoto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Path getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(Path photoPath) {
		this.photoPath = photoPath;
	}

}