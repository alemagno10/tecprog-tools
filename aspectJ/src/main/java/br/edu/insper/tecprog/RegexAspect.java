package br.edu.insper.tecprog;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RegexAspect {

    private ThreadLocal<Boolean> regexCalled = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    @Pointcut("call(* java.util.regex.Matcher.*(..)) || call(* java.util.regex.Pattern.*(..))")
    public void regexClassCall() {}

    @AfterReturning("regexClassCall()")
    public void afterRegexClassCall() {
        regexCalled.set(true);
    }

    @Pointcut("execution(* StringUtils.sumario(String)) || execution(* StringUtils.sumarioRegex(String))")
    public void methods() {}

    @After("methods()")
    public void afterMethods() {
        if (!regexCalled.get()) {
            System.err.println("Nenhuma classe relacionada a expressões regulares foi chamada durante a execução desse método.");
            throw new RuntimeException("Nenhuma classe relacionada a expressoes regulares foi chamada durante a execucao desse metodo.");
        }
        regexCalled.set(false);
    }
}
