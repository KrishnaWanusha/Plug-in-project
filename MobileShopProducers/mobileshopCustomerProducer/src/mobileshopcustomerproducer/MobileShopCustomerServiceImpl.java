package mobileshopcustomerproducer;

import java.util.ArrayList;
import java.util.List;

import Customermodel.Customer;

public class MobileShopCustomerServiceImpl implements MobileShopCustomerService {
	
	List<Customer> customers = new ArrayList<Customer>();
	
	// addCustomerRecord Implementation
	
	@Override
	public synchronized void addCustomerRecord(String name, String address, int phnNumber) {
		if (!customers.isEmpty()) {
			Customer lastCustomer = customers.get(customers.size() - 1);
			int id = lastCustomer.getCustomerid() + 1;
			Customer newCustomer = new Customer(id, name, address, phnNumber);
            customers.add(newCustomer);
        } else {
        	Customer newCustomer = new Customer(1, name, address, phnNumber);
        	customers.add(newCustomer);
        }
		
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void viewCustomerDetails() {
	    System.out.println(" ___________________________________________________________");
	    System.out.println("|                                                           |");
	    System.out.println("|              M O B I L E S H O P              |");
	    System.out.println("|           CUSTOMER DETAILS              |");
	    System.out.println("|___________________________________________________________|");

	    System.out.println(" ________________________________________");
	    System.out.println("|    ID   |    Name    |   Address   | Phone Number |");
	    System.out.println("|_________|____________|_____________|______________|");

	    // Assuming you have a list of Customer objects called customers
	    for (Customer customer : customers) {
	        System.out.printf("|  %-6d |  %-10s |  %-15s |  %-12d |\n",
	                customer.getCname(), customer.getAdress(), customer.getPhnNumber());
	    }

	    System.out.println("|_________|____________|_____________|______________|");
	}

}
