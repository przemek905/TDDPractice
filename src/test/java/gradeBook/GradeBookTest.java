package gradeBook;

import org.assertj.core.util.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.emptyList;
import static org.assertj.core.util.Lists.newArrayList;


public class GradeBookTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void createGradeBook() {
        //given
        GradeBook gradeBook;

        //when
        gradeBook = new GradeBook();

        //then
        assertThat(gradeBook).isNotNull();
    }

    @Test
    public void addSubjectToGradeBook() {
        //given
        Subject biology = new Subject("Biology", emptyList());
        GradeBook gradeBook = new GradeBook();
        //when
        gradeBook.addSubject(biology);

        //then
        assertThat(gradeBook.getSubjects().keySet()).containsOnly("Biology");
    }

    @Test
    public void getAllSubjectsFromGradeBook() {
        //given
        Subject biology = new Subject("Biology", emptyList());
        Subject history = new Subject("History", emptyList());

        GradeBook gradeBook = new GradeBook();
        gradeBook.addSubject(biology);
        gradeBook.addSubject(history);

        //when
        Map<String, Subject> subjects = gradeBook.getSubjects();

        //then
        assertThat(subjects.keySet()).contains("Biology", "History");
    }

    @Test
    public void getSubjectFromGradeBook() {
        //given
        Subject biology = new Subject("Biology", emptyList());
        Subject history = new Subject("History", emptyList());

        GradeBook gradeBook = new GradeBook();
        gradeBook.addSubject(biology);
        gradeBook.addSubject(history);

        //when
        Subject subject = gradeBook.getSubject(history.getName());

        //then
        assertThat(subject.getName()).isEqualTo("History");
    }

    @Test
    public void getSubjectFromGradeBookWhichNotExist() {
        //given
        Subject biology = new Subject("Biology", emptyList());
        Subject history = new Subject("History", emptyList());

        GradeBook gradeBook = new GradeBook();
        gradeBook.addSubject(biology);
        gradeBook.addSubject(history);

        //when
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Subject not exist in gradebook");

        gradeBook.getSubject("English");
    }


    @Test
    public void getGradeBookAverage() {
        //given
        Subject biology = new Subject("Biology", newArrayList(Grade.A, Grade.A, Grade.B, Grade.C, Grade.D));
        Subject history = new Subject("History", Lists.newArrayList(Grade.A, Grade.A, Grade.D, Grade.D, Grade.D));
        GradeBook gradeBook = new GradeBook();
        gradeBook.addSubject(biology);
        gradeBook.addSubject(history);

        //when
        double gradeBookAverage = gradeBook.getAverage();

        //then
        assertThat(gradeBookAverage).isEqualTo(4.5);
    }

    @Test
    public void emptyGradeBookAverage() {
        //given
        GradeBook gradeBook = new GradeBook();

        //when
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Gradebook is empty");

        gradeBook.getAverage();
    }
}