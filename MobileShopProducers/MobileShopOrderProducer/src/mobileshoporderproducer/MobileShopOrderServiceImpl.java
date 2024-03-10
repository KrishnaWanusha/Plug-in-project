package mobileshoporderproducer;

import java.util.ArrayList;
import java.util.List;

import ordermodel.Order;

public class MobileShopOrderServiceImpl implements MobileShopOrderService{

	List<Order> orders = new ArrayList<Order>();
	Order order;
	
	public synchronized void addOrder(String item,String custName,double total) {
		if (!orders.isEmpty()) 
		{
			Order lastOrder = orders.get(orders.size() - 1);
			int id = lastOrder.getOrderId() + 1;
			Order newOrder = new Order(id, total, item, custName);
			orders.add(newOrder);
		} 
		else {
			Order newOrder = new Order(1, total, item, custName);
			orders.add(newOrder);
			
		}
	}
	public List<Order> getOrders(){
		return orders;	
	}
	
	public void printReceipt() {
	    System.out.println(" ___________________________________________________________");
	    System.out.println("|                                                           |");
	    System.out.println("|                M O B I L E S H O P                        |");
	    System.out.println("|                    RECEIPT                                |");
	    System.out.println("|___________________________________________________________|");

	    System.out.printf("Order ID: %d\n", order.getOrderId());
	    System.out.printf("Customer Name: %s\n", order.getcustName());

	    System.out.println(" ___________________________________________________________");
	    System.out.println("|   Item     |");
	    System.out.println("|____________|");

	    // Assuming you have a list of items in the receipt, you can iterate through them
	    for (Order order : orders) {
	        System.out.printf("| %-20s |\n",
	        		order.getItem());
	    }

	    System.out.println("|______________________|______________|_________________|");

	    System.out.printf("Total: LKR %.2f\n",order.getTotal());

	    System.out.println("|___________________________________________________________|");
	}

	
	

}