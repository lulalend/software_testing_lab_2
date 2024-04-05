package ru.itmo.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.itmo.BasicTest;
import ru.itmo.funcs.comlex.FirstFunc;
import ru.itmo.funcs.comlex.SecondFunc;
import ru.itmo.systems.MainSystem;

@ExtendWith(MockitoExtension.class)
public class MainSystemTestWithMocks extends BasicTest{

    @Mock
    private FirstFunc firstFunc;
    @Mock
    private SecondFunc secondFunc;

    private MainSystem mainSystem;

    @BeforeEach
    public void setUp() {
        mainSystem = new MainSystem(firstFunc, secondFunc);
    }

    @Test
    public void testCalculatePositiveX() {
        double x = -1.0;
        double firstFuncResult = -0.187444;

        when(firstFunc.calculate(x, PRECISION)).thenReturn(firstFuncResult);

        double result = mainSystem.calculate(x, PRECISION);

        assertEquals(firstFuncResult, result, PRECISION);
    }

    @Test
    public void testCalculateNegativeX() {
        double x = 3.0;
        double secondFuncResult = 3.5363;

        when(secondFunc.calculate(x, PRECISION)).thenReturn(secondFuncResult);

        double result = mainSystem.calculate(x, PRECISION);

        assertEquals(secondFuncResult, result, PRECISION);
    }

    @Test
    public void testCalculateZeroX() {
        double x = 0.0;

        when(firstFunc.calculate(x, PRECISION)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> mainSystem.calculate(x, PRECISION));
    }

}
