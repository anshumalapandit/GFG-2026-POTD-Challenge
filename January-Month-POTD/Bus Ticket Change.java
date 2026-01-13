class Solution {
    public boolean canServe(int[] arr) {
        int count5 = 0;
        int count10 = 0;
        // no need for 20 bcoz 20 will never need to give the change to customers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                count5++;
            } 
            else if (arr[i] == 10) {
                if (count5 >= 1) {
                    count5--;
                    count10++;
                } else {
                    return false;
                }
            } 
            else { // arr[i] == 20
                if (count10 >= 1 && count5 >= 1) {
                    count10--;
                    count5--;
                } 
                else if (count5 >= 3) {
                    count5 -= 3;
                } 
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
