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
// optimal + list data structure
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.length){
            // j k pehle jitne bhi lesser element = never used =popped
            while(list.size()>0 && list.get(list.size()-1)<arr[j]){
                list.remove(list.size()-1);
            }
            // jese hi remove ho jayega add current jth ele
            list.add(arr[j]);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                // if window size acheieved hai then try to maintain it
                // 1. ans calculate kro calculation mai se
                ans.add(list.get(0));
                // 2. remove calculation b4 sliding the window .
                // slide kese karte i->i++, j->j++
                // ith wala element ko remove karna padega
                // if ith wala present hoga to pehle hi present hoga bcoz we inserted only kaam ka value .
                if(arr[i]==list.get(0)){
                    list.remove(0);
                }
                // slide the window
                i++;
                j++;
            }
        }
        return ans;
    }
}
// optimal + deque data strucrure
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        // ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.length){
            // j k pehle jitne bhi lesser element = never used =popped
            // dq=> i will store only idx , only maximum elements k idx
            while(dq.size()>0 && arr[dq.peekLast()]<arr[j]){
            //We use peekLast() in the while loop because:

// 👉 We want to remove smaller elements that came before the current element
// 👉 Those smaller elements are at the BACK of the deque
// 👉 So we compare with last, not first

                dq.pollLast();
            }
            // jese hi remove ho jayega add current jth ele
            dq.add(j);
            
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                // if window size acheieved hai then try to maintain it
                // 1. ans calculate kro calculation mai se
                ans.add(arr[dq.peekFirst()]); // jo pehle hoga wahi mera ans
                // 2. remove calculation b4 sliding the window .
                // slide kese karte i->i++, j->j++
                // ith wala element ko remove karna padega
                // if ith wala present hoga to pehle hi present hoga bcoz we inserted only kaam ka value .
                if(dq.peekFirst()==i){
                    dq.pollFirst();
                }
                // slide the window
                i++;
                j++;
            }
        }
        return ans;
    }
}
