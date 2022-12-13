package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validPasswordTest(){
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException(); // 예외가 발생하지 않음을 확인
    }

    @DisplayName("비밀번호가 최소 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"}) // 경계값 테스트 -> 파라미터로 받을 수 있음
    void validPasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)         // IllegalArgumentException 예외가 발생함을 확인
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다."); // 해당 메시지를 가지는지 확인
    }
}
