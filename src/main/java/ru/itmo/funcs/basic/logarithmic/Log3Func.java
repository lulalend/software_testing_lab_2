package ru.itmo.funcs.basic.logarithmic;

public class Log3Func {
    private final LnFunc ln;

    public Log3Func(LnFunc ln) {
        this.ln = ln;
    }

    public double calculate(double x, double eps) {
        double result = 0;
        result += ln.calculate(x, eps)/ln.calculate(3.0, eps);
        return result;
    }

}
