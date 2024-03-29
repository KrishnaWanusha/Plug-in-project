package mobileshopproductproducer;

import java.util.List;

import productmodel.Product;

public interface MobileShopProductService {

	void addProduct(String brand, String model, String year, int ram, int storage, double retailPrice, int stock);
	List<Product> getProducts();
	void restockProduct(Product product, int qty);
	void viewCatalogue();
	Product getProductById(int id);
	void deleteProductById(int id);
	void stockUpdate(int id);
}
