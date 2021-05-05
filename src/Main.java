import concrete.CustomerDal;
import concrete.CustomerManager;
import concrete.Helper;
import concrete.ProductDal;
import concrete.ProductManager;
import concrete.WalletDal;
import concrete.WalletManager;
import entities.Customer;
import entities.Product;
import entities.Wallet;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager = new CustomerManager(new CustomerDal());
		
		customerManager.add(new Customer(1, "emre", "felek", Helper.StringToDate("1989-05-07"), "28493335232"));
		customerManager.add(new Customer(2, "ali", "vali", Helper.StringToDate("1985-05-04"), "12345678901"));
		System.out.println("\n==| CUSTOMERS |=============================================");
		Helper.<Customer>dumpEntities(customerManager.getAll());
		
		WalletManager walletManager = new WalletManager(new WalletDal());
		walletManager.addCredit(1, 100);
		walletManager.addCredit(1, 20);
		System.out.println("\n==| WALLETS |===============================================");
		Helper.<Wallet>dumpEntities(walletManager.getAll());
		
		ProductManager productManager = new ProductManager(new ProductDal());
		productManager.add(new Product(1, "Half-Life", 1, 100, "SGFsZi1MaWZlSGFsZi1MaWZlSGFsZi1MaWZlSGFsZi1MaWZl", true));
		productManager.add(new Product(2, "Age Of Empires", 2, 70, "QWdlT2ZFbXBpcmVzQWdlT2ZFbXBpcmVzQWdlT2ZFbXBpcmVz", true));
		System.out.println("\n==| PRODUCTS |===============================================");
		Helper.<Product>dumpEntities(productManager.getAll());
		
		

	}

}
