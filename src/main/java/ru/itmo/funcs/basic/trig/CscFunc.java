package ru.itmo.funcs.basic.trig;

public class CscFunc {
    private final SinFunc sin;


    public CscFunc(SinFunc sin) {
        this.sin = sin;
    }

    public double calculate(double x, double eps) {
        return 1/sin.calculate(x, eps);
    }
}
