package ru.itmo.funcs.comlex;

import ru.itmo.funcs.basic.trig.*;

public class FirstFunc {
    private final CscFunc csc;
    private final CosFunc cos;
    private final TanFunc tan;
    private final CotFunc cot;
    private final SecFunc sec;

    public FirstFunc(CscFunc csc, CosFunc cos, TanFunc tan, CotFunc cot, SecFunc sec) {
        this.csc = csc;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.sec = sec;
    }

    public double calculate(double x, double eps) {
        return (csc.calculate(x, eps) * csc.calculate(x, eps)
                - cot.calculate(x, eps) / tan.calculate(x, eps))
                * cos.calculate(x, eps) * cos.calculate(x, eps) * cos.calculate(x, eps)
                * sec.calculate(x, eps) / tan.calculate(x, eps);
    }
}
