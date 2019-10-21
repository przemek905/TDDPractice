package gradeBook;

import lombok.Getter;

@Getter
public enum Grade {
    A(6), B(5), C(4), D(3), F(2);

    public int gradeValue;

    Grade(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}
