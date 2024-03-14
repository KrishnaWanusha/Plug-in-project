package mobileshopproductproducer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import productmodel.Product;

public class MobileShopProductServiceImpl implements MobileShopProductService {

	List<Product> products = new ArrayList<Product>();
	
	public MobileShopProductServiceImpl() {
        addProduct("Samsung", "S23 Ultra", "2023", 8, 128, 285000.00, 15);
        addProduct("Apple", "iPhone 15", "2023", 6, 64, 415000.00, 10);
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
		System.out.println(" ______________________________________________________________");
		System.out.println("|                                                              |");
		System.out.println("|                  M O B I L E   S H O P                       |");
		System.out.println("|                         CATALOGUE                            |");
		System.out.println("|______________________________________________________________|");

        System.out.println();
        System.out.println(" __________________________________________________________________________________");
        System.out.println("|  ID  |   Brand   |   Model   | Year | RAM | Storage |       Price        | Stock |");
        System.out.println("|______|___________|___________|______|_____|_________|____________________|_______|");

        for (Product product : products) {
            System.out.printf("| %-5d| %-10s| %-10s| %-5s| %-4d| %-8d| LKR %-15.2f| %-6d|\n",
                    product.getId(), product.getBrand(), product.getModel(), product.getYear(),
                    product.getRam(), product.getStorage(), product.getRetailPrice(), product.getStock());
        }
        System.out.println("|______|___________|___________|______|_____|_________|____________________|_______|");
        System.out.println();
	}
	
	public Product getProductById(int id) {
		for (Product product: products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
	
	public void deleteProductById(int id) {
		Iterator<Product> iterator = products.iterator();
	    while (iterator.hasNext()) {
	        Product product = iterator.next();
	        if (product.getId() == id) {
	            iterator.remove();
	        }
	    }
	}
	
	public void stockUpdate(int id) {
		for (Product product: products) {
			if (product.getId() == id) {
				product.setStock(product.getStock() - 1);
			}
		}
	}
	
}
