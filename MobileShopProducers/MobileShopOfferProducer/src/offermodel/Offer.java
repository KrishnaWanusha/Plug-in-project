package offermodel;

import java.util.List;

public class Offer {

	private int offerId;
    private double discountPercentage;
    private List<String> applicableProducts;
    private boolean active;
    
	public Offer(int offerId, double discountPercentage, List<String> applicableProducts, boolean active) {
        this.offerId = offerId;
        this.discountPercentage = discountPercentage;
        this.applicableProducts = applicableProducts;
        this.active = active;
    }

    public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public List<String> getApplicableProducts() {
		return applicableProducts;
	}
	public void setApplicableProducts(List<String> applicableProducts) {
		this.applicableProducts = applicableProducts;
	}
    public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
