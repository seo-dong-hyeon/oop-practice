package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {
    
    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void crateTest(){
        assertThatCode(() -> new Course("OOP", 3, "A+"))
                .doesNotThrowAnyException(); // 어떤 예외도 발생x -> 정상 생성
    }
}
