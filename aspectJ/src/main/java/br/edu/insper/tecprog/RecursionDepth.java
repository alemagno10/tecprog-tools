package br.edu.insper.tecprog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RecursionDepth {

    private static RecursionDepth instance = new RecursionDepth();
    private int depth = 0;

    @Pointcut("execution(* MathOperations.factorialRec(..)) || execution(* MathOperations.factorialIter(..))")
    public void methodCall(){}

    @Before("methodCall()")
    public void incrementDepth() {
        depth++;
        System.out.println("Depth incremented: " + depth);
    }

    public static RecursionDepth getInstance() {
        return instance;
    }

    public int getDepth() {
        System.out.println("dd "+depth);
        return depth;
    }

    public void resetDepth() {
        depth = 0;
    }
}