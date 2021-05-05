package concrete;

import abstracts.IOrderDal;
import entities.Order;
import inMemoryDB.DbContext;

public class OrderDal extends EntityReposiyoryBase<Order> implements IOrderDal {

	public OrderDal() {
		super(DbContext.orders);
	}

}
