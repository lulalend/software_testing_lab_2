package ru.itmo;

import ru.itmo.funcs.Func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CsvWriter {
    private String filePath;

    private void setFilePath(String fileName) {
        this.filePath = fileName;
    }

    public void print(double a, double b, double step, double eps, Func function, String fileName) throws FileNotFoundException {
        setFilePath("logs/" + fileName + ".csv");
        for (double i = a; i <= b; i += step) {
            double res = function.calculate(i, eps);
            try (PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
                printStream.printf("%s, %s \n", i, res);
            }
        }
    }
}
