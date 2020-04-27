package springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springaop.model.Customer;

import java.util.List;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
	@Before("springaop.aspect.PointCutExpression.combinePointcut()")
	public void logging(JoinPoint joinPoint) {
		System.out.println("Kind " + joinPoint.getKind());
		System.out.println("Target" + joinPoint.getTarget());
		System.out.println("Method Signuature" + joinPoint.getSignature());
		Object[] args = joinPoint.getArgs();
		for(Object obj: args)
			System.out.println("Argument " + obj);
		System.out.println(getClass() + " logging aspect is being called!");
	}
	
	@AfterReturning(pointcut = "execution(java.util.List<springaop.model.Customer> getCustomer(..))", returning = "customers")
	public void logCustomer(List<Customer> customers) {
		for(int i=0; i<customers.size(); i++) {
			Customer cus = customers.get(i);
			System.out.println("ASPECT " + cus.getName());
			cus.setName(cus.getName() + " index:" + i);
		}
	}
	
	@AfterThrowing(pointcut = "execution(java.util.List<springaop.model.Customer> getCustomer(..))", throwing = "exception")
	public void logExeception(Throwable exception) {
		System.out.println(getClass() + "- @@AfterThrowing " + exception.getMessage());
	}
	
	@After("execution(java.util.List<springaop.model.Customer> getCustomer(..))")
	public void logAfter() {
		System.out.println(getClass() + "-" + " @AfterAdvice");
	}
	
	@Around("execution(java.util.List<springaop.model.Customer> getCustomer(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before Around ProceedingJoinPoint");
		Object obj = joinPoint.proceed(); //if the method has return
		System.out.println(obj.toString()); //result
		System.out.println("After Around ProceedingJoinPoint");
		return obj;
	}
	
}
