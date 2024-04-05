package ru.itmo.basic.trig;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.trig.SinFunc;

public class SinFuncTest extends BasicTest {
    
    private SinFunc sin;

    @BeforeEach
    public void setUp() {
        sin = new SinFunc();
    }

    @ParameterizedTest
    @MethodSource("zeroValues")
    public void testZeroValues(double x) {
        Assertions.assertEquals(0, sin.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("oneValues")
    public void testOneValues(double x) {
        Assertions.assertEquals(1, sin.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("minusOneValues")
    public void testMinusOneValues(double x) {
        Assertions.assertEquals(-1, sin.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("middleValues")
    public void testMiddleValues(double x) {
        Assertions.assertEquals(Math.sin(Math.PI / 4), sin.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> zeroValues() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(Math.PI),
                Arguments.of(Math.PI * 2));
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
