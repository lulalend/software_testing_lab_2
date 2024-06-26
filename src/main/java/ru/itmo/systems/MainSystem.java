package ru.itmo.systems;

import ru.itmo.funcs.Func;
import ru.itmo.funcs.comlex.FirstFunc;
import ru.itmo.funcs.comlex.SecondFunc;

public class MainSystem implements Func {
    private final FirstFunc firstFunc;
    private final SecondFunc secondFunc;

    public MainSystem(FirstFunc firstFunc, SecondFunc secondFunc) {
        this.firstFunc = firstFunc;
        this.secondFunc = secondFunc;
    }

    @Override
    public double calculate(double x, double eps) {
        if (x <= 0) {
            return firstFunc.calculate(x, eps);
        } else {
            return secondFunc.calculate(x, eps);
        }
    }
}
