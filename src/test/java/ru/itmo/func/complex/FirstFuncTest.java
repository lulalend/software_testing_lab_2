package ru.itmo.func.complex;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.CotFunc;
import ru.itmo.funcs.basic.trig.CscFunc;
import ru.itmo.funcs.basic.trig.SecFunc;
import ru.itmo.funcs.basic.trig.SinFunc;
import ru.itmo.funcs.basic.trig.TanFunc;
import ru.itmo.funcs.comlex.FirstFunc;

public class FirstFuncTest extends BasicTest{
    
    private CscFunc cscFunc;
    private CosFunc cosFunc;
    private TanFunc tanFunc;
    private CotFunc cotFunc;
    private SecFunc secFunc;

    private SinFunc sinFunc;
    private FirstFunc firstFunc;

    @BeforeEach
    public void setUp() {
        sinFunc = new SinFunc();
        cscFunc = new CscFunc(sinFunc);
        cosFunc = new CosFunc(sinFunc);
        tanFunc = new TanFunc(sinFunc, cosFunc);
        cotFunc = new CotFunc(sinFunc, cosFunc);
        secFunc = new SecFunc(cosFunc);
        firstFunc = new FirstFunc(cscFunc, cosFunc, tanFunc, cotFunc, secFunc);
    }

    @ParameterizedTest
    @MethodSource("randomValues")
    public void testRandomValues(double x, double expected) {
        assertEquals(expected, firstFunc.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("illegalValues")
    public void testIllegalValues(double x) {
        assertThrows(IllegalArgumentException.class, () -> firstFunc.calculate(x, PRECISION));
    }

    private static Stream<Arguments> randomValues() {
        return Stream.of(
            Arguments.of(5, -0.0238024),
            Arguments.of(13, 1.77845),
            Arguments.of(-24, 0.0842794),
            Arguments.of(-1, -0.187444)
        );
    }

    private static Stream<Arguments> illegalValues() {
        return Stream.of(
            Arguments.of(Math.PI),
            Arguments.of(Math.PI / 2),
            Arguments.of(- Math.PI / 2),
            Arguments.of(3 * Math.PI),
            Arguments.of(- 3 * Math.PI / 2),
            Arguments.of(2 * Math.PI),
            Arguments.of(0)
        );
    }
}
