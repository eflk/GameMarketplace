package concrete;

import java.util.List;

import abstracts.ICustomerManager;
import abstracts.IOrderDal;
import abstracts.IOrderManager;
import abstracts.IProductManager;
import abstracts.IWalletManager;
import entities.Order;
import entities.Product;

public class OrderManager implements IOrderManager {
	IOrderDal _orderDal;
	IProductManager _productManager;
	ICustomerManager _customerManager;
	IWalletManager _walletManager;

	public OrderManager(IOrderDal orderDal, IProductManager productManager, ICustomerManager customerManager,
			IWalletManager walletManager) {
		_orderDal = orderDal;
		_productManager = productManager;
		_customerManager = customerManager;
		_walletManager = walletManager;
	}

	@Override
	public void add(Order entity) {
		try {
			if (!_productManager.getById(entity.productId).active)
				throw new Exception("Product id " + entity.productId + " not exists.");
			_orderDal.add(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}
	}

	@Override
	public void update(Order entity) {
		try {
			_orderDal.update(entity);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	@Override
	public void delete(Order entity) {
		try {
			_orderDal.delete(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(Helper.PrintStactTraceAllowed()) e.printStackTrace();
		}

	}

	public void purchase(Order order) throws Exception {
		Product product = _productManager.getById(order.productId);
		if (product == null || !product.active)
			throw new Exception("The product is no longer on sale.");
		if (order.totalPrice != order.count * product.price)
			throw new Exception("Product price is not same which in cart.");

		_walletManager.updateCredit(order.customerId, -order.totalPrice);
		order.orderStatus = 2; // ordered
		if(_orderDal.getById(order.id) != null)
			this.update(order);
		else
			this.add(order);
	}

	@Override
	public Order getById(int id) {
		return _orderDal.getById(id);
	}

	@Override
	public List<Order> getAll() {
		return _orderDal.getAll();
	}

	public List<Order> getOrdersByCustomerId(int customerId) {
		return _orderDal.getFiltered(p -> p.customerId == customerId);
	}

	public List<Order> getOrdersByCustomerId(int customerId, int orderStatus) {
		return _orderDal.getFiltered(p -> p.customerId == customerId && p.orderStatus == orderStatus);
	}

}
