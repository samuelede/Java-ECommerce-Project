
/**
 * An order is for a quantity of product. It is possible to increase and decrease 
 * the quantity. The cost of the order (i.e. unitPrice * quantity) can be 
 * retrieved with the getCost() method.
 * An order can be tested for equality - an order is equal to another if its 
 * associated product is the same, i.e. quantity is ignored. Orders are 
 * comparable and should firstly be compared by their associated product, 
 * and if these are the same, then by their quantity.
 * 
 * @author Samuel 
 */
public class Order implements Comparable<Order>, PricePolicy {
	
	// Fields
	private Product product;
	private int quantity;
	//HashSet<Product> products = new HashSet<>();
	private PricePolicy policy;
	
	//Constructors
	public Order() {
		product = new Product();
		quantity = 0;
	}
	
	public Order(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	// Methods
	/** @return the product to get*/
	public Product getProduct() {
		return product;
	}

	/** @param product the product to set */
	public void setProduct(Product product) {
		this.product = product;
	}

	/** @return the quantity to get*/
	public int getQuantity() {
		return quantity;
	}

	/** @param quantity the quantity to set */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/** @return the policy */
	public PricePolicy getPolicy() {
		return policy;
	}

	/** @param policy the policy to set */
	public void setPolicy(PricePolicy policy) {
		this.policy = policy;
	}

	/** @param Cost the cost of product * quantity */
	public int getCost() {
		//Product p = new Product();
		return quantity * product.getUnitPrice();
	}
	
	/** @param Cost the cost of product * quantity */
	public void addQuantity(int q) {
		//Product p = new Product();
		this.quantity = quantity + q;
	}
	
	/** @param Cost the cost of product * quantity */
	public void decreaseQuantity(int q) {
		//Product p = new Product();
		this.quantity = quantity - q;
	}
	
	@Override
	public String toString() {
		 return "Order [" + product + ", quantity=" + quantity + ", Product Cost=" + getCost() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Order other = (Order) obj;
		
		return this.product == other.product 
				&& this.quantity == other.quantity;		
	}

	@Override
	public int compareTo(Order other) {
		int result = this.product.compareTo(other.product);
		
		if (result == 0) {
			result = Integer.compare(this.quantity, other.quantity);
		}
		return result;
	}

	@Override
	public int calculateCost(int i, int j) {
		if (quantity == 1 || quantity ==  2 || quantity ==  5 ) {
			quantity +=1;
		} 
		return quantity * getCost();
	}
	
}
