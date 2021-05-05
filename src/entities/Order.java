package entities;

import abstracts.IEntity;

//We don't need to create order details. That's enough for simulation.
public class Order implements IEntity<Order> {
	public int id;
	public int productId;
	public int customerId;
	public int count;
	public int orderStatus; //0 - In Cart, 1 - Ordered
	public double totalPrice;
	public String lastActionTime;
	
	/**
	 * @param id
	 * @param productId
	 * @param count
	 * @param orderStatus
	 * @param totalPrice
	 * @param lastActionTime
	 */
	public Order(int id, int productId, int customerId, int count, int orderStatus, double totalPrice, String lastActionTime) {
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.count = count;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.lastActionTime = lastActionTime;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void Clone(Order order) {
		this.id = order.id;
		this.productId = order.productId;
		this.customerId = order.customerId;
		this.count = order.count;
		this.orderStatus = order.orderStatus;
		this.totalPrice = order.totalPrice;
		this.lastActionTime = order.lastActionTime;
		
	}

}
