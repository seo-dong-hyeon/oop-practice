package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 객체지향 설계 및 구현
// 1.도메인을 구성하는 객체에는 어떤 것들이 있는지
// 2.객체들 간의 관계
// 3.동적인 객체를 정적인 타입(클래스)으로 추상화해서 도메인 모델링
// 4.협력 설계
// 5.객체들을 포괄하는 타입에 적절한 책임 할당
// 6.구현
public class GradeCalculatorTest {

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest(){
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);

    }
}
