package com.dianafisher.interviewbit.stacks_and_queues;

/*
* Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {

    public int evalRPN(ArrayList<String> a) {

        Stack<Integer> stack = new Stack<>();
        for (String s : a) {
            if (isNumber(s)) {
                int val = Integer.valueOf(s);
                stack.push(val);
            } else {
                // which operand is this?
                if (stack.isEmpty()) continue;
                Integer op1 = stack.pop();
                if (stack.isEmpty()) continue;
                Integer op2 = stack.pop();
                int result = 0;
                switch (s) {
                    case "+":
                        System.out.println(op2 + " + " + op1);
                        result = op2 + op1;
                        stack.push(result);
                        break;
                    case "-":
                        System.out.println(op2 + " - " + op1);
                        result = op2 - op1;
                        stack.push(result);
                        break;
                    case "*":
                        System.out.println(op2 + " * " + op1);
                        result = op2 * op1;
                        stack.push(result);
                        break;
                        case "/":
                            System.out.println(op2 + " / " + op1);
                            if (op1 != 0) {  // prevent divide by zero.
                                result = op2 / op1;
                                stack.push(result);
                            }

                        break;
                    default:
                        break;

                }
            }
            System.out.println(stack);
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            return 0;
        }

    }

    private boolean isNumber(String s) {
        return !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static void main(String[] args) {

        EvaluateExpression ee = new EvaluateExpression();
        ArrayList<String> expression = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"));
        System.out.println(ee.evalRPN(expression));


        expression = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
        System.out.println(ee.evalRPN(expression));

        expression = new ArrayList<>(Arrays.asList("32", "+", "52"));
        System.out.println(ee.evalRPN(expression));

        expression = new ArrayList<>(Arrays.asList("-1"));
        System.out.println(ee.evalRPN(expression));
    }
}
