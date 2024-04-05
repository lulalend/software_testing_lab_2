package ru.itmo.funcs.basic.logarithmic;

public class LnFunc {
    protected static final int DEFAULT_MAX_ITERATIONS = 2000;

//    функция вычисляет приближённое значение ряда Тейлора для ln(x)
    public double calculate(double x, double eps) {
        if (x <= 0) {
            throw new IllegalArgumentException("x can't be negative :(");
        }
        if (eps > 0.5 || eps <= 0) {
            throw new IllegalArgumentException("eps must be in range (0; 0.5]");
        }

        double k = ((x - 1) * (x - 1))/((x + 1) * (x + 1));
        double result = 0;
        double currentValue = (x - 1)/(x + 1);
        int step = 1;

        while(Math.abs(currentValue) > eps/1000 && step <= DEFAULT_MAX_ITERATIONS) {
            result += currentValue;
            currentValue = currentValue * k * (2*step - 1) / (2*step + 1);
            step++;
        }

        if (step == DEFAULT_MAX_ITERATIONS) {
            throw new IllegalArgumentException("too much iterations. :( Choose a smaller x value..");
        }

        result *= 2;
        return result;
    }
}
