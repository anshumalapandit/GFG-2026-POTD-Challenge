class Solution {
    public static void helper(ArrayList<ArrayList<Integer>> ans,int arr[],int mark[], ArrayList<Integer> list){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
       for(int i=0;i<arr.length;i++){
           if(mark[i]==0){
               // choose
               // first mark it
               mark[i]=1;
               list.add(arr[i]);
               helper(ans,arr,mark,list);
               // unmark
               mark[i]=0;
               list.remove(list.size()-1);
           }
       }
        
    }
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        int mark[]=new int[arr.length];
        
        helper(ans,arr,mark,list);
        return ans;
    }
};
