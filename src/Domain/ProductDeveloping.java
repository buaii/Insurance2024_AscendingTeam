package Domain;

import java.io.File;

/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class ProductDeveloping extends Employee {

	private File businessRegistrationCertificateFile;
	public PreSalesInfo m_PreSalesInfo;
	public Insurance m_Insurance;
	public ProductDevelopmentPlan m_ProductDevelopmentPlan;

	public ProductDeveloping(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public File getBusinessRegistrationCertificateFile() {
		return businessRegistrationCertificateFile;
	}

	public void setBusinessRegistrationCertificateFile(File businessRegistrationCertificateFile) {
		this.businessRegistrationCertificateFile = businessRegistrationCertificateFile;
	}

}