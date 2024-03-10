package mobileshoporderconsumer;

import java.util.Scanner;
import mobileshoporderproducer.MobileShopOrderService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	Scanner sc = new Scanner(System.in);
	
	ServiceReference serviceOrderRef;
	static MobileShopOrderService mobileShopOrderService;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Order Consumer Started ******");
		serviceOrderRef = context.getServiceReference(MobileShopOrderService.class.getName());
		mobileShopOrderService = (MobileShopOrderService)context.getService(serviceOrderRef);
		
		while (true) {
			
			System.out.println("Select an option: ");
			System.out.println("Add Order (1)");
			System.out.println("Print Order Details (2)");
			System.out.println("Exit (99)");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1: {
				System.out.println("Please enter product item : ");
				String item = sc.next();
				
				System.out.println("Please enter product Customer Name : ");
				String custName = sc.next();
				
				System.out.println("Please enter total price : ");
				double total =  sc.nextDouble();
				
				mobileShopOrderService.addOrder(item,custName,total);
				System.out.println();

			    mobileShopOrderService.printReceipt();
				break;
			}
			case 2: {

				mobileShopOrderService.printReceipt();
				break;
			}
			default: 
				this.stop(context);
				return;
			}
		}
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Order Consumer Stopped ******");
		context.ungetService(serviceOrderRef);
	}

}
