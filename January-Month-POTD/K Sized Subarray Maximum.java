class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        
        // Sliding window pointers
        int i = 0;
        int j = 0;
        
        int n = arr.length;
        
        // This variable stores the current maximum of the window
        // NOTE: This approach is not optimal because when max goes out,
        // we have to recompute it again (O(k) work).
        int curMax = Integer.MIN_VALUE;

        // List to store answers (max of each window)
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (j < n) {
            
            // Step 1: Include the current element into the window
            // and update the current maximum
            curMax = Math.max(arr[j], curMax);
            
            // Step 2: If window size is not yet equal to k,
            // just expand the window
            if (j - i + 1 < k) {
                j++;
            }
            
            // Step 3: When window size becomes exactly k
            else if (j - i + 1 == k) {
                
                // Store the current maximum for this window
                ans.add(curMax);
                
                // Step 4: Before sliding the window,
                // check if the outgoing element (arr[i]) was the maximum
                if (curMax == arr[i]) {
                    
                    // If yes, we must recompute the max
                    // from the remaining elements of the window
                    curMax = Integer.MIN_VALUE;
                    for (int x = i + 1; x <= j; x++) {
                        curMax = Math.max(curMax, arr[x]);
                    }
                }
                
                // Step 5: Slide the window
                i++;
                j++;
            }
        }
        
        return ans;
    }
}
