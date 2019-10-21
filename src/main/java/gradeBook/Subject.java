package gradeBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Subject {
    private String name;
    private List<Grade> grades;

    void addGrade(Grade grade) {
        grades.add(grade);
    }

    double getAverage() {
        return grades.stream()
                .mapToLong(Grade::getGradeValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("Subject not have any grade."));
    }
}
