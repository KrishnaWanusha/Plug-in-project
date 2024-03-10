package mobileshopcustomerproducer;
 
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
 
public class Activator implements BundleActivator {
 
	ServiceRegistration serviceRegisterer;
	public void start(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Customer Producer Started ******");
		MobileShopCustomerService mobileshopcustomerservice = new MobileShopCustomerServiceImpl();
		serviceRegisterer = context.registerService(MobileShopCustomerService.class.getName(), mobileshopcustomerservice, null);
	}
 
	public void stop(BundleContext context) throws Exception {
		System.out.println("****** Mobile Shop Customer Producer Stopped ******");
		serviceRegisterer.unregister();
	}
 
}