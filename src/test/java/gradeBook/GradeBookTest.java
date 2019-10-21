package gradeBook;

import org.assertj.core.util.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

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
        assertThat(gradeBook.getSubjects()).extracting(Subject::getName).containsOnly("Biology");
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
        List<Subject> subjects = gradeBook.getSubjects();

        //then
        assertThat(subjects).extracting(Subject::getName).contains("Biology", "History");
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
        Subject subject = gradeBook.getSubject(history);

        //then
        assertThat(subject.getName()).isEqualTo("History");
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
        long gradeBookAverage = gradeBook.getAverage();

        //then
        assertThat(gradeBookAverage).isEqualTo(4.5);
    }

    @Test
    public void emptyGradeBookAverage() {
        //given
        GradeBook gradeBook = new GradeBook();

        //when
        gradeBook.getAverage();

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Gradebook is empty");
    }
}