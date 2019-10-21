package gradeBook;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SubjectTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void createSubject() {
        //given
        Subject subject;

        //when
        subject = new Subject();

        //then
        assertThat(subject).isNotNull();
    }

    @Test
    public void addGradeToSubject() {
        //given
        Grade gradeA = Grade.A;
        Subject math = new Subject("Math", new ArrayList<>());

        //when
        math.addGrade(gradeA);

        //then
        List<Grade> mathGrades = math.getGrades();
        assertThat(mathGrades).extracting(Enum::name).contains("A");
    }

    @Test
    public void countAverageGradeForSubject() {
        //given
        Subject english = new Subject("English", new ArrayList<>());

        english.addGrade(Grade.A);
        english.addGrade(Grade.A);
        english.addGrade(Grade.B);
        english.addGrade(Grade.C);
        english.addGrade(Grade.D);

        //when
        long englishAverage = english.getAvarage();

        //then
        assertThat(englishAverage).isEqualTo(4.8);
    }
    @Test
    public void countAverageGradeForEmptySubject() {
        //given
        Subject english = new Subject("English", new ArrayList<>());

        //when
        english.getAvarage();

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Subject not have any grade.");
    }


}