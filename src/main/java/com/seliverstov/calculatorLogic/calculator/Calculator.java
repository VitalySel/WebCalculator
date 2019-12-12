package com.seliverstov.calculatorLogic.calculator;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {
    public Calculator() {
    }

    public BigDecimal calculate(String exp){
        try {
            Stack<Object> expressionOutput = ReverseExpression.transform(exp);
            BigDecimal result = ReverseAnswer.answer(expressionOutput);
            return result;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return BigDecimal.ONE;
    }
}
