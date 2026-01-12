class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
          Set<Integer> set=new HashSet<>();
            for(int j=i;j<arr.length;j++){
                set.add(arr[j]);
                if(set.size()<=k){
                    count++;
                }else{
                    break;
                }
            }

        }
        return count;
    }
}
