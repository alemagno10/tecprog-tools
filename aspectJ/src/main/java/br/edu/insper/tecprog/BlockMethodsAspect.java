package br.edu.insper.tecprog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BlockMethodsAspect {
    @Pointcut("call(* java.util.ArrayList.*(..))")
    public void ArrayListMethods(){}

    @Pointcut("call(* java.util.ArrayList.get(..)) || call(* java.util.ArrayList.set(..)) || call(* java.util.ArrayList.size(..))")
    public void AllowedMethods(){}

    @Pointcut("""
        execution(* StringUtils.prefixoAllowed(String)) ||
        execution(* StringUtils.prefixoBlocked(String))
    """)
    public void methods(){} 

    @Before("ArrayListMethods() && !AllowedMethods()")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getName();
        throw new RuntimeException("Acesso ao " + className + "." + methodName + "() não é permitido.");
    }
}
