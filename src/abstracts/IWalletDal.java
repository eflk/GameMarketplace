package abstracts;

import entities.Wallet;

public interface IWalletDal extends IEntityRepository<Wallet> {
	public Wallet getByCustomerId(int customerId);
}
