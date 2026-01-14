// Brute Force
class Solution {
    public int catchThieves(char[] arr, int k) {
        int ans = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') continue; // already used

            for(int j = Math.max(0, i - k); j <= Math.min(arr.length - 1, i + k); j++) {
                // we have to check both side e.g i am police so i will find thief on both left,riht
                //so valid idx for left side => kitna  dur police jaa sakta hai 
                // only k distances hi not much away
                // i-k jaa sakta hai left , i+k right mai jaa sakta hai
                // but if we look constranint k<=1000
                // so to make it valid , if k>n then we should run only till arr.length
                // while in left side we should run only till idx 0,
                //afterwards idx will become -ve , so max idx in left 0. and right mai n.
                if(arr[j] == '1' || i == j) continue;
                // if already used ,caught 
                // khud ko nhi pakad sakta right police or thief
                // so continue
                if(arr[i] == 'P' && arr[j] == 'T') {
                    ans++;
                    arr[j] = '1';
                    arr[i] = '1';
                    break;
                }

                if(arr[i] == 'T' && arr[j] == 'P') {
                    ans++;
                    arr[j] = '1';
                    arr[i] = '1';
                    break;
                }
            }
        }
        return ans;
    }
}
// optimised approach:
class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int p=0; // police ka pointer
        int t=0; // thief ka pointer
        int count=0;
        while(p<arr.length && arr[p]!='P') p++;
        while(t<arr.length && arr[t]!='T') t++;
        // now we will start checking 
        while(p<arr.length && t<arr.length){
            // distance agar <=k hoga tohi police thief ko caught kar sakta hai
            if(Math.abs(p-t)<=k){
                // possible
                count++;
                p++;
                t++;
            }else if(p<t){
                // if police kafi piche ho gya hai thief se police ko aage le jao
                // before doing p++ , must check ki out of bound naa ho jaye
                // lekin tabhi tak leke jana hai tab tak wo police police tak na pahuch
                // jaye same for thief , ++ hoga tab tak next T nhi aa jata
                p++;
            }else if(t<p){
                t++;
            }
            // what if P ka pointer T pe aa gya to
              // move to next valid P and T
              while(p<arr.length && arr[p]!='P') p++;
              while(t<arr.length && arr[t]!='T') t++;
        }
        return count;
    }
}
