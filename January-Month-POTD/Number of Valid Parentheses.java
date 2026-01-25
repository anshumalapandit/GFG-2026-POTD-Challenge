import java.util.*;

class Solution {
    int findWays(int n) {
        if (n % 2 != 0) return 0;   // odd length → impossible

        int pairs = n / 2;
        List<String> list = new ArrayList<>();

        backtrack(list, "", 0, 0, pairs);
        return list.size();        // number of valid expressions
    }

    void backtrack(List<String> list, String curr, int open, int close, int max) {

        // base case
        if (curr.length() == 2 * max) {
            list.add(curr);
            return;
        }

        // add '(' if we still can
        if (open < max) {
            backtrack(list, curr + "(", open + 1, close, max);
        }

        // add ')' only if valid
        if (close < open) {
            backtrack(list, curr + ")", open, close + 1, max);
        }
    }
}
