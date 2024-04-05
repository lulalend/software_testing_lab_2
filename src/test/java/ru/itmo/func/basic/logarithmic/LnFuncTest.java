package ru.itmo.func.basic.logarithmic;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.logarithmic.LnFunc;

public class LnFuncTest extends BasicTest{
    private LnFunc ln;

    @BeforeEach
    public void setUp() {
        ln = new LnFunc();
    }

    @ParameterizedTest
    @MethodSource("illegalXs")
    public void testIllegalArgumentExceptionWithX(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ln.calculate(x, PRECISION));
    }

    @ParameterizedTest
    @MethodSource("illegalEps")
    public void testIllegalArgumentExceptionWithEps(double eps) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ln.calculate(1, eps));
    }

    @Test 
    public void testZeroValue(){
        Assertions.assertEquals(0, ln.calculate(1, PRECISION), PRECISION);
    }

    @Test 
    public void testOneValue(){
        Assertions.assertEquals(1, ln.calculate(Math.exp(1), PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("randomValues")
    public void testRandomValues(double x, double expected) {
        Assertions.assertEquals(expected, ln.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> illegalXs() {
        return Stream.of(
            Arguments.of(-1),
            Arguments.of(0),
            Arguments.of(-1.001),
            Arguments.of(-200),
            Arguments.of(-0.0056)
        );
    }

    private static Stream<Arguments> illegalEps() {
        return Stream.of(
            Arguments.of(-1),
            Arguments.of(0),
            Arguments.of(-1.001),
            Arguments.of(200),
            Arguments.of(0.501)
        );
    }

    private static Stream<Arguments> randomValues() {
        return Stream.of(
            Arguments.of(2, 0.693147180),
            Arguments.of(5, 1.609437912),
            Arguments.of(10, 2.302585093),
            Arguments.of(200, 5.29832),
            Arguments.of(1000, 6.907755279)
        );
    }
}
