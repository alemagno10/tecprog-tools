package br.edu.insper.tecprog;

import org.junit.jupiter.api.Test;

public class TestMathOperations {

    @Test
    void testFactorialRec() {
        MathOperations math = new MathOperations();
        RecursionDepth.resetDepth();
        int res = math.factorialRec(5);
        int depth = RecursionDepth.getDepth();
        assert depth > 4;
        assert res == 120;
    }

    @Test
    void testFactorialIter() {
        MathOperations math = new MathOperations();
        RecursionDepth.resetDepth();
        int res = math.factorialIter(5);
        int depth = RecursionDepth.getDepth();
        assert depth > 4;
        assert res == 120;
    }
}