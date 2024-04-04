package ru.itmo.funcs.basic.logarithmic;

public class Log5Func {
    private final LnFunc ln;

    public Log5Func(LnFunc ln) {
        this.ln = ln;
    }

    public double calculate(double x, double eps) {
        double result = 0;
        result += ln.calculate(x, eps)/ln.calculate(5.0, eps);
        return result;
    }
}
