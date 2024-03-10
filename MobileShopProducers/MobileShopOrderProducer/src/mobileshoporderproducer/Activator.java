package mobileshoporderproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;
	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Order Producer Started ******");
		MobileShopOrderService mobileshoporderservice = new MobileShopOrderServiceImpl();
		serviceRegisterer = context.registerService(MobileShopOrderService.class.getName(), mobileshoporderservice, null);
	}
 
	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Order Producer Stopped ******");
		serviceRegisterer.unregister();
	}

}
