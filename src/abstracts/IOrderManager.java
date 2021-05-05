package abstracts;

import entities.Order;

public interface IOrderManager extends IService<Order> {
	public void purchase(Order order) throws Exception;
}
