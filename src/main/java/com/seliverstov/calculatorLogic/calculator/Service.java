package com.seliverstov.calculatorLogic.calculator;

import com.seliverstov.calculatorLogic.calculator.factory.OperationFactory;

import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Service {

    public static String correct(String exp) {

        exp = exp.replaceAll(",", ".");
        exp = exp.replaceAll(" ","");

        String correctedExp = new String();
        for (int i = 0; i < exp.length(); i++) {
            char sym = exp.charAt(i);
            if (sym == '-') {
                if (i == 0) correctedExp += '0';
                else if (exp.charAt(i - 1) == '(') correctedExp += '0';
            }
            correctedExp += sym;
        }
        return correctedExp;
    }

    public static boolean check(char ch) {
        return OperationFactory.OPERATION_MAP.containsKey(ch) || Character.isDigit(ch) || ch == '.';
    }

    public static Stack<Object> adding (List<Object> temp) {
        Stack<Object> objects = new Stack<>();
        Collections.reverse(temp);

       for (Object element : temp) {
           objects.push(element);
       }
        return objects;
    }
}

