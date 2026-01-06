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
