package br.edu.insper.tecprog;

public aspect RegexAspect {

    private boolean regexCalled = false;

    pointcut regexClassCall():
        call(* java.util.regex.Matcher.*(..)) ||
        call(* java.util.regex.Pattern.*(..));

    after() returning : regexClassCall() {
        regexCalled = true;
    }

    pointcut methods():
        execution(* StringUtils.sumario(String)) ||
        execution(* StringUtils.sumarioRegex(String));

    after() : methods() {
        if (!regexCalled) {
            System.err.println("Nenhuma classe relacionada a expressões regulares foi chamada durante a execução desse metodo.");
            throw new RuntimeException("Nenhuma classe relacionada a expressoes regulares foi chamada durante a execucao desse metodo.");
        }
        regexCalled = false;
    }
}
