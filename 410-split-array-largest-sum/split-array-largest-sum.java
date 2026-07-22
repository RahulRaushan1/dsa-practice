class Solution {
    public int splitArray(int[] nums, int k) {
       int low= 0;
       int high=0;
       for(int ele: nums){
        low=Math.max(low,ele);
        high += ele;
       } 

       while(low<high){
        int mid = low + (high-low)/2;
        if(isPossible(nums,k,mid)){
            high=mid;
        }
        else{low= mid+1;}
       }
       return high;
    }
    private boolean isPossible(int[]nums,int k,int mid){
        int n=1;
        int sum=0;
        for(int ele: nums){
            if( sum+ele > mid){
                n++;
                sum=0;
            }
            sum+=ele;
        }
        return n<=k;
    }
}