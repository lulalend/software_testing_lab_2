package ru.itmo.funcs.basic;

import java.math.BigInteger;

public class FactorialFunc {
    public static BigInteger calculate(int x) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
