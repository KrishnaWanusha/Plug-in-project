package mobileshopcustomerproducer;

import java.util.List;

import Customermodel.Customer;

public interface MobileShopCustomerService {

	// Add new customerRecords

	public void  addCustomerRecord( String name,String address, int phnNumber);
	
	public List<Customer> getCustomers();
	
	public void viewCustomerDetails();
	
	Customer getCustomerById(int id);
}
