package springaop.model;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Customer {
	private String name;
	public Customer() {}
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCustomer() {
		System.out.println(getClass() + "add Customer is called");
	}
	
	public List<Customer> getCustomer(boolean isError) throws Exception {
		if(isError)
			throw new Exception("Testing @AfterThrowing Advice");
		System.out.println("Before Return Customer List");
		return Arrays.asList(new Customer("A"), new Customer("B"));
	}
}
