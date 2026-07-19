class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==0) return false;
        int left=0;
        int right = m*n-1;
        while(left<=right){
            int mid=(left+right)/2;
            int element= matrix[mid/n][mid%n];
            if(target==element){
                return true;
            }
            else if(target>element){
                left= left+1;
            }
            else{
                right=right-1;
            }
        }
        return false;
    }
}