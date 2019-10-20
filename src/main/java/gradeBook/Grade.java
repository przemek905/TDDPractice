package gradeBook;

public enum Grade {
    A(6), B(5), C(4), D(3), F(2);

    private int gradeValue;

    Grade(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}
