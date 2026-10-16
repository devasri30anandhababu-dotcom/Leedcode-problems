class Solution {
    public int findNthDigit(int n){

        long digitlength = 1;
        int start = 1;
        int end = 9;

        while(n > digitlength*end){
            n -= digitlength*end;
            digitlength++;
            start*=10;
            end*=10;
        }

        start += (n-1)/digitlength;
        String number = String.valueOf(start); 

        int index = (int) ((n - 1) % digitlength); 
        return number.charAt(index) - '0';
    
    }
}
