package br.edu.insper.tecprog;

public class MathOperations {
    
    public int factorialRec(int n){
        return n == 0 ? 1 : n * factorialRec(n - 1);
    }

    public int factorialIter(int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

}
