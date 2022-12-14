package org.example.calculator;

import java.util.Arrays;

public enum ArithmeticOperator {
    // enum마다 추상메소드 구현
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        ArithmeticOperator arithmeticOperator = Arrays.stream(values()) // 모든 enum 값을 가져옴
                .filter(v -> v.operator.equals(operator)) // operator와 일치하는 enum값을 찾음
                .findFirst() // enum 값을 가져옴
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다.")); // 예외처리

        return arithmeticOperator.arithmeticCalculate(operand1.toInt(), operand2.toInt());
    }
}
