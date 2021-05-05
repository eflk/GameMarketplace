package concrete;

import java.util.List;

import abstracts.ICitizenshipValidatorManager;
import abstracts.ICustomerDal;
import abstracts.ICustomerManager;
import entities.Customer;

public class CustomerManager implements ICustomerManager {
	ICustomerDal _customerDal;
	ICitizenshipValidatorManager _citizenshipValidatorManager;
	
	public CustomerManager(ICustomerDal customerDal, ICitizenshipValidatorManager citizenshipValidatorManager) {
		_customerDal = customerDal;
		_citizenshipValidatorManager = citizenshipValidatorManager;
	}

	@Override
	public void add(Customer entity) {
		try {
			if (!_citizenshipValidatorManager.validateCitizenship(entity))
				throw new Exception("The customer not valid. (Invalid citizenship)");
			_customerDal.add(entity);
		} catch (Exception e) {
			System.out.printf("%s: [Id: %d, First Name: \"%s\", Last Name: \"%s\"]", e.getMessage(), entity.id, entity.firstName, entity.lastName);
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	@Override
	public void update(Customer entity) {
		try {
			if (!_citizenshipValidatorManager.validateCitizenship(entity))
				throw new Exception("The customer not valid. (Invalid citizenship)");
			_customerDal.update(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	@Override
	public void delete(Customer entity) {
		try {
			_customerDal.delete(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
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
