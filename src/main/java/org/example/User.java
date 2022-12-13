package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        // as-is
        // 내부에서 RandomPasswordGenerator 생성 -> 비밀번호 생성방식을 컨트롤할 수 없음
        // RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be
        // interface 구현체를 선언 -> 인자로 받는 방식
        // 운영에선 RandomPasswordGenerator를 주입하겠지만
        // 테스트를 위해 interface를 구현한 Correct.., Wrong..을 구현 -> 항상 통과, 항상 실패하는 경우 테스트
        // 낮은 결합도 구현
        String password = passwordGenerator.generatePassword();

        if (password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
