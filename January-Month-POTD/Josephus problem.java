class Solution {
    public int josephus(int n, int k) {
        int[] arr = new int[n];   // 0 = alive, -1 = dead
        int alive = n;
        int idx = 0;

        while (alive > 1) {

            // need to reached kth place , k-1 jump u have to do 
            int step = k - 1;
            while (step > 0) {
                idx = (idx + 1) % n;
                if (arr[idx] == 0) {
                    step--;
                }
            }

            // k-1 jump ki now u r at right position ,
            // but what if already eliminated ho person , idx++
            while (arr[idx] == -1) {
                idx = (idx + 1) % n;
            }
            // next element hoga non eleminated wala usko killed 
            arr[idx] = -1; // kill
            alive--;

            // move idx to next alive person
            while (arr[idx] == -1) {
                idx = (idx + 1) % n;
            }
        }

        // return safe position (1-based)
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) return i + 1;
        }
        return -1;
    }
}
