package br.edu.insper.tecprog;

public aspect RegexAspect {

    private boolean regexCalled = false;

    pointcut regexClassCall():
        call(* java.util.regex.*.*(..)) ||
        call(* java.util.regex.Pattern.*(..));

    after() returning : regexClassCall() {
        regexCalled = true;
    }

    after() : execution(* *sumarioRegex(String)) {
        if (!regexCalled) {
            System.err.println("Nenhuma classe relacionada a expressões regulares foi chamada durante a execução do programa.");
            throw new RuntimeException("Nenhuma classe relacionada a expressoes regulares foi chamada durante a execucao do programa.");
        }
    }
}
