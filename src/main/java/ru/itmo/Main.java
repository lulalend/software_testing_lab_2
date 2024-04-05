package ru.itmo;

import ru.itmo.funcs.basic.logarithmic.LnFunc;
import ru.itmo.funcs.basic.trig.SinFunc;

public class Main {
    public static void main(String[] args) {
        try {
            SinFunc sin = new SinFunc();
            System.out.println(sin.calculate(100000000, 0.00001));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}