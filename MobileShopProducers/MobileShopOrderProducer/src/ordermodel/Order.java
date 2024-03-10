package ordermodel;

public class Order {
	private int orderId;
	private double total;
	private String item;
	private String custName;
	public Order(int orderId, double total, String item,String custName) {
		
		this.orderId = orderId;
		this.total = total;
		this.item = item;
		this.custName= custName;
		
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getcustName() {
		return custName;
	}
	public void setcustName(String custName) {
		this.custName = custName;
	}
	
	}
	

