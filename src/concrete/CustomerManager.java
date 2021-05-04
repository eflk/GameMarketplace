package concrete;

import java.util.List;

import abstracts.ICustomerDal;
import abstracts.ICustomerManager;
import entities.Customer;

public class CustomerManager implements ICustomerManager {
	ICustomerDal _customerDal;

	public CustomerManager(ICustomerDal customerDal) {
		_customerDal = customerDal;

	}

	@Override
	public void add(Customer entity) {
		_customerDal.add(entity);

	}

	@Override
	public void update(Customer entity) {
		try {
			_customerDal.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Customer entity) {
		try {
			_customerDal.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Customer getById(int id) {
		return _customerDal.getById(id);
	}

	@Override
	public List<Customer> getAll() {
		return _customerDal.getAll();
	}

}
