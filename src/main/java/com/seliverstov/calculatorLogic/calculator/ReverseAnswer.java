package com.seliverstov.calculatorLogic.calculator;

import com.seliverstov.calculatorLogic.calculator.operations.Operation;

import java.math.BigDecimal;
import java.util.Stack;

public class ReverseAnswer {

    public static BigDecimal answer(Stack<Object> obj) {
        Stack<BigDecimal> stack = new Stack<>();

        while (!obj.empty()) {
                if (obj.peek() instanceof BigDecimal) {
                    stack.push((BigDecimal) obj.pop());
                }
                else {
                    Operation operation = (Operation) obj.pop();
                    BigDecimal a = stack.pop();
                    BigDecimal b = stack.pop();
                    stack.push(operation.result(b, a));
                }
            }
        return stack.pop();
    }
}
