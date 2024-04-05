package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;

public class SecFunc implements Func {
    private final CosFunc cos;

    public SecFunc(CosFunc cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        if (x % (Math.PI/2) == 0.0) {
            throw new IllegalArgumentException("sec in k*PI/2 doesn't exist");
        }
        return 1/cos.calculate(x, eps);
    }
}
