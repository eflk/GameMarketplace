import java.util.Date;

import concrete.CustomerDal;
import concrete.CustomerManager;
import concrete.Helper;
import concrete.WalletDal;
import concrete.WalletManager;
import entities.Customer;
import entities.Wallet;

public class Main {

	public static void main(String[] args) {
		System.out.println(Helper.DateToString(new Date()));
		
		CustomerManager customerManager = new CustomerManager(new CustomerDal());
		
		customerManager.add(new Customer(0, "emre", "felek", Helper.StringToDate("1989-05-07"), "28493335232"));
		customerManager.add(new Customer(1, "ali", "vali", Helper.StringToDate("1985-05-04"), "12345678901"));

		System.out.println(customerManager.getAll().toArray().length);

		Helper.<Customer>dumpEntities(customerManager.getAll());
		
		WalletManager walletManager = new WalletManager(new WalletDal());
		walletManager.addCredit(1, 100);
		walletManager.addCredit(1, 20);
		
		Helper.<Wallet>dumpEntities(walletManager.getAll());

	}

}
