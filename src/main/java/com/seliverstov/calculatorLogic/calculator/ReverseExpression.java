package com.seliverstov.calculatorLogic.calculator;

import com.seliverstov.calculatorLogic.calculator.factory.OperationFactory;
import com.seliverstov.calculatorLogic.calculator.operations.Operation;
import com.seliverstov.calculatorLogic.calculator.builder.Number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseExpression {

    public static Stack<Object> transform(String exp) throws Exception {
        Stack<Object> stack = new Stack<>();
        int priority;
        Number.Biulder num = new Number.Biulder();

        List<Object> calcObject = new ArrayList<>();
        List<Object> tempObject = new ArrayList<>();

        String correctedExpression = Service.correct(exp);

        for (int i = 0; i < correctedExpression.length(); i++){
            int currentIndex = i;
            char ch = correctedExpression.charAt(i);
            if (Service.check(ch)) {
                if (Character.isDigit(ch) || ch == '.') {
                        num.withNumber(ch).build();
                        if ( currentIndex == correctedExpression.length()-1)
                            calcObject.add(num.build());
                } else {
                    if (num.build() != null) {
                        calcObject.add(num.build());
                        num = new Number.Biulder();
                    }
                    calcObject.add(OperationFactory.createOperation(ch));
                }
            } else {
                throw new Exception("Invalid character : " + ch);
            }
        }

        for (Object element : calcObject) {
            if (element instanceof BigDecimal){
                tempObject.add(element);
            }
            else{
                Operation operation = (Operation) element;
                priority = operation.getPriority();
                switch (priority) {
                    case 0:
                        while (!operation.checkPriority(stack.peek())) {
                            tempObject.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    case 1:
                        stack.push(element);
                        break;
                    case 2:
                    case 3:
                        while (!stack.empty()) {
                            Operation op = (Operation)stack.peek();
                            if (op.getPriority() >= priority){
                                tempObject.add(stack.pop());
                            } else break;
                        }
                        stack.push(element);
                        break;
                }
            }
        }
        while (!stack.empty()) {
            tempObject.add(stack.pop());
        }
        return Service.adding(tempObject);
    }
}




