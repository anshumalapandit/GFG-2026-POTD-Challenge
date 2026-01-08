class Solution {
    public int countSubarrays(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int odd = 0;
        int count = 0;
        int prefixEven = 0;

        while (j < n) {

            // add current element
            if (arr[j] % 2 == 1) {
                odd++;
                prefixEven = 0; // reset
            }

            // shrink window if odd > k
            while (odd > k) {
                if (arr[i] % 2 == 1) odd--;
                i++;
                prefixEven = 0;
            }

            // count subarrays when exactly k odd
            if (odd == k) {
                while (i < n && arr[i] % 2 == 0) {
                    prefixEven++;
                    i++;
                }
                count += prefixEven + 1;
            }

            j++;
        }
        return count;
    }
}
