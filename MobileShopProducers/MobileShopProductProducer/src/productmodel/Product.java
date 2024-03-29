package productmodel;

public class Product {

	private int id;
	private String brand;
	private String model;
	private String year;
	private int ram;
	private int storage;
	private double retailPrice;
	private int stock;
	
	public Product(int id, String brand, String model, String year, int ram, int storage, double retailPrice, int stock) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.ram = ram;
		this.storage = storage;
		this.retailPrice = retailPrice;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
