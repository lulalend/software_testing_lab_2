package ru.itmo.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.itmo.BasicTest;
import ru.itmo.funcs.basic.trig.CosFunc;
import ru.itmo.funcs.basic.trig.CotFunc;
import ru.itmo.funcs.basic.trig.CscFunc;
import ru.itmo.funcs.basic.trig.SecFunc;
import ru.itmo.funcs.basic.trig.TanFunc;
import ru.itmo.funcs.comlex.FirstFunc;

@ExtendWith(MockitoExtension.class)
public class FirstFuncTestWithMocks extends BasicTest {
    
    @Mock
    private CscFunc cscFunc;
    @Mock
    private CosFunc cosFunc;
    @Mock
    private TanFunc tanFunc;
    @Mock
    private CotFunc cotFunc;
    @Mock
    private SecFunc secFunc;

    private FirstFunc firstFunc;

    @BeforeEach
    public void setUp() {
        firstFunc = new FirstFunc(cscFunc, cosFunc, tanFunc, cotFunc, secFunc);
    }

    @Test
    public void testMockValues() {
        double x = 1;
        double cscValue = 1.1883951;
        double cosValue = 0.5403023;
        double tanValue = 1.5574077;
        double cotValue = 0.6420926;
        double secValue = 1.8508157;

        when(cscFunc.calculate(x, PRECISION)).thenReturn(cscValue);
        when(cosFunc.calculate(x, PRECISION)).thenReturn(cosValue);
        when(tanFunc.calculate(x, PRECISION)).thenReturn(tanValue);
        when(cotFunc.calculate(x, PRECISION)).thenReturn(cotValue);
        when(secFunc.calculate(x, PRECISION)).thenReturn(secValue);

        double expectedResult = (cscValue * cscValue - cotValue / tanValue)
                * cosValue * cosValue * cosValue
                * secValue / tanValue;

        double result = firstFunc.calculate(x, PRECISION);

        assertEquals(expectedResult, result, PRECISION);
    }

}
