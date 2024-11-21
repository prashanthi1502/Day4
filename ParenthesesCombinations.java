import java.util.ArrayList;
import java.util.List;

public class ParenthesesCombinations {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(result, "", 0, 0, n);
        return result;
    }
    private static void generateCombinations(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generateCombinations(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generateCombinations(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        System.out.println("Combinations of " + n + " pairs of parentheses:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}