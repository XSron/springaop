package springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {
	public void addAccount() {
		System.out.println(getClass().getName() + " AddAccount() method is called!");
	}
}
