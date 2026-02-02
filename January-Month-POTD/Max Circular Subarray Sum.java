class Solution {

    // Kadane for MAX subarray sum
    public int maxKadane(int[] arr) {
        int curSum = arr[0];
        int maxSum = arr[0];
       //Agar sum negative ho gaya → naya start
        for (int i = 1; i < arr.length; i++) {
            // in one line : curSum = Math.max(arr[i], curSum + arr[i]);
            if(curSum<0){
                // start fresh
                curSum=arr[i];
            }else{
                curSum+=arr[i];
            }
            maxSum=Math.max(maxSum,curSum);
        }
        return maxSum;
    }

    // Kadane for MIN subarray sum
    public int minKadane(int[] arr) {
        // opposite of maximum kadane:Agar sum positive ho gaya → naya start
          //kyunki hume chhota (more negative) sum chahiye
        int curSum = arr[0];
        int minSum = arr[0];
        // in one line :   curSum = Math.min(arr[i], curSum + arr[i]);
        for (int i = 1; i < arr.length; i++) {
            if(curSum>0){
                // start fresh
                // remember these condition
                curSum=arr[i];
            }else{
                curSum+=arr[i];
            }
            minSum = Math.min(minSum, curSum);
        }
        return minSum;
    }

    public int maxCircularSum(int[] arr) {
        // step 1 : total sum find karo
        // step 2: kadane algorithm likho for maximum , minimum
        // step 3: if MaxSum<0 its means all no. -ve return maxSum pehle .
        // step 4 : ans=> Max(totalSum-Minsum,maxSum) 
        int totalSum = 0;
        for (int x : arr)
            totalSum += x;

        int maxSum = maxKadane(arr);
        int minSum = minKadane(arr);

        // Edge case: all elements negative
        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}
