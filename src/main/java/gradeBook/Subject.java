package gradeBook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private String name;
    private List<Grade> grades;

    public void addGrade(Grade grade) {

    }

    public long getAvarage() {
        return 0;
    }
}
