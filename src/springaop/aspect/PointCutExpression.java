package springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExpression {
	@Pointcut("execution(* *(..))")
	private void declarePointcut() {}
	@Pointcut("execution(* get*(..))")
	private void declareGetter() {}
	@Pointcut("execution(* set*(..))")
	private void declareSetter() {}
	
	@Pointcut("declarePointcut() && !(declareGetter() || declareSetter())")
	public void combinePointcut() {}
}
