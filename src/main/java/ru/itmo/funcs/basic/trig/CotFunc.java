package ru.itmo.funcs.basic.trig;

public class CotFunc {
    private final SinFunc sin;
    private final CosFunc cos;

    public CotFunc (SinFunc sin, CosFunc cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x, double eps) {
        return cos.calculate(x, eps)/sin.calculate(x, eps);
    }

}
