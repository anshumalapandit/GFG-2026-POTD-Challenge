class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int freq[]=new int[26];
        Queue<Character> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            // add freq of it
            freq[s.charAt(i)-'a']++;
            // now add this to queue
            q.add(s.charAt(i));
            // now jab tak queue k peek pe bhi same element hai poll karte rho jab tak diff ele nhi 
            while(q.size()>0 && freq[q.peek()-'a']>1){
                q.poll();
            }
            // what is sare same char honge to sab poll ho jayenge , no non repeating so add #
            if(q.size()==0){
              sb.append("#");   
            }else{
                sb.append(q.peek()); // jo q k peek pe hoga first non repeating char wahi ans 
            }
        }
        return sb.toString();
    }
}
