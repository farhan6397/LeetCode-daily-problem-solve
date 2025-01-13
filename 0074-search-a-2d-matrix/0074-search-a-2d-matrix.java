class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m<0){
            return false;
        }
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
       

        while(low <= high){

            int midIdx = low + (high-low)/2;
            int midElement = matrix[midIdx/n][midIdx%n];

            if(midElement == target){
              return true;
            }
            else if(midElement < target){
              low = midIdx+1;
            }
            else if(midElement > target) {
              high = midIdx-1;
            }
        }
        return false;
    }
}