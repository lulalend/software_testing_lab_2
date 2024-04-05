package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;
import ru.itmo.funcs.basic.FactorialFunc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SinFunc implements Func {
    protected static final int DEFAULT_MAX_ITERATIONS = 2000;

//    функция вычисляет приближённое значение ряда Тейлора для sin(x) c
//    использованием факториала
    @Override
    public double calculate(double x, double eps)  {
        if (eps > 0.5 || eps <= 0) {
            throw new IllegalArgumentException("eps must be in range (0; 0.5]");
        }

        BigDecimal result = new BigDecimal("0");
        int n = 0;
        BigDecimal prev;

        do {
            prev = result;
            result = result
                    .add(new BigDecimal(-1).pow(n).multiply(new BigDecimal(x).pow(2 * n + 1))
                        .divide(new BigDecimal(FactorialFunc.calculate(2*n + 1)),20, RoundingMode.HALF_UP));
            n++;
        } while (Math.abs(result.subtract(prev).doubleValue()) >= eps && n < DEFAULT_MAX_ITERATIONS);

        if (n == DEFAULT_MAX_ITERATIONS) {
            throw new IllegalArgumentException("too much iterations. :( Choose a smaller x value..");
        }

        return result.doubleValue();
    }
}
