package ru.itmo.func.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.logarithmic.LnFunc;
import ru.itmo.funcs.basic.logarithmic.Log3Func;
import ru.itmo.funcs.basic.logarithmic.Log5Func;
import ru.itmo.funcs.comlex.SecondFunc;

@ExtendWith(MockitoExtension.class)
public class SecondFuncTestWithMocks extends BasicTest {
    @Mock
    private LnFunc lnFunc;
    @Mock
    private Log3Func log3Func;
    @Mock
    private Log5Func log5Func;

    private SecondFunc secondFunc;

    @BeforeEach
    public void setUp() {
        secondFunc = new SecondFunc(lnFunc, log3Func, log5Func);
    }

    @Test
    public void testMockValues() {
        double x = 2.0;
        double lnValue = 0.693147180;
        double log3Value = 0.63092975;
        double log5Value = 0.43067558;

        when(lnFunc.calculate(x*x, PRECISION)).thenReturn(lnValue);
        when(log3Func.calculate(x, PRECISION)).thenReturn(log3Value);
        when(log5Func.calculate(x*x, PRECISION)).thenReturn(log5Value);

        double expectedResult = lnValue * lnValue * log3Value / log3Value / log5Value;

        double result = secondFunc.calculate(x, PRECISION);

        assertEquals(expectedResult, result, PRECISION);
    }
}
