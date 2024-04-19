package br.edu.insper.tecprog;

public aspect BlockMethodsAspect {

    pointcut ArrayListMethods():
        call(* java.util.ArrayList.*(..));

    pointcut AllowedMethods():
        call(* java.util.ArrayList.get(..)) ||
        call(* java.util.ArrayList.set(..)) ||
        call(* java.util.ArrayList.size(..));

    pointcut methods():
        execution(* StringUtils.prefixoAllowed(String)) ||
        execution(* StringUtils.prefixoBlocked(String));

    before(): ArrayListMethods() && !AllowedMethods() {
        String methodName = thisJoinPoint.getSignature().getName();
        String className = thisJoinPoint.getSignature().getDeclaringTypeName();
        throw new RuntimeException("Acesso ao "+className+"."+methodName+"() nao e permitido.");
    }

}