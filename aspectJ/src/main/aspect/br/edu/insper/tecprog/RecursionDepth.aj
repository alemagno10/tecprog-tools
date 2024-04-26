package br.edu.insper.tecprog;

public aspect RecursionDepth {

    private int depth = 0;

    pointcut Methods():
        execution(* MathOperations.factorialRec(..)) || 
        execution(* MathOperations.factorialIter(..));

    before(): Methods(){
        depth++;
    }

    public int getDepth() {
        System.out.println("depth: "+depth);
        return depth;
    }
}