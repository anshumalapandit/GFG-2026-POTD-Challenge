// brute force:
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int max=0;
        for(int i=0;i<=arr.length-k;i++){
            int xor=0;
            for(int j=i;j<i+k;j++){
                xor^=arr[j];
            }
            max=Math.max(xor,max);
        }
        return max;
    }
}
// optimal - sliding window 
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int max=0;
        int cur=0;
        int i=0,j=0;
        int n=arr.length;
        while(j<n){
            // operation
            cur=cur^arr[j];
            // first achieved window size
            if(j-i+1!=k){
                j++;
                continue;
            }else{
                // ans nikalo
                max=Math.max(max,cur);
                // remove ith calculation from cur
                // i want to remove ith element ka calculation doing xor with curXor will make that part 0.
                cur^=arr[i];
                // now expand the window.
                i++;
                j++;
            }
        }
        return max;
    }
}
