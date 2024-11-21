import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void findPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        generatePermutations(str, 0, str.length() - 1, permutations);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
    private static void generatePermutations(String str, int left, int right, Set<String> permutations) {
        if (left == right) {
            permutations.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                generatePermutations(str, left + 1, right, permutations);
                str = swap(str, left, i);
            }
        }
    }
    private static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        // Example string
        String str = "ABC";

        System.out.println("All permutations of the string '" + str + "':");
        findPermutations(str);
    }
}