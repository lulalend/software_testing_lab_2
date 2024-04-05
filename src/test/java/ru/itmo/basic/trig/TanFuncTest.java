package ru.itmo.basic.trig;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.SinFunc;
import ru.itmo.funcs.basic.trig.TanFunc;

public class TanFuncTest extends BasicTest {
    private SinFunc sin;
    private CosFunc cos;
    private TanFunc tan;

    @BeforeEach
    public void setUp() {
        sin = new SinFunc();
        cos = new CosFunc(sin);
        tan = new TanFunc(sin, cos);
    }

    @ParameterizedTest
    @MethodSource("illegalValues")
    public void testIllegalValues(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> tan.calculate(x, PRECISION));
    }

    @ParameterizedTest
    @MethodSource("zeroValues")
    public void testZeroValues(double x) {
        Assertions.assertEquals(0, tan.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("oneValues")
    public void testOneValues(double x) {
        Assertions.assertEquals(1, tan.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("minusOneValues")
    public void testMinusOneValues(double x) {
        Assertions.assertEquals(-1, tan.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("biggerThanOnePositiveValues")
    public void testBiggerThanOnePositiveValues(double x) {
        Assertions.assertEquals(Math.tan(Math.PI / 6), tan.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("biggerThanOneNegativeValues")
    public void testBiggerThanOneNegativeValues(double x) {
        Assertions.assertEquals(- Math.tan(Math.PI / 6), tan.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> illegalValues() {
        return Stream.of(
            Arguments.of(Math.PI / 2),
            Arguments.of(- Math.PI / 2),
            Arguments.of(3 * Math.PI / 2));
    }

    private static Stream<Arguments> zeroValues() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(Math.PI),
            Arguments.of(- Math.PI),
            Arguments.of(2 * Math.PI),
            Arguments.of(- 2 * Math.PI));
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
                Arguments.of(- 17 * Math.PI / 6),
                Arguments.of(- 5 * Math.PI / 6),
                Arguments.of(Math.PI / 6),
                Arguments.of(13 * Math.PI / 6));
    }

    private static Stream<Arguments> biggerThanOneNegativeValues() {
        return Stream.of(
                Arguments.of(- 13 * Math.PI / 6),
                Arguments.of(- Math.PI / 6),
                Arguments.of(5 * Math.PI / 6),
                Arguments.of(17 * Math.PI / 6));
    }
}


