import java.util.*;

class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        // Step 1: Build intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int start = Math.max(0, i - arr[i]);
                int end = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{start, end});
            }
        }

        // Step 2: Sort by start
        intervals.sort((a, b) -> a[0] - b[0]);

        int count = 0;
        int i = 0;
        int coveredTill = 0;

        // Step 3: Greedy cover
        while (coveredTill < n) {
            int farthest = coveredTill;

            while (i < intervals.size() && intervals.get(i)[0] <= coveredTill) {
                farthest = Math.max(farthest, intervals.get(i)[1] + 1);
                i++;
            }

            if (farthest == coveredTill) {
                return -1; // cannot extend
            }

            count++;
            coveredTill = farthest;
        }

        return count;
    }
}
