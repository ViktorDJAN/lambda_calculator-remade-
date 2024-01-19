package org.example.calculator_logic;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void enteringNullCheque() {
        Calculator calculator1 = mock(Calculator.class);
        assertThrows(Exception.class, () -> {
            doThrow().when(calculator1).compute().equals(null);
        });
        calculator1.compute();
    }


    @Test
    public void additionScenario1() {
        assertEquals(5, calculator.additionOperation.process(2.0, 3.0));
    }

    @Test
    public void additionScenario2() {
        assertEquals(55, calculator.additionOperation.process(22.0, 33.0));
    }

    @Test
    public void subtractionScenario1() {
        assertEquals(105, calculator.substructureOperation.process(115.0, 10.0));
    }

    @Test
    public void subtractionScenario2() {
        assertEquals(9, calculator.substructureOperation.process(115.0, 106.0));
    }

    @Test
    public void divisionScenario1() {
        assertEquals(15, calculator.divisionOperation.process(225.0, 15.0));
    }

    @Test
    public void divisionScenario2() {
        assertEquals(9, calculator.divisionOperation.process(81.0, 9.0));
    }

    @Test
    public void multiplicationScenario1() {
        assertEquals(225, calculator.multiplicationOperation.process(15.0, 15.0));
    }

    @Test
    public void multiplicationScenario2() {
        assertEquals(90, calculator.multiplicationOperation.process(10.0, 9.0));
    }


    @Test
    public void correctBracketsQuantityScenario() throws ArrayIndexOutOfBoundsException {
        Calculator clc2 = new Calculator("(2+2");
        assertThrows(ArrayIndexOutOfBoundsException.class, clc2::compute);
    }

    @Test
    public void correctBracketsFormatScenario() throws ArrayIndexOutOfBoundsException {
        Calculator clc2 = new Calculator("(2+2}");
        assertThrows(NumberFormatException.class, clc2::compute);
    }

}