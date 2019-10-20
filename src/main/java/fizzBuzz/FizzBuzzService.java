package fizzBuzz;

import java.util.stream.IntStream;

class FizzBuzzService {

    static String[] doFizzBuzz(int from, int to) {
        checkRangeParameters(from, to);

        return IntStream.rangeClosed(from, to)
                .mapToObj(FizzBuzzService::getResultForNumber).toArray(String[]::new);
    }

    private static String getResultForNumber(int i) {
        if (i == 0) {
            return String.valueOf(0);
        }
        else if (i % 3 == 0 & i % 5 == 0) {
            return "FizzBuzz";
        }
        else if (i % 5 == 0) {
            return "Buzz";
        }
        else if (i % 3 == 0) {
            return "Fizz";
        }
        else {
            return String.valueOf(i);
        }
    }

    private static void checkRangeParameters(int from, int to) {
        if (from > to) {
            throw new IllegalStateException("Range is invalid. Start number is higher than ending.");
        }
        if (from < 0) {
            throw new IllegalStateException("FizzBuzz supports only positive numbers");
        }
    }
}
