package org.example.grade;

import java.util.List;

public class GradeCalculator {
    // 일급 컬렉션
    private final Courses courses;
    // private final List<Course> courses;

    public GradeCalculator(List<Course> courses){
        // 일급 컬렉션에 전달
        this.courses = new Courses(courses);
    }

    public double calculateGrade(){
        // 일급 컬렉션 방식
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;

//        // (학점수 * 교과목 평점) 합계
//        double multipliedCreditAndCourseGrade = 0;
//        for(Course course: courses){
//            // 방식1
//            // GradeCalculator가 직접 계산 수행
//            // 해당 부분에 대한 로직이 바뀐다면
//            // 해당 기능(학점 계산)을 사용하는 모든 부분의 코드를 다 바꿔야함 -> 낮은 응집도
//            // multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//
//            // 방식2
//            // getter로 정보를 가져와서 처리x
//            // 데이터를 가진 객체(course)에서 작업(학점 계산)까지 수행 -> 작업 위임
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }
//
//        // 수강신청 총학점 수
//        int totalCompletedCredit = courses.stream()
//                .mapToInt(Course::getCredit)
//                .sum();
//
//        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
