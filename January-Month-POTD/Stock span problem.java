class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> st = new Stack<>(); // stores indices
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];

            // Jab tak previous price <= current price ho, pop karte raho
            while (st.size() != 0 && arr[st.peek()] <= cur) {
                st.pop();
            }

            int span = 0;

            // Agar stack empty ho gaya
            // Matlab current element se pehle ke saare elements smaller/equal the
            // So span = total elements till now = i + 1 (0-based index)
            if (st.size() == 0) {
                span = i + 1;
            } 
            else {
                // Agar stack empty nahi hai
                // Toh top pe jo index hai wahi previous greater element hai
                // Span = current index - previous greater index
                span = i - st.peek();
            }

            list.add(span);

            // Current index ko stack me push karo
            st.push(i);
        }

        return list;
    }
}
