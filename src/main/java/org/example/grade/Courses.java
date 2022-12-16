package org.example.grade;

import java.util.List;

public class Courses {

    // 일급 컬렉션
    // 여러 개(리스트 형태)의 오직 하나의 인스턴스 정보만을 가짐(변수 2개 불가)
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    // 해당 정보들로 처리할 수 있는 모든 책임들이 모두 위임(GradeCalculate 계산을 모두 위임)
    // 해당 정보와 관련된 수정사항 발생 시 해당 부분만 수정하면 됨
    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
//        double multipliedCreditAndCourseGrade = 0;
//        for(Course course: courses){
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
