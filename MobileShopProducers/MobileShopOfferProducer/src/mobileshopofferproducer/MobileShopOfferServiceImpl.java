package mobileshopofferproducer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mobileshopproductproducer.MobileShopProductService;
import productmodel.Product;

import offermodel.Offer;

public class MobileShopOfferServiceImpl implements MobileShopOfferService{
	
	List<Offer> offers = new ArrayList<Offer>();
	
	public MobileShopOfferServiceImpl(MobileShopProductService mobileShopProductService) {
		addOffer(5.0, Collections.singletonList(mobileShopProductService.getProductById(1)), true);
		addOffer(2.0, Collections.singletonList(mobileShopProductService.getProductById(2)), false);
	}

	public void addOffer(double discountPercentage, List<Product> applicableProducts, boolean active) {        
        if (!offers.isEmpty()) {
        	Offer lastOffer = offers.get(offers.size() - 1);
	        int offerId = lastOffer.getOfferId() + 1;
	        Offer newOffer = new Offer(offerId, discountPercentage, applicableProducts, active);
	        offers.add(newOffer);
	    } else {
	    	Offer newOffer = new Offer(1, discountPercentage, applicableProducts, active);
	        offers.add(newOffer);
	    }
    }
	
	public void viewAllOffers() {
	    System.out.println(" _________________________________________________________________");
	    System.out.println("|                                                                 |");
	    System.out.println("|                    M O B I L E S H O P                          |");
	    System.out.println("|                      All OFFERS LIST                            |");
	    System.out.println("|_________________________________________________________________|");

	    System.out.println(" ___________________________________________________________________");
	    System.out.println("|   ID   |   Discount (%)  |    Applicable Products     |  Active   |");
	    System.out.println("|________|_________________|____________________________|___________|");

	    for (Offer offer : offers) {
	        StringBuilder productsString = new StringBuilder();
	        for (Product product : offer.getApplicableProducts()) {
	            productsString.append(product.getBrand()).append(" ").append(product.getModel()).append(", ");
	        }
	        String applicableProducts = productsString.toString();
	        if (!applicableProducts.isEmpty()) {
	            applicableProducts = applicableProducts.substring(0, applicableProducts.length() - 2);
	        }
	        System.out.printf("|  %-5d |    %-12.2f |  %-25s |   %-6b |\n", offer.getOfferId(), offer.getDiscountPercentage(),
	                applicableProducts, offer.isActive());
	    }
	    System.out.println("|________|_________________|____________________________|__________|");
	}
	
	public void viewActiveOffers() {
	    System.out.println(" ___________________________________________________________________");
	    System.out.println("|                                                                   |");
	    System.out.println("|                M O B I L E S H O P                                |");
	    System.out.println("|                ACTIVE OFFERS LIST                                 |");
	    System.out.println("|___________________________________________________________________|");

	    System.out.println(" ___________________________________________________________________");
	    System.out.println("|   ID   |   Discount (%)  |    Applicable Products     |  Active   |");
	    System.out.println("|________|_________________|____________________________|___________|");
	    for (Offer offer : offers) {
	        if (offer.isActive()) {
	            StringBuilder productsString = new StringBuilder();
	            for (Product product : offer.getApplicableProducts()) {
	                productsString.append(product.getBrand()).append(" ").append(product.getModel()).append(", ");
	            }
	            String applicableProducts = productsString.toString();
	            if (!applicableProducts.isEmpty()) {
	                applicableProducts = applicableProducts.substring(0, applicableProducts.length() - 2);
	            }
	            System.out.printf("|  %-5d |    %-12.2f |  %-25s |   %-6b |\n", offer.getOfferId(), offer.getDiscountPercentage(),
	                    applicableProducts, offer.isActive());
	        }
	    }
	    System.out.println("|________|_________________|____________________________|__________|");
	}

	public void updateDiscountPercentage(int offerId, double discountPercentage) {
		boolean offerFound = false;
	    for (Offer offer : offers) {
	        if (offer.getOfferId() == offerId) {
	            offer.setDiscountPercentage(discountPercentage);
	            System.out.println("Offer with ID " + offerId + " Discount Percentage has been updated successfully.");
	            offerFound = true;
	            break;
	        }
	    }
	    if (!offerFound) {
	        System.out.println("Offer with ID " + offerId + " not found.");
	    }
	}
	
	public void updateStatus(int offerId, boolean active) {
		boolean offerFound = false;
	    for (Offer offer : offers) {
	        if (offer.getOfferId() == offerId) {
	            offer.setActive(active);
	            System.out.println("Offer with ID " + offerId + " Status has been updated successfully.");
	            offerFound = true;
	            break;
	        }
	    }
	    if (!offerFound) {
	        System.out.println("Offer with ID " + offerId + " not found.");
	    }
	}
	
	public Offer getOfferById(String offerId) {
		for (Offer offer: offers) {
			if (offer.getOfferId() == Integer.parseInt(offerId) ) {
				return offer;
			}
		}
		return null;
	}
	
	public double checkDiscountForProducts(Product applicableProduct) {
	    for (Offer offer : offers) {
	        List<Product> offerApplicableProducts = offer.getApplicableProducts();
	        if (offer.isActive() && offerApplicableProducts.contains(applicableProduct)) {
	            return offer.getDiscountPercentage();
	        }
	    }
	    return 0;
	}

	
	

}
