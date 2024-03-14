package mobileshopofferproducer;

import mobileshopproductproducer.MobileShopProductService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	ServiceReference serviceProductRef;
	static MobileShopProductService mobileShopProductService;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Offer Producer Started ******");
		serviceProductRef = context.getServiceReference(MobileShopProductService.class.getName());
		mobileShopProductService = (MobileShopProductService) context.getService(serviceProductRef);
		
		MobileShopOfferService mobileshopofferservice = new MobileShopOfferServiceImpl(mobileShopProductService);
		serviceRegisterer = context.registerService(MobileShopOfferService.class.getName(), mobileshopofferservice, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Offer Producer Stopped ******");
		serviceRegisterer.unregister();
	}

}
