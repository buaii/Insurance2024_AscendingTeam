package Domain;

import java.util.StringTokenizer;

/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class Insurance {

	private String id;
	private String type;
	private String name;
	private String premium;
	private String compensation;
	private String introduction;
	private String terms;
	private String details;
	public Contract m_Constract;
	public Details m_Details;

	public Insurance(String inputString){
		StringTokenizer stringTokenizer = new StringTokenizer(inputString, "/");
		this.id = stringTokenizer.nextToken().trim();
		this.type = stringTokenizer.nextToken().trim();
		this.name = stringTokenizer.nextToken().trim();
		this.premium = stringTokenizer.nextToken().trim();
		this.compensation = stringTokenizer.nextToken().trim();
		this.introduction = stringTokenizer.nextToken().trim();
		this.terms = stringTokenizer.nextToken().trim();
		while (stringTokenizer.hasMoreTokens()) {
			this.details += stringTokenizer.nextToken() + "/";
		}
		this.m_Details = new Details(this.details);
	}

	public void finalize() throws Throwable {

	}

	public void contract(){

	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}