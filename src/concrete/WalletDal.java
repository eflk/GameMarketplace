package concrete;

import abstracts.IWalletDal;
import entities.Wallet;
import inMemoryDB.DbContext;

public class WalletDal extends EntityReposiyoryBase<Wallet> implements IWalletDal {
	
	public WalletDal() {
		super(DbContext.wallets);
	}

	public Wallet getByCustomerId(int customerId) {
		return super.get(p->p.customerId == customerId);
	}

	

}
