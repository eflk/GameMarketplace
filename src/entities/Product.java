package entities;

import abstracts.IEntity;

public class Product implements IEntity<Product> {
	public int id;
	/**
	 * @param id
	 * @param name
	 * @param categoryId
	 * @param price
	 * @param licenceKey
	 * @param active
	 */
	public Product(int id, String name, int categoryId, double price, String licenceKey, boolean active) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.licenceKey = licenceKey;
		this.active = active;
	}

	public String name;
	public int categoryId;
	public double price;
	public String licenceKey;
	public boolean active;
	
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void Clone(Product product) {
		this.id = product.id;
		this.name = product.name;
		this.categoryId = product.categoryId;
		this.price = product.price;
		this.licenceKey = product.licenceKey;
		this.active = product.active;
		
	}

}
