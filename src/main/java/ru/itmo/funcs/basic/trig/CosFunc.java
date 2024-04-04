package ru.itmo.funcs.basic.trig;

public class CosFunc {
    private final SinFunc sin;

    public CosFunc (SinFunc sin) {
        this.sin = sin;
    }

    public double calculate(double x, double eps) {
        if (isCosPositive(x)) {
            return Math.sqrt(1 - Math.pow(sin.calculate(x, eps), 2));
        }
        return - Math.sqrt(1 - Math.pow(sin.calculate(x, eps), 2));
    }

    public boolean isCosPositive(double x) {
        // нормализуем угол в диапазон от 0 до 2π
        double normalizedX = x % (2 * Math.PI);
        if (normalizedX < 0) {
            normalizedX += 2 * Math.PI;
        }
    
        // определяем четверть
        if (normalizedX >= 0 && normalizedX <= Math.PI / 2 ||
            normalizedX >= 3 * Math.PI / 2 && normalizedX <= 2 * Math.PI) {
            // 1 и 4 четверти
            return true;
        }
        // 2 и 3 четверти
        return false;
    }
}
