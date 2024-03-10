package mobileshoporderproducer;

import java.util.List;

import ordermodel.Order;

public interface MobileShopOrderService {
	void addOrder(String item,String custName,double total);
	List<Order> getOrders();
	void printReceipt();
	
}
