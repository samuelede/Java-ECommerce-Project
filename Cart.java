import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


/**
 * A cart is for a customer and has a delivery date and a unique id. It consists 
 * of a list of product orders, and a set of methods to add or remove an order, 
 * retrieve an order so that it can be modified or printed on a receipt, for 
 * example. The total cost of the Cart is given by the getTotalCost() 
 * method. An order can be searched for by product code.
 * A cart should also allow its orders to be sorted into their natural order via a 
 * sortOrders() method. It should provide an additional overloaded 
 * method sortOrders(Comparator<Order>) that accepts a custom 
 * comparator and applies this to the list of orders.
 * The cart requires two further methods: containsOrder and 
 * removeOrder, as shown in the UML diagram, that will make use of an 
 * equality test.
 * A cart should also provide an iterator over its orders.
 * 
 * @author P2519798
 */
public class Cart implements Iterable<Order>, Comparator<Order> {

	// Fields
	private String cartId;		//ID number of a particular product order
	private Customer customer; 	//Customer Name of a product order
	private Date date;			//Date Order was placed
	private ArrayList<Order> orders; //collection of product orders 
	
	//Constructors
	public Cart() {
		cartId = "";
		customer = new Customer();
		date = new Date();
		orders = new ArrayList<>();
	}
	
	public Cart(String cartId, Customer customer, Date date, ArrayList<Order> orders) {
		this.cartId = cartId;
		this.customer = customer;
		this.date = date;
		this.orders = orders;
	}
	
	//Methods
	/** @return the cartId */
	public String getCartId() {
		return cartId;
	}

	/** @param cartId the cartId to set */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	/** @return the customer */
	public Customer getCustomer() {
		return customer;
	}

	/** @param customer the customer to set */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/** @return the date */
	public Date getDate() {
		return date;
	}

	/** @param date the date to set */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/** @param addsOrder add an order */
	public void addOrder(Order o) {
		orders.add(o);
	}
	
	/** @param removeOrder removes an order */
	public void removeOrder(Order o) {
		/*int i = 0;
		if (0 <= i && i < orders.size()) {
			orders.remove(i);
		}*/ 
		orders.remove(o);
		
	}
	
	/**@return The Order it contains */
	public boolean containsOrder(Order o) {
		
		return orders.contains(o);
	}
	
	/** Clears all entries from the Cart */
    public void clearOrderList() {
        orders.clear();
    }
    
    /** Checks if the list of orders is empty.
     * @return true or false depending on whether the orders is empty. */
    public boolean isCartEmpty() {
    	return orders.isEmpty();
    }
	
	/** Returns the number of Orders in the Cart.
     * @return Number of Orders in the Cart. */
    public int numberOfOrders() {
    	int s = orders.size();
    	return s;
    }
    
	/** @return the TotalCost */
	public int getTotalCost() {
		int totalCost = 0;
		for (Order o : orders) {
			totalCost +=o.getCost();
		}
		return totalCost;
	}
		
	/** Increase the quantity by q.
     * @param The quantity at index i, provided <i> 
     * number of Order. Otherwise do nothing.*/
	public void increaseQuantity(int q, int i) {
		if (i > 0 && i < orders.size());  {
			Order s = orders.get(i);
			s.addQuantity(q);
		}
	}
	/** Decrease the quantity by q.
     * @param The quantity at index i, provided <i> 
     * number of Order. Otherwise do nothing.*/
	public void decreaseQuantity(int q, int i) {
		if (i+1 > 0 && i+1 < orders.size());  {
			Order s = orders.get(i);
			if (s.getQuantity() >= q) {
				s.decreaseQuantity(q);
			} else if(s.getQuantity() < q){
				System.out.println("Invalid quantity!");
			}
		}
	}
	
	/** Move Order i up one place in the cart. 
     * @param i The index of Order to move up, 
     * do nothing if i is out of range.*/
    public void moveUp(int i) {
        if (i > 0 && i < orders.size());  {
	        	Order s = orders.get(i - 1);
	        	orders.set(i-1,  orders.get(i));
	        	orders.set(i, s);
        }

    }
    
    /** Move Order i down one place in the cart. 
     * @param i The index of Order to move down, 
     * do nothing if i is out of range.*/
    public void moveDown(int i) {
        if (i >= 0 && i < orders.size()-1);  {
	        	Order s = orders.get(i + 1);
	        	orders.set(i+1,  orders.get(i));
	        	orders.set(i, s);
        }
    }
    
    /** Shuffles the orders in the cart into a random order */
    public void shuffleCart() {
    	Collections.shuffle(orders);
    }
    
    /** Searches for the provided productCode in the order list and returns true or false
     * @param productCode The productCode to be searched for.
     * @return true or false depending on whether the product exists in the cart. */
    public boolean findOrder(String productCode) {
    	/*for (int i = 0; i < orders.size(); i++) {
    		boolean s = orders.get(i).getProduct().getProductCode().equals(productCode);
    	}
		return s;*/
    	//using Java 8 streams
    	return orders.stream().anyMatch(s -> s.getProduct().getProductCode().equals(productCode));
    }
    
    /**Returns a string containing the Order list in numbered order
     * @return The Orders list in numbered order. */
    public String getOrderList() {
    	String s = "Cart ID: " + this.cartId + "\n";
        
        for (int i = 0; i < orders.size(); i++) {
            s = s + (i+1) + "\t" + orders.get(i).toString() + "\n";
        }
        return s;       
    }
    
    /**Show the number of products with a price less than that provided.
     * @param price The price to be compared against. Specifically orders with 
     * a price less than this will be displayed.
     * @return The number of orders with a price less than that provided.
     */
    public int displayProductsWithPriceLessThan(int price) {
    	//using Java 8 streams
    	return (int) orders.stream().filter(s -> s.getProduct().getUnitPrice() < price).count();
    	//return orders.forEach.stream().filter(s -> s.getProduct().getUnitPrice() < price);
    	//return orders.
    	//orders.forEach(x -> System.out.print(orders.stream().anyMatch(s -> s.getProduct().getUnitPrice() < price)));
    }
    
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", date=" + date + "]"; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Cart other = (Cart) obj;
		
		return this.cartId == other.cartId
				&& this.customer == other.customer 
					&& this.date == other.date
						&& this.orders == other.orders;		
	}

	@Override
	public Iterator<Order> iterator() {
		return orders.iterator();
	}

	public void sortOrders() {
		//Collections.sort(orders);
		orders.sort(Comparator.naturalOrder());
	}
	
	public void sortOrders(Comparator<Order> comparator) {
		orders.sort(comparator);;
	}

	@Override
	public int compare(Order o1, Order o2) {
		return 0;
	}
		
}
