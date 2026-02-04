import java.util.*;
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        // greedy 
        int i=0;
        int j=0;
        int ans=0;
        int l=left.length;
        int m=right.length;
        // Left ants fall at 0 → time = position ,Right ants fall at n → time = n - position
        // Last ant = maximum time
//         “Two loops are clearer and equally optimal.
// Single loop is possible but reduces readability slightly.”
        while(i<l){
            ans=Math.max(left[i],ans);
            i++;
        }
        while(j<m){
            ans=Math.max(n-right[j],ans);
            j++;
        }
        return ans;
    }
}
