package ru.itmo.funcs.basic.trig;

public class TanFunc {
    private final SinFunc sin;
    private final CosFunc cos;

    public TanFunc(SinFunc sin, CosFunc cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x, double eps) {
        return sin.calculate(x, eps)/cos.calculate(x, eps);
    }
}
