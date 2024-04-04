package ru.itmo.funcs.basic.trig;

public class SecFunc {
    private final CosFunc cos;

    public SecFunc(CosFunc cos) {
        this.cos = cos;
    }

    public double calculate(double x, double eps) {
        return 1/cos.calculate(x, eps);
    }
}
