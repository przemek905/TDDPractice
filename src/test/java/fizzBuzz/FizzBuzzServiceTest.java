package fizzBuzz;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FizzBuzzServiceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void positiveFizzBuzz() {
        //given
        int from = 1;
        int to = 5;

        //when
        String[] result = FizzBuzzService.doFizzBuzz(from, to);

        //then
        assertThat(result).containsExactly("1", "2", "Fizz", "4", "Buzz");
    }

    @Test
    public void fullFizzBuzz() {
        //given
        int from = 0;
        int to = 100;

        //when
        String[] result = FizzBuzzService.doFizzBuzz(from, to);

        //then
        assertThat(result[0]).isEqualTo("0");
        assertThat(result[60]).isEqualTo("FizzBuzz");
        assertThat(result[100]).isEqualTo("Buzz");
    }

    @Test
    public void wrongRange() {
        //given
        int from = 20;
        int to = 3;

        //when
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Range is invalid. Start number is higher than ending.");
        FizzBuzzService.doFizzBuzz(from, to);
    }

    @Test
    public void negativeRange() {
        //given
        int from = -20;
        int to = 3;

        //when
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("FizzBuzz supports only positive numbers");
        FizzBuzzService.doFizzBuzz(from, to);
    }

    @Test
    public void fullTest() {
        //given
        int from = 10;
        int to = 25;

        //when
        String[] result = FizzBuzzService.doFizzBuzz(from, to);

        //then
        String resultString = String.join(",", result);
        assertThat(resultString).isEqualTo("Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, " +
                "Fizz, Buzz");
    }
}