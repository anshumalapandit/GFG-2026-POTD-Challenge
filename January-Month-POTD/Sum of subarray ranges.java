class Solution {
    public int subarrayRanges(int[] arr) {
        // code here
        // brute force
        int sum=0; //0+1+2+0+1+0
        for(int i=0;i<arr.length;i++){
            int max=arr[i];
            int min=arr[i];
            for(int j=i;j<arr.length;j++){
                max=Math.max(arr[j],max);
                min=Math.min(arr[j],min);
                int range=max-min;
                sum+=range;
            }
        }
        return sum;
    }
}
