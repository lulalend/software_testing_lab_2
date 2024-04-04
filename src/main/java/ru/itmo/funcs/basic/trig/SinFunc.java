package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.basic.FactorialFunc;

public class SinFunc {
//    функция вычисляет приближённое значение ряда Тейлора для sin(x) c
//    использованием факториала
    public double calculate(double x, double eps) {
//        может double надо заменить на BigDecimal, если точность плохая будет
//        либо можно округлять до скольких-то знаков, либо всё)

        double result = 0;
        int n = 0;
        double prev;

        do {
            prev = result;
            result += (Math.pow(-1.0, n) * Math.pow(x, 2*n + 1)/ FactorialFunc.calculate(2*n + 1));
            n++;
        } while (eps / 10 <= Math.abs(result - prev));

        return result;
    }
}
