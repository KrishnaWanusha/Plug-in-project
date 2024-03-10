package mobileshopofferproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;

	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Offer Producer Started ******");
		MobileShopOfferService mobileshopofferservice = new MobileShopOfferServiceImpl();
		serviceRegisterer = context.registerService(MobileShopOfferService.class.getName(), mobileshopofferservice, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Offer Producer Stopped ******");
		serviceRegisterer.unregister();
	}

}
