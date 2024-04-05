package ru.itmo.func.basic.trig;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.trig.CscFunc;
import ru.itmo.funcs.basic.trig.SinFunc;

public class CscFuncTest extends BasicTest{
    private SinFunc sin;
    private CscFunc csc;

    @BeforeEach
    public void setUp() {
        sin = new SinFunc();
        csc = new CscFunc(sin);
    }

    @ParameterizedTest
    @MethodSource("illegalValues")
    public void testIllegalValues(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> csc.calculate(x, PRECISION));
    }

    @ParameterizedTest
    @MethodSource("oneValues")
    public void testOneValues(double x) {
        Assertions.assertEquals(1, csc.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("minusOneValues")
    public void testMinusOneValues(double x) {
        Assertions.assertEquals(-1, csc.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("middleValues")
    public void testMiddleValues(double x) {
        Assertions.assertEquals(1 / Math.sin(Math.PI / 4), csc.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> illegalValues() {
        return Stream.of(
            Arguments.of(Math.PI),
            Arguments.of(- Math.PI),
            Arguments.of(2 * Math.PI),
            Arguments.of(0));
    }

    private static Stream<Arguments> oneValues() {
        return Stream.of(
                Arguments.of(- 11 * Math.PI / 2),
                Arguments.of(- 7 * Math.PI / 2),
                Arguments.of(- 3 * Math.PI / 2),
                Arguments.of(Math.PI / 2),
                Arguments.of(5 * Math.PI / 2),
                Arguments.of(9 * Math.PI / 2));
    }

    private static Stream<Arguments> minusOneValues() {
        return Stream.of(
                Arguments.of(- 9 * Math.PI / 2),
                Arguments.of(- 5 * Math.PI / 2),
                Arguments.of(- Math.PI / 2),
                Arguments.of(3 * Math.PI / 2),
                Arguments.of(7 * Math.PI / 2),
                Arguments.of(11 * Math.PI / 2));
    }

    private static Stream<Arguments> middleValues() {
        return Stream.of(
                Arguments.of(- 7 * Math.PI / 4),
                Arguments.of(- 5 * Math.PI / 4),
                Arguments.of(Math.PI / 4),
                Arguments.of(3 * Math.PI / 4),
                Arguments.of(9 * Math.PI / 4),
                Arguments.of(11 * Math.PI / 4));
    }

}
