package br.edu.insper.tecprog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RecursionDepthAspect {

    private static ThreadLocal<Integer> depth = ThreadLocal.withInitial(() -> 0);

    @Pointcut("execution(* MathOperations.factorialRec(..)) || execution(* MathOperations.factorialIter(..))")
    public void methodCall(){}

    @Before("methodCall()")
    public void incrementDepth() {
        depth.set(depth.get() + 1);
        System.out.println("Depth incremented: " + depth);
    }

    public static int getDepth() {
        int local = depth.get();
        System.out.println("depth: "+depth);
        resetDepth();
        return local;
    }

    public static void resetDepth() {
        depth.set(0);
    }
}