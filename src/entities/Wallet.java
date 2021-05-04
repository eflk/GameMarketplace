package entities;

import abstracts.IEntity;

public class Wallet implements IEntity<Wallet> {
	public int id;
	public int customerId;
	public double credit;

	/**
	 * @param id
	 * @param customerId
	 * @param credit
	 */
	public Wallet(int id, int customerId, double credit) {
		this.id = id;
		this.customerId = customerId;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	@Override
	public void Clone(Wallet wallet) {
		this.id = wallet.id;
		this.customerId = wallet.customerId;
		this.credit = wallet.credit;

	}
}
