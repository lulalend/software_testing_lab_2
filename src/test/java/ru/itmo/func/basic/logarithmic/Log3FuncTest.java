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
import ru.itmo.funcs.basic.logarithmic.Log3Func;

public class Log3FuncTest extends BasicTest{
    private LnFunc ln;
    private Log3Func log3;

    @BeforeEach
    public void setUp() {
        ln = new LnFunc();
        log3 = new Log3Func(ln);
    }

    @Test 
    public void testZeroValue(){
        Assertions.assertEquals(0, log3.calculate(1, PRECISION), PRECISION);
    }

    @Test 
    public void testOneValue(){
        Assertions.assertEquals(1, log3.calculate(3, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("randomValues")
    public void testRandomValues(double x, double expected) {
        Assertions.assertEquals(expected, log3.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> randomValues() {
        return Stream.of(
            Arguments.of(2, 0.6309),
            Arguments.of(8, 1.89279),
            Arguments.of(15, 2.46497),
            Arguments.of(238, 4.9811),
            Arguments.of(1098, 6.37281)
        );
    }
}
