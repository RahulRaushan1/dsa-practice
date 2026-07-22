class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
      int low = bloomDay[0];
      int high = bloomDay[0];
        int n = bloomDay.length;
        if((long)m*k>n) return -1;

        for(int ele : bloomDay){
            low=Math.min (low,ele);
            high = Math.max(high,ele);
        }
        
        while(low<high){
            int mid = low + (high-low)/2;
            if( isPossible(bloomDay,m,k,mid)){
                high=mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
 
    }
    private boolean isPossible(int []bloomDay,int m,int k, int mid){
        int flowers =0;
        int bouquets=0;

        for(int ele: bloomDay){
          if( ele <= mid ){
             flowers++;

             if(flowers==k){
                bouquets++;
                flowers=0;
             }
            
          }else{
            flowers=0;
          }

        }
        return bouquets >=m;
    }
}