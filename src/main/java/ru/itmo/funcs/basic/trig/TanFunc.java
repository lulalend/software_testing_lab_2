package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;

public class TanFunc implements Func {
    private final SinFunc sin;
    private final CosFunc cos;

    public TanFunc(SinFunc sin, CosFunc cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        if (x % (Math.PI/2) == 0.0 && x % (Math.PI) != 0.0) {
            throw new IllegalArgumentException("tan in k*PI/2 doesn't exist");
        }
        return sin.calculate(x, eps)/cos.calculate(x, eps);
    }
}
