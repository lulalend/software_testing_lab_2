package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;

public class CscFunc implements Func {
    private final SinFunc sin;


    public CscFunc(SinFunc sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double x, double eps) {
        return 1/sin.calculate(x, eps);
    }
}
