package org.example.calculator;

import java.util.List;

public class Calculator {

    // 각각의 구현체를 상위의 인터페이스 리스트로 받음
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        // 일일이 구현
//        if ("+".equals(operator)){
//            return operand1 + operand2;
//        } else if ("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if ("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if ("/".equals(operator)) {
//            return operand1 / operand2;
//        }
        
        // enum에게 다시 작업 위임
        // return ArithmeticOperator.calculate(operand1, operator, operand2);

        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator)) // operator에 맞는 실제 구현체를 가져옴
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2)) // 찾은 구현체에게 calculate 작업 위임
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다.")); // operator에 해당하는 구현체가 없을 때 예외처리
    }
}
