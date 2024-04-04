package ru.itmo.funcs.basic.logarithmic;

public class LnFunc {
//    функция вычисляет приближённое значение ряда Тейлора для sin(x) c
//    использованием факториала
    public double calculate(double x, double eps) {
        if (x <= 0) {
            throw new IllegalArgumentException("x must be non-negative :(");
        }

        double k = ((x - 1) * (x - 1))/((x + 1) * (x + 1));
        double result = 0;
        double currentValue = (x - 1)/(x + 1);
        int step = 1;

        while(Math.abs(currentValue) > eps/1000) {
            result += currentValue;
            currentValue = currentValue * k * (2*step - 1) / (2*step + 1);
            step++;
        }

        result *= 2;
        return result;
    }
}
