package ru.itmo;

import ru.itmo.funcs.basic.FactorialFunc;
import ru.itmo.funcs.basic.trig.SinFunc;

public class Main {
    public static void main(String[] args) {
        SinFunc sin = new SinFunc();
//        System.out.println(FactorialFunc.calculate(20));
        System.out.println(sin.calculate(Math.PI, 0.1));
    }
}