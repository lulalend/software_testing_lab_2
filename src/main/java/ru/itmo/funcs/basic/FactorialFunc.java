package ru.itmo.funcs.basic;

public class FactorialFunc {
    public static int calculate(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
