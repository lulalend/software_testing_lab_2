package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;

public class CscFunc implements Func {
    private final SinFunc sin;


    public CscFunc(SinFunc sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double x, double eps) {
        if (x % (Math.PI) == 0.0) {
            throw new IllegalArgumentException("csc in k*PI doesn't exist");
        }
        return 1/sin.calculate(x, eps);
    }
}
