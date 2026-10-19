
class Solution {
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;

        for (int num : nums) {
            if(num == m1 || num == m2 || num == m3){
                continue;
            }
            if(m1 == Long.MIN_VALUE || num > m1){
                m3 = m2;
                m2 = m1;
                m1 = num;
            }
            else if(m2 == Long.MIN_VALUE || num > m2){
                m3 = m2;
                m2 = num;
            }
            else if(m3 == Long.MIN_VALUE || num > m3){
                m3 = num;
            }
        }

        if(m3 == Long.MIN_VALUE){
            return (int) m1;
        }
        return (int) m3;
    }
}
