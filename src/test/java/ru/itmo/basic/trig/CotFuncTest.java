package ru.itmo.basic.trig;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.CotFunc;
import ru.itmo.funcs.basic.trig.SinFunc;

public class CotFuncTest extends BasicTest{
    private SinFunc sin;
    private CosFunc cos;
    private CotFunc cot;

    @BeforeEach
    public void setUp() {
        sin = new SinFunc();
        cos = new CosFunc(sin);
        cot = new CotFunc(sin, cos);
    }

    @ParameterizedTest
    @MethodSource("illegalValues")
    public void testIllegalValues(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cot.calculate(x, PRECISION));
    }

    @ParameterizedTest
    @MethodSource("zeroValues")
    public void testZeroValues(double x) {
        Assertions.assertEquals(0, cot.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("oneValues")
    public void testOneValues(double x) {
        Assertions.assertEquals(1, cot.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("minusOneValues")
    public void testMinusOneValues(double x) {
        Assertions.assertEquals(-1, cot.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("biggerThanOnePositiveValues")
    public void testBiggerThanOnePositiveValues(double x) {
        Assertions.assertEquals(1 / Math.tan(Math.PI / 3), cot.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("biggerThanOneNegativeValues")
    public void testBiggerThanOneNegativeValues(double x) {
        Assertions.assertEquals(- 1 / Math.tan(Math.PI / 3), cot.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> illegalValues() {
        return Stream.of(
            Arguments.of(Math.PI),
            Arguments.of(- Math.PI),
            Arguments.of(2 * Math.PI),
            Arguments.of(0));
    }

    private static Stream<Arguments> zeroValues() {
        return Stream.of(
            Arguments.of(Math.PI / 2),
            Arguments.of(- Math.PI / 2),
            Arguments.of(- 3 * Math.PI / 2),
            Arguments.of(3 * Math.PI / 2));
    }

    private static Stream<Arguments> oneValues() {
        return Stream.of(
            Arguments.of(- 11 * Math.PI / 4),
            Arguments.of(- 3 * Math.PI / 4),
            Arguments.of(Math.PI / 4),
            Arguments.of(9 * Math.PI / 4));
    }

    private static Stream<Arguments> minusOneValues() {
        return Stream.of(
            Arguments.of(- 9 * Math.PI / 4),
            Arguments.of(- Math.PI / 4),
            Arguments.of(3 * Math.PI / 4),
            Arguments.of(11 * Math.PI / 4));
    }

    private static Stream<Arguments> biggerThanOnePositiveValues() {
        return Stream.of(
            Arguments.of(- 5 * Math.PI / 3),
            Arguments.of(- 2 * Math.PI / 3),
            Arguments.of(Math.PI / 3),
            Arguments.of(4 * Math.PI / 3),
            Arguments.of(7 * Math.PI / 3));
    }

    private static Stream<Arguments> biggerThanOneNegativeValues() {
        return Stream.of(
            Arguments.of(5 * Math.PI / 3),
            Arguments.of(2 * Math.PI / 3),
            Arguments.of(- Math.PI / 3),
            Arguments.of(- 4 * Math.PI / 3),
            Arguments.of(- 7 * Math.PI / 3));
    }
}
