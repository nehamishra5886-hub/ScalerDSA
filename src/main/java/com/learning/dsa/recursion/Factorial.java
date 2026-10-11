package com.learning.dsa.recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 12;
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    private static int factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
