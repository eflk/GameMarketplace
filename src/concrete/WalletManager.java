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
		_walletDal.add(wallet);
	}

	public void update(Wallet wallet) {
		try {
			_walletDal.update(wallet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Wallet wallet) {
		try {
			_walletDal.delete(wallet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Wallet> getAll() {
		return _walletDal.getAll();
	}

	public Wallet getById(int id) {
		return _walletDal.getById(id);
	}

	public void addCredit(int customerId, double credit) {
		Wallet wallet = _walletDal.getByCustomerId(customerId);
		if (wallet == null)
			_walletDal.add(new Wallet(0, customerId, credit));
		else {
			wallet.credit += credit;
			try {
				_walletDal.update(wallet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
