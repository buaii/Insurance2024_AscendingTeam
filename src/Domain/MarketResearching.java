package Domain;


/**
 * @author eun94
 * @version 1.0
 * @created 22-5-2024 ���� 4:49:21
 */
public class MarketResearching extends Employee {

	private String marketType;
	public ProductDevelopmentPlan m_ProductDevelopmentPlan;

	public MarketResearching(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void research(){

	}

	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

}