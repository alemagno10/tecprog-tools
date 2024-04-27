package br.edu.insper.tecprog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect("perthis(methodCall())")
public class RecursionDepth {

    private static int depth = 0;

    @Pointcut("execution(* MathOperations.factorialRec(..)) || execution(* MathOperations.factorialIter(..))")
    public void methodCall(){}

    @Before("methodCall()")
    public void incrementDepth() {
        depth++;
        System.out.println("Depth incremented: " + depth);
    }

    public static int getDepth() {
        System.out.println("depth: "+depth);
        return depth;
    }

    public static void resetDepth() {
        depth = 0;
    }
}