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
import ru.itmo.funcs.basic.logarithmic.Log5Func;

public class Log5FuncTest extends BasicTest {
    private LnFunc ln;
    private Log5Func log5;

    @BeforeEach
    public void setUp() {
        ln = new LnFunc();
        log5 = new Log5Func(ln);
    }

    @Test 
    public void testZeroValue(){
        Assertions.assertEquals(0, log5.calculate(1, PRECISION), PRECISION);
    }

    @Test 
    public void testOneValue(){
        Assertions.assertEquals(1, log5.calculate(5, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("randomValues")
    public void testRandomValues(double x, double expected) {
        Assertions.assertEquals(expected, log5.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> randomValues() {
        return Stream.of(
            Arguments.of(3, 0.6826),
            Arguments.of(7, 1.2091),
            Arguments.of(12, 1.544),
            Arguments.of(348, 3.6362),
            Arguments.of(1398, 4.5002)
        );
    }
}
