
/**
 * A Customer has a name, and a customer number.
 * 
 * @author P2519798
 */
public class Customer {
	//Fields
	private String customerID;
	private Name name;
	private int rewardPoints;
	
	//Constructors
	public Customer() {
		customerID = "";
		name = new Name();
		rewardPoints = 0;
	}
	
	public Customer(String customerID, Name name) {
		this.customerID = customerID;
		this.name = name;
	}
	
	public Customer(String customerID, Name name, int rewardPoints) {
		this.customerID = customerID;
		this.name = name;
		this.rewardPoints = rewardPoints;
	}

	/** @return the customerID */
	public String getCustomerID() {
		return customerID;
	}

	/** @param customerID the customerID to set */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/** @return the name */
	public Name getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(Name name) {
		this.name = name;
	}	
	
	/** @return the rewardPoints */
	public int getRewardPoints() {
		return rewardPoints;
	}

	/** @param rewardPoints the rewardPoints to set */
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", rewardPoints=" + rewardPoints + "]";
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Customer other = (Customer) obj;
		
		return this.customerID == other.customerID
				&& this.name == other.name;
		
	}
}
