package concrete;

import java.util.List;

import abstracts.IProductDal;
import abstracts.IProductManager;
import entities.Product;

public class ProductManager implements IProductManager {
	IProductDal _productDal;

	public ProductManager(IProductDal productDal) {
		_productDal = productDal;

	}

	@Override
	public void add(Product entity) {
		try {
			_productDal.add(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	@Override
	public void update(Product entity) {
		try {
			_productDal.update(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	@Override
	public void delete(Product entity) {
		try {
			_productDal.delete(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	@Override
	public Product getById(int id) {
		return _productDal.getById(id);
	}

	@Override
	public List<Product> getAll() {
		return _productDal.getAll();
	}

	public List<Product> getProductsByCategoryId(int categoryId) {
		return _productDal.getFiltered(p -> p.categoryId == categoryId);
	}

}
