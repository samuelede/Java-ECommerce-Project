import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * ***Shopping Cart System***
 * 
 * @author P2519798
 *
 */
public class CartTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("UC1: Populate Cart with Orders for Products/Discount Products...");
		System.out.println("----------------------------------------------------------------");
		
		//Creating ArrayList of Order with Products
		ArrayList<Order> o1 = new ArrayList<>();
		//Order o = new Order(new Product("PDT002","Pencils", 5), 5000);
		//Creating a Customer
		Customer c1=	new Customer("CID0009", new Name("Bob", "Fisher"));
		//Creating an Instance of Cart and adding Orders for Products
		Cart c = new Cart("C001", c1, new Date(10, 1, 2020), o1);
		
		//Order o = new Order();
		o1.add(new Order(new Product("PDT002","Pencils", 5), 5000));
		o1.add(new Order(new Product("PDT004","Paper", 295), 50));
		o1.add(new Order(new DiscountProduct("PDTD01", "NIKE", 600, 10.0), 47));
		o1.add(new Order(new Product("PDT008","Hoods", 50), 295));
		o1.add(new Order(new Product("PDT012","HeadGear", 50), 600));
		
		/*c.addOrder(new Order(new Product("PDT002","Pencils", 5), 5000));
		c.addOrder(new Order(new Product("PDT004","Stapels", 25), 50));
		c.addOrder(new Order(new Product("PDT006","Trainer", 250), 700));
		c.addOrder(new Order(new Product("PDT008","Hoods", 55), 200));
		c.addOrder(new Order(new Product("PDT012","HeadGear", 50), 50));*/
		c.forEach(System.out::println);
		//cart2.forEach(System.out::println);
		System.out.print("\nTotal Orders in the Cart: "+ o1.size());
		System.out.println("Total Cost: "+c.getTotalCost());
				
		System.out.println("\n--------------------------------------------");
		System.out.println("UC2: Testing the sort methods...");
		System.out.println("--------------------------------------------");
		
		
		System.out.println("\nSort Orders by natural Sort...");
		//Order orders = new Order();
		c.sortOrders();
		c.forEach(x -> System.out.println(x) );
		
		System.out.println("\nSort and Compare Orders by Cost (asc) and then Products (desc)");
		c.sortOrders(Comparator
				.comparing(Order::getCost)
						.thenComparing(Order::getCost).reversed()
						.thenComparing((Order::getProduct)).reversed());
						//.thenComparing((Order s) -> s.getProduct().getProductCode()));
				
		c.forEach(x -> System.out.println(x) );
		
		System.out.println("\n----------------------------------------------------------------------");
		System.out.println("UC3: Equality Test/Remove method and Cart Receipt using PrintWriter...");
		System.out.println("----------------------------------------------------------------------");
		
		System.out.print("Cart Contains Orders at index <1>: ");
		Order t = o1.get(1);
		//Order u = o1.get(2);
		System.out.println(c.containsOrder(t));
		//System.out.println(o.compareTo(o) == 0);
		
		c.sortOrders();
		c.forEach(x -> System.out.println(x) );
		System.out.println("\nRemove Order at index 1");
		c.removeOrder(t);
		c.forEach(x -> System.out.println(x) );
		
		System.out.println("\nCart Reciept with Total cost: "+ c.getTotalCost() +" written to file Cart.txt");
		//uses a print writer to print output to a file, instead of to the console.
		//to view the generated file you will need to right-click and refresh your project.
		PrintWriter pw = new PrintWriter("Cart.txt");

		pw.println("Receipt of Orders for Shopping Cart");
		pw.println("====================================");
		pw.println("\nCustomer Details: = " + c.getCustomer());
		pw.println("Order List = " + c.getOrderList() );
		pw.println("Total Orders in the Cart: "+ o1.size());
		pw.println("Total Cost: = " + c.getTotalCost());

		pw.flush();
		pw.close();
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("UC4: Other Methods, Increase and Decrease quantity...");
		System.out.println("-----------------------------------------------------");
		
		System.out.println("\nIncrease Product Quantity at index 2 by 200 ");
		c.increaseQuantity(200, 2);
		c.forEach(x -> System.out.println(x) );
		
		System.out.println("\nDecrease Product Quantity at index 3 by 20 ");
		c.decreaseQuantity(20, 3);
		c.forEach(x -> System.out.println(x) );
		System.out.println("\nShuffle Cart: ");
		c.shuffleCart();
		c.forEach(x -> System.out.println(x) );
				
		System.out.print("List of Products with price less than <50>: ");
		System.out.println(c.displayProductsWithPriceLessThan(50));
		
		System.out.println("\nList of Orders and Products");
		System.out.print(c.getOrderList());
		
		System.out.println("\nCheck if Cart contains Order at index 2");
		//System.out.println(c.containsOrder(2));
		
		System.out.print("\nSearch Order by product Code \"PDT002\": ");
		System.out.println(c.findOrder("PDT002"));
		c.findOrder("PDT002");
		
		System.out.print("\nMove Order at index 1 up: ");
		c.moveUp(1);
		c.forEach(System.out::println);
		
		System.out.print("\nMove Order at index 2 down: ");
		c.moveDown(2);
		c.forEach(System.out::println);
		
		/*System.out.print("Clear cart. ");
		cart.clearOrderList();
		System.out.print("Check if cart is empty: ");
		System.out.println(cart.isCartEmpty());*/
		
		System.out.println("\n--------------------------------------------");
		System.out.println("UC5: Reward Processor for Products...");
		System.out.println("--------------------------------------------");
		RewardProcessor rp = new RewardProcessor();		
		Product p = new Product("PDT202", "Floos", 45);
		Product p1 = new Product("PDT202", "Floos", 45);
		Product p2 = new Product("PDT012","HeadGear", 50);
		rp.addProduct(new Product("PDT202", "Floos", 45));
		rp.addProduct(p);
		rp.addProduct(p1);
		rp.addProduct(p2);
		System.out.println("Number of Products with Reward Points: " + rp.products.size());
		
		//System.out.println(rp.rewardPoints(cart));
		
	}
}
