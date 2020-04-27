package springaop.dao;

import org.springframework.stereotype.Component;

import springaop.model.Customer;

@Component
public class AccountDAO {
	public int addAccount(Customer cus, CustomerDAO cusDao) {
		System.out.println(getClass().getName() + " AddAccount() method is called!");
		return 0;
	}
	public void addCustomer() {
		System.out.println("Add Customer ASPECT");
	}
}
