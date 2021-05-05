package entities;

import abstracts.IEntity;

public class Wallet implements IEntity<Wallet> {
	public int id;
	public int customerId;
	public double balance;

	/**
	 * @param id
	 * @param customerId
	 * @param credit
	 */
	public Wallet(int id, int customerId, double credit) {
		this.id = id;
		this.customerId = customerId;
		this.balance = credit;
	}

	public int getId() {
		return id;
	}

	@Override
	public void Clone(Wallet wallet) {
		this.id = wallet.id;
		this.customerId = wallet.customerId;
		this.balance = wallet.balance;

	}
}
