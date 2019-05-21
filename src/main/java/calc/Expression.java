package calc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private static final String CUSTOM_DELIMITER_EXTRACTOR = "//|\n";

    public static List<Integer> getTokens(String input) {
        if (input == null || input.trim().length() == 0) {
            return Arrays.asList(0);
        }
        return validate(parse(tokenize(input)));
    }

    private static List<String> tokenize(String input) {
        String delimiter = ",|:";
        List<String> parts = Arrays.asList(input.split(CUSTOM_DELIMITER_EXTRACTOR));
        if (parts.size() != 1) {
            delimiter += "|" + parts.get(1);
        }
        String expression = parts.get(parts.size() - 1);
        return Arrays.asList(expression.split(delimiter));
    }

    private static List<Integer> parse(List<String> tokens) {
        return tokens.stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }

    private static List<Integer> validate(List<Integer> numbers) {
        try {
            return (numbers.stream()
                    .map(x -> x < 0)
                    .reduce(false, (x, y) -> x | y))
                    ? Arrays.asList()
                    : numbers;
        } catch (NumberFormatException e) {
            return Arrays.asList();
        }
    }
}