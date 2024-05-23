package Domain;


/**
 * @author NB69
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class PreSalesInfo {

	private String operatingManual;
	private String productDescriptionManual;
	private String productInfoSheet;
	private String proposal;
	private String subscriptionManual;
	private String terms;

	public PreSalesInfo(){

	}

	public void finalize() throws Throwable {

	}

	public String getOperatingManual() {
		return operatingManual;
	}

	public void setOperatingManual(String operatingManual) {
		this.operatingManual = operatingManual;
	}

	public String getProductDescriptionManual() {
		return productDescriptionManual;
	}

	public void setProductDescriptionManual(String productDescriptionManual) {
		this.productDescriptionManual = productDescriptionManual;
	}

	public String getProductInfoSheet() {
		return productInfoSheet;
	}

	public void setProductInfoSheet(String productInfoSheet) {
		this.productInfoSheet = productInfoSheet;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public String getSubscriptionManual() {
		return subscriptionManual;
	}

	public void setSubscriptionManual(String subscriptionManual) {
		this.subscriptionManual = subscriptionManual;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

}