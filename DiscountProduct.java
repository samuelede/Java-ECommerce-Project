
/**
 * A discount product is a product with a discount rate applied. The discount 
 * rate should be between 0 and 1.0, with 0.1 being a 10% discount, 0.2 being 
 * a 20% discount, etc. 
 * When retrieving the unit price of a discount product it should return the 
 * standard unit price with any discount applied. A discount amount should 
 * always drop to the nearest whole number, e.g. a calculated discount of 7.9 
 * pence would apply as a discount of 7 pence on the unit price.
 * 
 * @author P2519798
 */
public class DiscountProduct extends Product {
	
	// Fields
	private double discountRate;
		
	// Constructors
	public DiscountProduct() {
		super();
		discountRate = 0; 
	}
	
	public DiscountProduct(String productCode, String description, int unitPrice, Double discountRate) {
		this.productCode = productCode;
		this.description = description;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
	}
	// Methods
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	/** @return the discountRate */
	public double getDiscountRate() {
		return discountRate;
	}

	/** @param discountRate the discountRate to set */
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	/** @param discounted unitPrice - DiscountRate 10% of 50pence would be 50 - (50*10/100) = 45pence*/
	@Override
	public int getUnitPrice() {
		 double unitPrice = this.unitPrice - (this.unitPrice*discountRate/100);
		 return (int) unitPrice;
	}

	@Override
	public String toString() {
		return super.toString() + ", discountRate=" + discountRate +"%"+ ", DiscountPrice=" + getUnitPrice() +"]";
		//return "DiscountProduct [productCode=" + this.getProductCode() + ", description=" + this.getDescription() + ", unitPrice=" + getUnitPrice() + ", discountRate=" + discountRate + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		DiscountProduct other = (DiscountProduct) obj;
		
		return this.discountRate == other.discountRate;
		
	}
	
}
