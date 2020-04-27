import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springaop.config.AppConfig;
import springaop.dao.AccountDAO;
import springaop.dao.CustomerDAO;
import springaop.model.Customer;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		dao.addAccount(new Customer(), new CustomerDAO());
		dao.addCustomer();
		
		CustomerDAO cusDao = context.getBean(CustomerDAO.class);
		cusDao.addAccount();
		
		Customer customer = context.getBean(Customer.class);
		customer.addCustomer();
		customer.getName();
		customer.setName("Hi");
		
		try {
			List<Customer> customers = customer.getCustomer(true);
			for(Customer cus: customers)
				System.out.println("MAIN METHOD " + cus.getName());
		}catch(Exception ex) {
			System.out.println("INSIDE the CALLER " + ex);
		}
		
		context.close();
	}
}
