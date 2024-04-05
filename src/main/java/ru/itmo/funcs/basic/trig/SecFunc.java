package ru.itmo.funcs.basic.trig;

import ru.itmo.funcs.Func;

public class SecFunc implements Func {
    private final CosFunc cos;

    public SecFunc(CosFunc cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        return 1/cos.calculate(x, eps);
    }
}
