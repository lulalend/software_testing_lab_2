package ru.itmo.funcs.basic.trig;

public class CosFunc {
    private final SinFunc sin;

    public CosFunc (SinFunc sin) {
        this.sin = sin;
    }

    public double calculate(double x, double eps) {
        return 1/ sin.calculate(x, eps);
    }
}
