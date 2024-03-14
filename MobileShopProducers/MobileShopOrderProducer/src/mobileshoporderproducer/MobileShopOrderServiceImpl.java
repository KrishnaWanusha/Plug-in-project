package mobileshoporderproducer;

import java.util.ArrayList;
import java.util.List;

import ordermodel.Order;

public class MobileShopOrderServiceImpl implements MobileShopOrderService{

	List<Order> orders = new ArrayList<Order>();
	Order order;
	
	public synchronized int addOrder(String item,String custName,double total) {
		if (!orders.isEmpty()) 
		{
			Order lastOrder = orders.get(orders.size() - 1);
			int id = lastOrder.getOrderId() + 1;
			Order newOrder = new Order(id, total, item, custName);
			orders.add(newOrder);
			return id;
		} 
		else {
			Order newOrder = new Order(1, total, item, custName);
			orders.add(newOrder);
			return 1;
		}
	}
	public List<Order> getOrders(){
		return orders;	
	}
	
	public Order getOrderById(int id) {
		for (Order order: orders) {
			if (order.getOrderId() == id) {
				return order;
			}
		}
		return null;
	}
	
	public void printReceipt(int orderId) {
		Order order = getOrderById(orderId);
	    System.out.println(" ___________________________________________________________");
	    System.out.println("|                                                           |");
	    System.out.println("|                M O B I L E S H O P                        |");
	    System.out.println("|                    ORDER RECEIPT                          |");
	    System.out.println("|___________________________________________________________|");
	    
	    System.out.printf("| Order ID: %d\n", order.getOrderId());
	    System.out.printf("| Customer Name: %s\n", order.getcustName());

	    System.out.println(" ___________________________________________________________");
	    System.out.println("|   Item                              |    Price            |");
	    System.out.println("|_____________________________________|_____________________|");

	        System.out.printf("| %-35s | LKR %-15.2f |\n",
	        		order.getItem(), order.getTotal());

	    System.out.println("|_____________________________________|_____________________|");
	}

	public void displayAllOrders() {
	    if (orders.isEmpty()) {
	        System.out.println("No orders found.");
	    } else {
	        System.out.println(" ___________________________________________________________");
	        System.out.println("|                                                           |");
	        System.out.println("|                M O B I L E S H O P                        |");
	        System.out.println("|                   ALL ORDERS                              |");
	        System.out.println("|___________________________________________________________|");

		    System.out.println(" ___________________________________________________________");
		    System.out.println("|   Item                              |    Price            |");
		    System.out.println("|_____________________________________|_____________________|");
		    
		    double total = 0;
	        for (Order order : orders) {

		        System.out.printf("| %-35s | LKR %-15.2f |\n",
		        		order.getItem(), order.getTotal());

			    System.out.println("|_____________________________________|_____________________|");
	            total = total + order.getTotal();
	        }
	        System.out.printf("| Total of all orders: LKR %-25.2f        |\n", total);
		    System.out.println("|___________________________________________________________|");
	    }
	}
	

}