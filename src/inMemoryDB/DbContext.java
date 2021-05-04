package inMemoryDB;

import java.util.ArrayList;
import java.util.List;

import entities.Customer;
import entities.Wallet;

public abstract class DbContext {
	public final static List<Wallet> wallets = new ArrayList<Wallet>();;
	public final static List<Customer> customers = new ArrayList<Customer>();;

}
