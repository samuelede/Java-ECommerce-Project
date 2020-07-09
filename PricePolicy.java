
/**
 * @author P2519798
 * The functional interface PricePolicy, contains a single abstract method 
 * called calculateCost, which accepts two integers representing quantity 
 * and unit price, and returns an integer representing the calculated cost, 
 * for the given price policy.
 */
public interface PricePolicy {
	
	public int calculateCost(int i, int j);
}
