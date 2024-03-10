package mobileshopproductproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Product Producer Started ******");
		MobileShopProductService mobileshopproductservice = new MobileShopProductServiceImpl();
		serviceRegisterer = context.registerService(MobileShopProductService.class.getName(), mobileshopproductservice, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Product Producer Stopped ******");
		serviceRegisterer.unregister();
	}

}
