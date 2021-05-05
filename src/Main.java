import adapters.MernisServiceAdapter;
import concrete.CustomerDal;
import concrete.CustomerManager;
import concrete.Helper;
import concrete.OrderDal;
import concrete.OrderManager;
import concrete.ProductDal;
import concrete.ProductManager;
import concrete.WalletDal;
import concrete.WalletManager;
import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Wallet;

public class Main {

	public static void main(String[] args) {

		// Creating customer
		CustomerManager customerManager = new CustomerManager(new CustomerDal(), new MernisServiceAdapter());
		customerManager.add(new Customer(1, "Emre", "FELEK", Helper.StringToDate(1989 + "-05-07"), "28493335232"));
		customerManager.add(new Customer(2, "ali", "veli", Helper.StringToDate("1985-05-04"), "12345678901"));
		System.out.println("\n==| CUSTOMERS |=============================================");
		Helper.<Customer>dumpEntities(customerManager.getAll());

		// Creating products
		ProductManager productManager = new ProductManager(new ProductDal());
		productManager.add(new Product(1, "Half-Life", 1, 100, "SGFsZi1MaWZlSGFsZi1MaWZlSGFsZi1MaWZlSGFsZi1MaWZl", true));
		productManager.add(new Product(2, "Age Of Empires", 2, 70, "QWdlT2ZFbXBpcmVzQWdlT2ZFbXBpcmVzQWdlT2ZFbXBpcmVz", true));
		System.out.println("\n==| PRODUCTS |===============================================");
		Helper.<Product>dumpEntities(productManager.getAll());

		// Adding credit to wallet for customer "1"
		WalletManager walletManager = new WalletManager(new WalletDal());
		try {
			walletManager.updateCredit(1, 300);
			walletManager.updateCredit(1, 20);
		} catch (Exception e) {
			System.out.println("\n!!! Update Credit Error: " + e.getMessage());
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}

		// Showing all customers wallet
		System.out.println("\n==| WALLETS |===============================================");
		Helper.<Wallet>dumpEntities(walletManager.getAll());

		// The customer "1" purchasing two pieces of product "Half-Life"
		OrderManager orderManager = new OrderManager(new OrderDal(), productManager, customerManager, walletManager);
		try {
			orderManager.purchase(
					new Order(1, 1, 1, 2, 1, productManager.getById(1).price * 2, Helper.getStringSystemDateUTC()));
		} catch (Exception e) {
			System.out.println("\n!!! Order Error: " + e.getMessage());
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}

		// Showing all customers orders
		System.out.println("\n==| ORDERS |===============================================");
		Helper.<Order>dumpEntities(orderManager.getAll());

		// Showing all customers wallet
		System.out.println("\n==| WALLETS |===============================================");
		Helper.<Wallet>dumpEntities(walletManager.getAll());
	}

}
