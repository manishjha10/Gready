class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int cnt1 =  event2[0].compareTo(event1[1]); //overlapping condition that must false
        int cnt2 =  event2[1].compareTo(event1[0]);  // non overlapping true

        return cnt1 <= 0 && cnt2 >= 0;
    }
}
