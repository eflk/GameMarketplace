package concrete;

import abstracts.ICustomerDal;
import entities.Customer;
import inMemoryDB.DbContext;

public class CustomerDal extends EntityReposiyoryBase<Customer> implements ICustomerDal {

	public CustomerDal() {
		super(DbContext.customers);
	}

}
