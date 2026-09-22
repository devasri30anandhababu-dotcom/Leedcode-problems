class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[]row:matrix){
            if(binarySearch(row,target))return true;
        }
        return false;
    }
    public boolean binarySearch(int[]arr,int target){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)return true;
            else if(arr[mid]<target)start=mid+1;
            else end=mid-1;
        }
        return false;
    }
}
