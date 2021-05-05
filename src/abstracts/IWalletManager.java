package abstracts;

import entities.Wallet;

public interface IWalletManager extends IService<Wallet> {
	public void updateCredit(int customerId, double credit) throws Exception;
	public Wallet getByCustomerId(int id);
}
