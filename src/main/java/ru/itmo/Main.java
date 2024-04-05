package ru.itmo;

import ru.itmo.funcs.Func;
import ru.itmo.funcs.basic.logarithmic.LnFunc;
import ru.itmo.funcs.basic.logarithmic.Log3Func;
import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.SinFunc;
import ru.itmo.funcs.basic.trig.TanFunc;
import ru.itmo.funcs.comlex.FirstFunc;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            SinFunc sin = new SinFunc();
            CosFunc cos = new CosFunc(sin);
            TanFunc tan = new TanFunc(sin, cos);
            System.out.println(tan.calculate(3*Math.PI/2, 0.00001));

//            LnFunc ln = new LnFunc();
//            Log3Func log3 = new Log3Func(ln);
//
//            CsvWriter csvWriter = new CsvWriter();
//
//            Map<String, Func> mapFunctions = new HashMap<>();
//            mapFunctions.put("sin", sin);
//            mapFunctions.put("cos", cos);
//            mapFunctions.put("ln", ln);
//            mapFunctions.put("log3", log3);
//
//            System.out.println("Введите начало, конец промежутка, шаг, точность, имя функции:");
//
//            Scanner scanner = new Scanner(System.in);
//            double a = scanner.nextDouble();
//            double b = scanner.nextDouble();
//            double step = scanner.nextDouble();
//            double eps = scanner.nextDouble();
//            String name = scanner.next();
//
//            csvWriter.print(a, b, step, eps, mapFunctions.get(name), name);
        } catch (IllegalArgumentException
//                 | FileNotFoundException
                 e) {
            System.out.println(e.getMessage());
        }

    }
}