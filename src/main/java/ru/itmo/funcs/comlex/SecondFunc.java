package ru.itmo.funcs.comlex;

import ru.itmo.funcs.basic.logarithmic.LnFunc;
import ru.itmo.funcs.basic.logarithmic.Log3Func;
import ru.itmo.funcs.basic.logarithmic.Log5Func;

public class SecondFunc {
    private final LnFunc ln;
    private final Log3Func log3;
    private final Log5Func log5;

    public SecondFunc(LnFunc ln, Log3Func log3, Log5Func log5) {
        this.ln = ln;
        this.log3 = log3;
        this.log5 = log5;
    }

    public double calculate(double x, double eps) {
        return ln.calculate(x, eps) * ln.calculate(x, eps) * log3.calculate(x, eps)
                / log3.calculate(x, eps) / log5.calculate(x, eps);
    }
}
