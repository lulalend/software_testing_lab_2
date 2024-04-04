package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.basic.FactorialFunc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SinFunc {
//    функция вычисляет приближённое значение ряда Тейлора для sin(x) c
//    использованием факториала
    public double calculate(double x, double eps) {
        BigDecimal result = new BigDecimal("0");
        int n = 1;
        BigDecimal prev;

        do {
            prev = result;
            result = result
                    .add(new BigDecimal(-1).pow(n).multiply(new BigDecimal(x).pow(2 * n + 1))
                        .divide(new BigDecimal(FactorialFunc.calculate(2*n - 1)),20, RoundingMode.HALF_UP));
            n++;
        } while (Math.abs(result.subtract(prev).doubleValue()) >= eps);

        return result.doubleValue();
    }
}
