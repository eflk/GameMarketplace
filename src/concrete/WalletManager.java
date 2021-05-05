package concrete;

import java.util.List;
import abstracts.IWalletDal;
import abstracts.IWalletManager;
import entities.Wallet;

public class WalletManager implements IWalletManager {
	IWalletDal _walletDal;

	public WalletManager(IWalletDal walletDal) {
		_walletDal = walletDal;
	}

	public void add(Wallet wallet) {
		try {
			_walletDal.add(wallet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}
	}

	public void update(Wallet wallet) {
		try {
			_walletDal.update(wallet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}
	}

	public void delete(Wallet wallet) {
		try {
			_walletDal.delete(wallet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}
	}

	public List<Wallet> getAll() {
		return _walletDal.getAll();
	}

	public Wallet getById(int id) {
		return _walletDal.getById(id);
	}

	public Wallet getByCustomerId(int id) {
		return _walletDal.getByCustomerId(id);
	}

	public void updateCredit(int customerId, double credit) throws Exception {
		Wallet wallet = _walletDal.getByCustomerId(customerId);
		if (wallet == null)
			_walletDal.add(new Wallet(0, customerId, credit));
		else {
			if ((wallet.balance + credit) < 0)
				throw new Exception("Insufficient credit");
			wallet.balance += credit;
			_walletDal.update(wallet);
		}
	}

}
