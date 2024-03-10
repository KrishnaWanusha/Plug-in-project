package mobileshopofferproducer;

import java.util.List;

import offermodel.Offer;

public interface MobileShopOfferService {
	
	void addOffer(double discountPercentage, List<String> applicableProducts, boolean active);

    void viewAllOffers();

    void viewActiveOffers();

    void updateDiscountPercentage(int offerId, double discountPercentage);

    void updateStatus(int offerId, boolean active);
    
    Offer getOfferById(String id);
    
    double checkDiscountForProducts(String applicableProducts);

}
