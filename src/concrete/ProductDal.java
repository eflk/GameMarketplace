package concrete;

import abstracts.IProductDal;
import entities.Product;
import inMemoryDB.DbContext;

public class ProductDal extends EntityReposiyoryBase<Product> implements IProductDal {

	public ProductDal() {
		super(DbContext.products);
	}

}