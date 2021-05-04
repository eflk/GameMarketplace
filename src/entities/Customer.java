package entities;

import java.util.Date;

import abstracts.IEntity;

public class Customer implements IEntity<Customer> {
	public int id;
	public String firstName;
	public String lastName;
	public Date birthDate;
	public String citizenIdNumber;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 */
	public Customer(int id, String firstName, String lastName, Date birthDate, String citizenIdNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.citizenIdNumber = citizenIdNumber;
	}

	public int getId() {
		return id;
	}

	@Override
	public void Clone(Customer customer) {
		this.id = customer.id;
		this.firstName = customer.firstName;
		this.lastName = customer.lastName;
		this.birthDate = customer.birthDate;
		this.citizenIdNumber = customer.citizenIdNumber;

	}

}
