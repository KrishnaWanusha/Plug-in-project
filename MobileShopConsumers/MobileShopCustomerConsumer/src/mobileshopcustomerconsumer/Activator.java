package mobileshopcustomerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import productmodel.Product;
import Customermodel.Customer;
//import productmodel.Product;
import mobileshopcustomerproducer.MobileShopCustomerService;
import mobileshopofferproducer.MobileShopOfferService;
import mobileshoporderproducer.MobileShopOrderService;
//import mobileshopofferproducer.MobileShopOfferService;
//import mobileshoporderproducer.MobileShopOrderService;
//import mobileshopproductproducer.MobileShopProductService;
import mobileshopproductproducer.MobileShopProductService;

public class Activator implements BundleActivator {

	private static BundleContext context;

    Scanner sc = new Scanner(System.in);
	
	ServiceReference serviceCustomerRef;
	ServiceReference serviceProductRef;
	ServiceReference serviceOffersRef;
	ServiceReference serviceOrderRef;
	static MobileShopCustomerService mobileshopcustomerservice;
	static MobileShopProductService mobileshopproductservice;
	static MobileShopOfferService mobileshopofferservice;
	static MobileShopOrderService mobileshoporderservice;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Customer Consumer Started ******");
		serviceCustomerRef = context.getServiceReference(MobileShopCustomerService.class.getName());
		serviceProductRef = context.getServiceReference(MobileShopProductService.class.getName());
		serviceOffersRef = context.getServiceReference(MobileShopOfferService.class.getName());
		serviceOrderRef = context.getServiceReference(MobileShopOrderService.class.getName());
		mobileshopcustomerservice = (MobileShopCustomerService) context.getService(serviceCustomerRef);
		mobileshopproductservice = (MobileShopProductService) context.getService(serviceProductRef);
		mobileshopofferservice = (MobileShopOfferService) context.getService(serviceOffersRef);
		mobileshoporderservice = (MobileShopOrderService) context.getService(serviceOrderRef);
		
		while (true) {
			System.out.println("Add customer (1)");
			System.out.println("Place order (2)");
			System.out.println("View all customers (3)");
			System.out.println("Exit (99)");
			System.out.println("Select an option: ");
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1: {
				
				System.out.println("Please enter customer name : ");
				String Cname = sc.nextLine();
				
				System.out.println("Please enter address : ");
				String adress = sc.nextLine();
				
				System.out.println("Please enter customer mobile number : ");
				int phnNumber = sc.nextInt();
				
				mobileshopcustomerservice.addCustomerRecord(Cname, adress, phnNumber);
				System.out.println();

				mobileshopcustomerservice.viewCustomerDetails();
				break;
			}
			case 2: {

				mobileshopcustomerservice.viewCustomerDetails();
				System.out.println("Select customer: ");
				int cusId = sc.nextInt();
				Customer customer = mobileshopcustomerservice.getCustomerById(cusId);
				
				if (customer == null) {
					System.out.println("Invalid customer");
					break;
				}
				
				mobileshopproductservice.viewCatalogue();
				System.out.println("Select product: ");
				int prodId = sc.nextInt();
				
				Product product = mobileshopproductservice.getProductById(prodId);
				
				if (product == null) {
					System.out.println("Invalid product");
					break;
				}
				
				double discount = mobileshopofferservice.checkDiscountForProducts(product);
				
				double discountedPrice = 0.0;
				
				if (discount > 0) {
					discountedPrice = product.getRetailPrice() * (discount/100);
					System.out.println("This product has a discount of " + discount + "%");
					System.out.println("Discounted price LKR: " + discountedPrice);
				}
				else {
					System.out.println("");
				}
				int orderId = mobileshoporderservice.addOrder(String.join(" ", product.getBrand(), product.getModel()), customer.getCname(), product.getRetailPrice() - discountedPrice);
				mobileshopproductservice.stockUpdate(product.getId());
				mobileshoporderservice.printReceipt(orderId);
				break;
			}
			case 3: {
				mobileshopcustomerservice.viewCustomerDetails();
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
		context.ungetService(serviceProductRef);
		context.ungetService(serviceOffersRef);
		context.ungetService(serviceOrderRef);
	}
	
	
}
  