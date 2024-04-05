package ru.itmo.funcs.basic.logarithmic;

import ru.itmo.funcs.Func;

public class Log5Func implements Func {
    private final LnFunc ln;

    public Log5Func(LnFunc ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double eps) {
        double result = 0;
        result += ln.calculate(x, eps)/ln.calculate(5.0, eps);
        return result;
    }
}
