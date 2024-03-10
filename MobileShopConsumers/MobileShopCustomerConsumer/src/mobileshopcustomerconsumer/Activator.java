package mobileshopcustomerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import mobileshopcustomerproducer.MobileShopCustomerService;

public class Activator implements BundleActivator {

	private static BundleContext context;

    Scanner sc = new Scanner(System.in);
	
	ServiceReference serviceCustomerRef;
	static MobileShopCustomerService mobileshopcustomerservice;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Customer Consumer Started ******");
		serviceCustomerRef = context.getServiceReference(MobileShopCustomerService.class.getName());
		mobileshopcustomerservice = (MobileShopCustomerService) context.getService(serviceCustomerRef);
		
		while (true) {
			System.out.println("Add customer (1)");
			System.out.println("Place order (2)");
			System.out.println("Exit (99)");
			System.out.println("Select an option: ");
			int option = sc.nextInt();
			
			switch(option) {
			case 1: {
				
				System.out.println("Please enter customer name : ");
				String Cname = sc.next();
				
				System.out.println("Please enter address : ");
				String adress = sc.next();
				
				System.out.println("Please enter customer number : ");
				int phnNumber = sc.nextInt();
				
				mobileshopcustomerservice.addCustomerRecord(Cname, adress, phnNumber);
				System.out.println();

				mobileshopcustomerservice.viewCustomerDetails();
				break;
			}
			case 2: {

				mobileshopcustomerservice.viewCustomerDetails();
				System.out.println("Select customer: ");
				int customer = sc.nextInt();
				
				break;
			}
			default: 
				this.stop(context);
				return;
			}
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Customer Consumer Stop ******");
		context.ungetService(serviceCustomerRef);
	}
	
	
}
  