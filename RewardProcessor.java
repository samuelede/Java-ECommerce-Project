import java.util.HashSet;

/**
 * A reward processor should store products, which can gain rewards for the 
 * customer if they are in their shopping cart. A hash set collection should 
 * be used for this. The rewardPoints(Cart) method checks if a rewardable 
 * product is in the cart, and if so adds points to the cart's customer. 
 * The number of points to be added should be the quantity of that particular 
 * order. The method should return the total number of reward points that 
 * have been awarded to the customer for this cart.  
 * 
 * @author P2519798
 *
 */
public class RewardProcessor implements Comparable<Product>{
	
	//fields
	HashSet<Product> products = new HashSet<>();
	
	public RewardProcessor() {
		products = new HashSet<>();
	}
	
	public RewardProcessor(HashSet<Product> products) {
		this.products = products;
	}
	
	//methods
	/** @return the products */
	public HashSet<Product> getProducts() {
		return products;
	}

	/** @param products the products to set */
	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}
	
	/** @return addProduct the product to add */
	public boolean addProduct(Product p) {
		return products.add(p);		
	}
	
	/** @return removeProduct the product to remove */
	public boolean removeProduct(Product p) {
		return products.remove(p);		
	}
	
	/** @param rewardPoints the points to add */
	public int rewardPoints(Cart c) {
		int points = 0;
		
		//c.getOrderList().compareTo(getP)stream().anyMatch(s -> s.getProduct().getProductCode().equals(productCode));
		//return products.stream().anyMatch(s -> s.getProductCode().equals(c));
		c.getCustomer().setRewardPoints(points);
		return points;
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		RewardProcessor other = (RewardProcessor) obj;
		
		return this.products == other.products;
		
	}
	
	
}
