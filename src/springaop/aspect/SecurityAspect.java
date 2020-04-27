package springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {
	@Before("springaop.aspect.PointCutExpression.combinePointcut()")
	public void security() {
		System.out.println(getClass() + " security aspect is being called!");
	}
}
