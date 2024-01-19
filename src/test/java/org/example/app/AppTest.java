package org.example.app;

import org.example.calculator_logic.Calculator;
import org.example.view.View;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppTest {

    @InjectMocks
    private Calculator mCalculator;
   @Mock
   private View mview;


}