package ru.itmo.func.complex;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.logarithmic.LnFunc;
import ru.itmo.funcs.basic.logarithmic.Log3Func;
import ru.itmo.funcs.basic.logarithmic.Log5Func;
import ru.itmo.funcs.comlex.SecondFunc;

public class SecondFuncTest extends BasicTest {
    private LnFunc lnFunc;
    private Log3Func log3Func;
    private Log5Func log5Func;

    private SecondFunc secondFunc;

    @BeforeEach
    public void setUp() {
        lnFunc = new LnFunc();
        log3Func = new Log3Func(lnFunc);
        log5Func = new Log5Func(lnFunc);
        secondFunc = new SecondFunc(lnFunc, log3Func, log5Func);
    }

    @ParameterizedTest
    @MethodSource("randomValues")
    public void testRandomValues(double x, double expected) {
        assertEquals(expected, secondFunc.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("nearZeroValues")
    public void testNearZeroValues(double x, double expected) {
        assertEquals(expected, secondFunc.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("illegalValues")
    public void testIllegalValues(double x) {
        assertThrows(IllegalArgumentException.class, () -> secondFunc.calculate(x, PRECISION));
    }

    // смысл теста в делении на ноль, так как логарифм от 1 - это 0
    @Test 
    public void testNanValue() {
        assertEquals(Double.NaN, secondFunc.calculate(1, PRECISION), PRECISION);
    }

    private static Stream<Arguments> randomValues() {
        return Stream.of(
            Arguments.of(11, 7.71853),
            Arguments.of(3, 3.5363),
            Arguments.of(5, 5.18058),
            Arguments.of(0.01, -14.32356),
            Arguments.of(200, 15.086825)
        );
    }

    private static Stream<Arguments> nearZeroValues() {
        return Stream.of(
            Arguments.of(0.5, -2.23115),
            Arguments.of(0.15, -6.10659),
            Arguments.of(0.015, -13.41415)
        );
    }

    private static Stream<Arguments> illegalValues() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(-2000),
            Arguments.of(-0.00001),
            Arguments.of(-0.56),
            Arguments.of(-10)
        );
    }

}
