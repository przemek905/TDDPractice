package gradeBook;

import java.util.List;

/*
Class without lombok to see how pit tests checking mutation.
 */
class Subject {
    private String name;
    private List<Grade> grades;

    Subject(String name, List<Grade> grades) {
        this.name = name;
        this.grades = grades;
    }

    Subject() {
    }

    void addGrade(Grade grade) {
        grades.add(grade);
    }

    double getAverage() {
        return grades.stream()
                .mapToLong(Grade::getGradeValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("Subject not have any grade."));
    }

    String getName() {
        return name;
    }

    List<Grade> getGrades() {
        return grades;
    }
}
