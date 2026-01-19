import java.util.Stack;
class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            // now check in stack is prev char > cur char se so poll prev ko
            while(k!=0 && st.size()>0 && st.peek()>cur){
                // poll it no need
                st.pop();
                k--;
            }
            // add cur char
            st.push(cur);
        }
            // what if u have sorted no. 123456 then u will end up no poll
            // but we have to remove k largest 
            // in this case i know if it will be sorted then largest to top pe hi hoga
            while(k>0 && st.size()>0){
                st.pop();
                k--;
            }
            // now iterate on the stack store ur ans in string
            StringBuilder ans=new StringBuilder();
            for(char ch:st){
                ans.append(ch);
            }
            // what if leading zeros present hoga
            int idx=0;
            while(idx<ans.length() && ans.charAt(idx)=='0'){
                idx++;
            }
            // what if pura hi leading zero ?
            // idx==ans.length ho jayega in such case return 0;
            if(idx==ans.length()){
                return "0";
            }
            return ans.substring(idx); // ending idx nhi dale by default length tak return karega
        }
    }
