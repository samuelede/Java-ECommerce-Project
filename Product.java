
/**
 * A product item has a unique product code, description and price per unit.
 * The price is given in pence.
 * 
 * A product can be tested for equality by providing a appropriate 
 * overridden equals(...) method that assesses the equality of each field.
 * 
 * Additionally, products are comparable, so they can be sorted into a natural
 * order. They should firstly be compared by product code, if these are the same,
 * then by description, and if these are the same, then by unit price.
 * 
 * @author P2519798
 */
public class Product implements Comparable<Product> {
	
	// Fields
	protected String productCode;
	protected String description;
	protected int unitPrice; 		//pence
	
	//Constructors
	public Product() {
		productCode = "";
		description = "";
		unitPrice = 0;
	}
	
	public Product(String productCode, String description, int unitPrice) {
		this.productCode = productCode;
		this.description = description;
		this.unitPrice = unitPrice;
	}
	
	//Methods
	/** @return the productCode */
	public String getProductCode() {
		return productCode;
	}

	/** @param productCode the productCode to set */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/** @return the description */
	public String getDescription() {
		return description;
	}

	/** @param description the description to set */
	public void setDescription(String description) {
		this.description = description;
	}

	/** @return the unitPrice */
	public int getUnitPrice() {
		return unitPrice;
	}

	/** @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", description=" + description + ", unitPrice=" + unitPrice
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Product other = (Product) obj;
		
		//compare productCode, description and unitPrice using the String .equals()
		return this.productCode == other.productCode && this.description == other.description
				&& this.unitPrice == other.unitPrice;
	}
	
	public int compareTo(Product other) {
		int result = this.productCode.compareTo(other.productCode);
		
		if (result == 0) {
			result = this.description.compareTo(other.description);
			
			if (result == 0) {
				result = Integer.compare(this.unitPrice, other.unitPrice);
			}
		} return result;
	}
	
}
