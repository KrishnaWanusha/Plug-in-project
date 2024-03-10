package mobileshopproductproducer;

import java.util.ArrayList;
import java.util.List;

import productmodel.Product;

public class MobileShopProductServiceImpl implements MobileShopProductService {

	List<Product> products = new ArrayList<Product>();
	
	public MobileShopProductServiceImpl() {
        addProduct("Samsung", "Galaxy", "2023", 8, 128, 799.99, 15);
        addProduct("Apple", "iPhone", "2023", 6, 64, 999.99, 10);
    }
	
	public void addProduct(String brand, String model, String year, int ram, int storage, double retailPrice, int stock) {
		if (!products.isEmpty()) {
	        Product lastProduct = products.get(products.size() - 1);
	        int id = lastProduct.getId() + 1;
	        Product newProduct = new Product(id, brand, model, year, ram, storage, retailPrice, stock);
	        products.add(newProduct);
	    } else {
	        Product newProduct = new Product(1, brand, model, year, ram, storage, retailPrice, stock);
	        products.add(newProduct);
	    }
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void restockProduct(Product product, int qty) {
		product.setStock(qty);
	}
	
	public void viewCatalogue() {
		System.out.println(" ___________________________________________________________");
		System.out.println("|                                                           |");
		System.out.println("|      				M O B I L E S H O P |");
		System.out.println("|    					CATALOGUE     			|");
		System.out.println("|___________________________________________________________|");
        
        for (Product product : products) {
            System.out.printf("%d. %s %s (%s) - %dGB %d LKR.%.2f Stock(%d)\n",
            		product.getId(), product.getBrand(), product.getModel(), product.getYear(),
                    product.getRam(), product.getStorage(), product.getRetailPrice(), product.getStock());
        }
        
		
	}
	
	public Product getProductById(String id) {
		for (Product product: products) {
			if (product.getId() == Integer.parseInt(id) ) {
				return product;
			}
		}
		return null;
	}
	
}
