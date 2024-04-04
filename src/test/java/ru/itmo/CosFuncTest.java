package ru.itmo;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.SinFunc;

public class CosFuncTest extends BasicTest{
    private CosFunc cos;
    private SinFunc sin;

    @BeforeEach
    public void setUp() {
        sin = new SinFunc();
        cos = new CosFunc(sin);
    }

    @ParameterizedTest
    @MethodSource("zeroValues")
    public void testZeroValues(double x) {
        Assertions.assertEquals(0, cos.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("oneValues")
    public void testOneValues(double x) {
        Assertions.assertEquals(1, cos.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("minusOneValues")
    public void testMinusOneValues(double x) {
        Assertions.assertEquals(-1, cos.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("middleValues")
    public void testMiddleValues(double x) {
        Assertions.assertEquals(Math.cos(Math.PI / 4), cos.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> zeroValues() {
        return Stream.of(                
                Arguments.of(- 3 * Math.PI / 2),
                Arguments.of(- Math.PI / 2),
                Arguments.of(Math.PI / 2),
                Arguments.of(3 * Math.PI / 2));
    }

    private static Stream<Arguments> oneValues() {
        return Stream.of(
                Arguments.of(- 4 * Math.PI),
                Arguments.of(- 2 * Math.PI),
                Arguments.of(0),
                Arguments.of(2 * Math.PI),
                Arguments.of(4 * Math.PI));
    }

    private static Stream<Arguments> minusOneValues() {
        return Stream.of(
                Arguments.of(- 3 * Math.PI),
                Arguments.of(- Math.PI),
                Arguments.of(Math.PI),
                Arguments.of(3 * Math.PI));
    }

    private static Stream<Arguments> middleValues() {
        return Stream.of(
                Arguments.of(- 9 * Math.PI / 4),
                Arguments.of(- Math.PI / 4),
                Arguments.of(Math.PI / 4),
                Arguments.of(9 * Math.PI / 4));
    }

}
