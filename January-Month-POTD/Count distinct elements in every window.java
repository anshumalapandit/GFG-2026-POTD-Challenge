class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int i=0,j=0;
        ArrayList<Integer> ans=new ArrayList<>();
        // Set<Integer> set=new HashSet<>();
        // here we will not use Set , instead hashmap we will use
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            if(j-i+1!=k){
                j++;
                continue;
            }else{
                ans.add(map.size());
                // remove ith calculation
                // set mai element unordered way se store hote hai how u make sure that 
                // u r removing ith element .
                int ithFreq=map.get(arr[i]);
                if(ithFreq-1==0){
                    map.remove(arr[i]);
                }else{
                    map.put(arr[i],ithFreq-1);
                }
                // slide the window
                i++;
                j++;
            }
        }
        return ans;
    }
}
