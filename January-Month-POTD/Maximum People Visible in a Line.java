import java.util.Stack;
class Solution {
    public int[] helper2(int arr[]){
        int right[]=new int[arr.length];
        right[arr.length-1]=1; // no smaller on right side of last element
        Stack<Integer> st=new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                st.pop();
            }
            // what if sara ele popped ho gya ? means all were elements are samller
            if(st.isEmpty()){
                right[i]=arr.length-i; // right k sab chote elemts the 
            }else
            right[i]=st.peek()-i; // span store 
            st.push(i);
        }
        return right;
    }
    public int[] helper(int arr[]){
        int left[]=new int[arr.length];
        left[0]=0; // no smaller in left for first elements
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=i; // starting k sare elements chote the
            }else
            left[i]=i-st.peek()-1;
            st.push(i);
        }
        return left;
    }
    public int maxPeople(int[] arr) {
        // code here
        int leftSmaller[]=helper(arr);
        int rightSmaller[]=helper2(arr); // including themselevs
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(leftSmaller[i]+rightSmaller[i],max);
        }
        return max;
    }
}
