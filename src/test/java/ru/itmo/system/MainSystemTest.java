package ru.itmo.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.logarithmic.LnFunc;
import ru.itmo.funcs.basic.logarithmic.Log3Func;
import ru.itmo.funcs.basic.logarithmic.Log5Func;
import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.CotFunc;
import ru.itmo.funcs.basic.trig.CscFunc;
import ru.itmo.funcs.basic.trig.SecFunc;
import ru.itmo.funcs.basic.trig.SinFunc;
import ru.itmo.funcs.basic.trig.TanFunc;
import ru.itmo.funcs.comlex.FirstFunc;
import ru.itmo.funcs.comlex.SecondFunc;
import ru.itmo.systems.MainSystem;

public class MainSystemTest extends BasicTest{
    private SinFunc sin;
    private CscFunc csc;
    private CosFunc cos;
    private TanFunc tan;
    private CotFunc cot;
    private SecFunc sec;
    private LnFunc ln;
    private Log3Func log3;
    private Log5Func log5;
    private FirstFunc firstFunc;
    private SecondFunc secondFunc;
    private MainSystem mainSystem;

    @BeforeEach
    public void setUp() {
        sin = new SinFunc();
        cos = new CosFunc(sin);
        csc = new CscFunc(sin);
        tan = new TanFunc(sin, cos);
        cot = new CotFunc(sin, cos);
        sec = new SecFunc(cos);
        ln = new LnFunc();
        log3 = new Log3Func(ln);
        log5 = new Log5Func(ln);
        firstFunc = new FirstFunc(csc, cos, tan, cot, sec);
        secondFunc = new SecondFunc(ln, log3, log5);
        mainSystem = new MainSystem(firstFunc, secondFunc);
    }

    @Test
    public void testZeroValue() {
        assertThrows(IllegalArgumentException.class, () -> mainSystem.calculate(0, PRECISION));
    }

    @ParameterizedTest
    @MethodSource("positiveValues")
    public void testPositiveValues(double x, double expected) {
        assertEquals(expected, mainSystem.calculate(x, PRECISION), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    public void testNegativeValues(double x, double expected) {
        assertEquals(expected, mainSystem.calculate(x, PRECISION), PRECISION);
    }

    private static Stream<Arguments> positiveValues() {
        return Stream.of(
            Arguments.of(19, 9.47778),
            Arguments.of(2.021, 2.26478),
            Arguments.of(1.337, 0.934853),
            Arguments.of(0.01, -14.32356),
            Arguments.of(105, 14.407313)
        );
    }

    private static Stream<Arguments> negativeValues() {
        return Stream.of(
            Arguments.of(-2.2, 0.252095),
            Arguments.of(-63.888, -0.13701),
            Arguments.of(-12.47, 10.24612),
            Arguments.of(-8.7664, 0.808857),
            Arguments.of(-462, -5.1343)
        );
    }

}
