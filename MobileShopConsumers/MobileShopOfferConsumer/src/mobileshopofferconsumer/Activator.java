package mobileshopofferconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mobileshopofferproducer.MobileShopOfferService;
import mobileshopproductproducer.MobileShopProductService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import productmodel.Product;

public class Activator implements BundleActivator {

	Scanner sc = new Scanner(System.in);

	ServiceReference serviceOfferRef;
	ServiceReference serviceProductRef;
	static MobileShopOfferService mobileShopOfferService;
	static MobileShopProductService mobileshopproductservice;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Offer Consumer Started ******");
		serviceOfferRef = context.getServiceReference(MobileShopOfferService.class.getName());
		mobileShopOfferService = (MobileShopOfferService) context.getService(serviceOfferRef);
		
		while(true) {
			System.out.println("Add Offer (1)");
			System.out.println("View All Offers (2)");
			System.out.println("View Active Offers (3)");
			System.out.println("Update Discount Percentage (4)");
			System.out.println("Update Offer Status (5)");
			System.out.println("Exit (99)");
			System.out.println("Select an option: ");
			int option = sc.nextInt();
			
			switch(option) {
			case 1: {
				
				List<Product> applicableProducts = new ArrayList<>();
			    boolean addMoreProducts = true;
			    while (addMoreProducts) {
			    	
			    	mobileshopproductservice.viewCatalogue();
			        System.out.println("Enter applicable product: ");
			        int product = sc.nextInt();
			        applicableProducts.add(mobileshopproductservice.getProductById(product));
			        
			        // Ask user if they want to add more products
			        System.out.println("Add more applicable products? (1: Yes, 2: No)");
			        int choice = sc.nextInt();
			        if (choice != 1) {
			            addMoreProducts = false;
			        }
			    }
			    
				System.out.println("Please enter discount percentage: ");
				double discountPercentage = sc.nextDouble();
				
				mobileShopOfferService.addOffer( discountPercentage, applicableProducts, true);
			    System.out.println("Offer added successfully.");
			    mobileShopOfferService.viewActiveOffers();
			    break;
			}
			case 2: {
				mobileShopOfferService.viewAllOffers();
			    break;
			}
			case 3: {
				mobileShopOfferService.viewActiveOffers();
			    break;
			}
			case 4: {
				mobileShopOfferService.viewAllOffers();
				System.out.println("Please enter offer ID: ");
			    int offerId = sc.nextInt();
			    System.out.println("Please enter new discount percentage: ");
			    double newDiscountPercentage = sc.nextDouble();
			    mobileShopOfferService.updateDiscountPercentage(offerId, newDiscountPercentage);
			    break;
			}
			case 5: {
				System.out.println("Please enter offer ID: ");
			    int offerId = sc.nextInt();
			    System.out.println("Please enter new status (true/false): ");
			    boolean newStatus = sc.nextBoolean();
			    mobileShopOfferService.updateStatus(offerId, newStatus);
			    break;
			}
			default: 
				this.stop(context);
				return;
			}
			
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Offer Consumer Stopped ******");
		context.ungetService(serviceOfferRef);
	}

}
