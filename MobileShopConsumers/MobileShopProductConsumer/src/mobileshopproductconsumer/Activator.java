package mobileshopproductconsumer;

import mobileshopproductproducer.MobileShopProductService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			System.out.println("-------Product Services-------");
			System.out.println("1. View products");
			System.out.println("2. Add product");
			System.out.println("3. Remove product");
			System.out.println("4. Change product price");
			System.out.println("99. Exit");
			System.out.println("Select an option: ");
			int option = sc.nextInt();
			
			switch(option) {
			case 1: {
				mobileShopProductService.viewCatalogue();
				break;
			}
			case 2: {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			    
				System.out.println("Please enter product brand : ");
			    String brand = in.readLine();
			    		
			    System.out.println("Please enter product model : ");
			    String model = in.readLine();

			    System.out.println("Please enter product manufactur year : ");
			    String year = in.readLine();

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
			case 3: {
				mobileShopProductService.viewCatalogue();
				System.out.println("Select the product id that you wish to delete : ");
				int id = sc.nextInt();
				
				mobileShopProductService.deleteProductById(id);
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
