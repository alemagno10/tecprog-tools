package br.edu.insper.tecprog;

import org.junit.jupiter.api.Test;

public class TestMathOperations {

    @Test
    void testFactorialRec() {
        MathOperations math = new MathOperations();
        int res = math.factorialRec(5);
        int depth = RecursionDepth.getInstance().getDepth();
        System.out.println(depth);
        assert depth > 4;
        assert res == 120;
    }

    @Test
    void testFactorialIter() {
        MathOperations math = new MathOperations();
        int res = math.factorialIter(5);
        int depth = RecursionDepth.getInstance().getDepth();
        System.out.println(depth);
        assert depth > 4;
        assert res == 120;
    }
}