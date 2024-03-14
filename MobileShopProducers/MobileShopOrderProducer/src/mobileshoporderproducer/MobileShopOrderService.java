package mobileshoporderproducer;

import java.util.List;

import ordermodel.Order;

public interface MobileShopOrderService {
	int addOrder(String item,String custName,double total);
	List<Order> getOrders();
	Order getOrderById(int id);
	void printReceipt(int orderId);
	void displayAllOrders();
	
}
