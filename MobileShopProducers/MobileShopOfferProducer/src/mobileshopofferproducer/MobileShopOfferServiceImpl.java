package mobileshopofferproducer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import offermodel.Offer;

public class MobileShopOfferServiceImpl implements MobileShopOfferService{
	
List<Offer> offers = new ArrayList<Offer>();
	
	public MobileShopOfferServiceImpl() {
		addOffer( 10.0, List.of("iPhone X", "Iphone 15 Pro"), true);
        addOffer( 0.0, List.of("Android"), false);
	}
	
	public void addOffer( double discountPercentage, List<String> applicableProducts, boolean active) {        
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
        System.out.println("|   ID   |   Discount (%)  |    Applicable Products   |  Active   |");
        System.out.println("|________|_________________|__________________________|___________|");
        for (Offer offer : offers) {
            System.out.printf("|  %-5d |    %-12.2f |  %-20s   |   %-6b |\n", offer.getOfferId(), offer.getDiscountPercentage(),
                    String.join(", ", offer.getApplicableProducts()), offer.isActive());
        }
        System.out.println("|________|_________________|__________________________|__________|");
    }
	
	public void viewActiveOffers() {
	    System.out.println(" ___________________________________________________________________");
	    System.out.println("|                                                                   |");
	    System.out.println("|                M O B I L E S H O P                                |");
	    System.out.println("|                ACTIVE OFFERS LIST                                 |");
	    System.out.println("|___________________________________________________________________|");
	    System.out.println("|   ID   |   Discount (%)  |     Applicable Products     |  Active  |");
	    System.out.println("|________|_________________|_____________________________|__________|");
	    for (Offer offer : offers) {
	        if (offer.isActive()) {
	            System.out.printf("|  %-5d |    %-12.2f |  %-20s   |   %-6b |\n", offer.getOfferId(), offer.getDiscountPercentage(),
	                    String.join(", ", offer.getApplicableProducts()), offer.isActive());
	        }
	    }
	    System.out.println("|________|_________________|_____________________________|__________|");
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
	
	public double checkDiscountForProducts(String applicableProductsString) {
	    String[] applicableProductsArray = applicableProductsString.split("\\s*,\\s*"); 
	    List<String> applicableProductsList = Arrays.asList(applicableProductsArray); 
	    for (Offer offer : offers) {
	        if (offer.isActive() && offer.getApplicableProducts().containsAll(applicableProductsList)) {
	            return offer.getDiscountPercentage();
	        }
	    }
	    return 0.0; 
	}

	
	

}
