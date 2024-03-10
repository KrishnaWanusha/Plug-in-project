package mobileshopproductconsumer;

import mobileshopproductproducer.MobileShopProductService;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	Scanner sc = new Scanner(System.in);
	
	ServiceReference serviceProductRef;
	static MobileShopProductService mobileShopProductService;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Product Consumer Started ******");
		serviceProductRef = context.getServiceReference(MobileShopProductService.class.getName());
		mobileShopProductService = (MobileShopProductService) context.getService(serviceProductRef);
		
		while (true) {
			System.out.println("Add product (1)");
			System.out.println("View products (2)");
			System.out.println("Exit (99)");
			System.out.println("Select an option: ");
			int option = sc.nextInt();
			
			switch(option) {
			case 1: {
				System.out.println("Please enter product brand : ");
				String brand = sc.next();
				
				System.out.println("Please enter product model : ");
				String model = sc.next();
				
				System.out.println("Please enter product manufactur year : ");
				String year = sc.next();
				
				System.out.println("Please enter product ram : ");
				int ram = sc.nextInt();
				
				System.out.println("Please enter product storage capacity : ");
				int storage = sc.nextInt();
				
				System.out.println("Please enter product retail price (LKR) : ");
				double retailPrice = sc.nextDouble();
				
				System.out.println("How many stock would you like to add? : ");
				int stock = sc.nextInt();
				
				mobileShopProductService.addProduct(brand, model, year, ram, storage, retailPrice, stock);
				System.out.println();

				mobileShopProductService.viewCatalogue();
				break;
			}
			case 2: {

				mobileShopProductService.viewCatalogue();
				break;
			}
			default: 
				this.stop(context);
				return;
			}
		}
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Product Consumer Stopped ******");
		context.ungetService(serviceProductRef);
	}

}