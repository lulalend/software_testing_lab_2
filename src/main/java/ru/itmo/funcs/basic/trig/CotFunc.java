package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;

public class CotFunc implements Func {
    private final SinFunc sin;
    private final CosFunc cos;

    public CotFunc (SinFunc sin, CosFunc cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        return cos.calculate(x, eps)/sin.calculate(x, eps);
    }

}
