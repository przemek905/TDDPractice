package gradeBook;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Data
class GradeBook {
    private Map<String, Subject> subjects;

    GradeBook() {
        subjects = new HashMap<>();
    }

    void addSubject(Subject subject) {
        subjects.put(subject.getName(), subject);
    }

    Map<String, Subject> getSubjects() {
        return Collections.unmodifiableMap(subjects);
    }

    Subject getSubject(String subjectName) {
        return subjects.entrySet().stream()
                .filter(x -> x.getKey().equals(subjectName))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Subject not exist in gradebook"));
    }

    double getAverage() {
        return subjects.values().stream()
                .mapToDouble(Subject::getAverage)
                .average()
                .orElseThrow(() -> new IllegalStateException("Gradebook is empty"));
    }
}
