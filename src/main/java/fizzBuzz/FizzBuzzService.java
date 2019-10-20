package fizzBuzz;

class FizzBuzzService {

    static String[] doFizzBuzz(int from, int to) {
        if (from > to) {
            throw new IllegalStateException("Range is invalid. Start number is higher than ending.");
        }
        if (from < 0) {
            throw new IllegalStateException("FizzBuzz supports only positive numbers");
        }

        String[] result = new String[to - from + 1];
        int j = 0;

        for (int i = from; i <= to; i++) {
            if (i == 0) {
                result[j] = String.valueOf(0);
            }
            else if (i % 3 == 0 & i % 5 == 0) {
                result[j] = "FizzBuzz";
            }
            else if (i % 5 == 0) {
                result[j] = "Buzz";
            }
            else if (i % 3 == 0) {
                result[j] = "Fizz";
            }
            else {
                result[j] = String.valueOf(i);
            }
            j++;
        }
        return result;
    }
}
