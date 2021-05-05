package inMemoryDB;

import java.util.ArrayList;
import java.util.List;

import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Wallet;

public abstract class DbContext {
	public final static List<Wallet> wallets = new ArrayList<Wallet>();
	public final static List<Customer> customers = new ArrayList<Customer>();
	public final static List<Product> products = new ArrayList<Product>();
	public final static List<Order> orders = new ArrayList<Order>();

}
