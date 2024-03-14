package mobileshopofferproducer;

import java.util.List;

import offermodel.Offer;
import productmodel.Product;

public interface MobileShopOfferService {
	
	void addOffer(double discountPercentage, List<Product> applicableProducts, boolean active);

    void viewAllOffers();

    void viewActiveOffers();

    void updateDiscountPercentage(int offerId, double discountPercentage);

    void updateStatus(int offerId, boolean active);
    
    Offer getOfferById(String id);
    
    double checkDiscountForProducts(Product applicableProduct);

}
