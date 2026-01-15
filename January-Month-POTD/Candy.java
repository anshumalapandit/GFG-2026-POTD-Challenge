class Solution {
    public int minCandy(int arr[]) {
        // code here
        int candy[]=new int[arr.length];
        // atleast one candy sare child ko milna chahiye
        // to dedo bhai
        for(int i=0;i<arr.length;i++){
            candy[i]=1;
        }
        // now go left to right if u found any childern have higher ratings ussko ek extra candi dedo
        for(int i=1;i<arr.length;i++){
            // each element ko uske left se compare karenge 
            // if bada nikla ek extra candy de denge
            // 0th element ka koi left nhi hota isiliye 1 se start kiya
            if(arr[i]>arr[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        // now right se compare karenge
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        // now calculate karlo total candies
        int ans=0;
        for(int can:candy){
            ans+=can;
        }
        return ans;
    }
}
