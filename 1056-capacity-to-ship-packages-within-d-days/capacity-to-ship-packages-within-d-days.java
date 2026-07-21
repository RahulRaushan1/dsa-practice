class Solution {
    private int dayNeeded(int[] weights, int capacity){
         int days=1;
         int currentLoad=0;
         for(int ele : weights){
            if(currentLoad+ele > capacity){
                days++;
                currentLoad =0;
            }
            currentLoad += ele;
         }
         return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        int high=0;
        for(int ele : weights){
            low= Math.max(low,ele);
            high += ele;
        }


        while(low<high){
            int mid = low + (high-low)/2;
            if(dayNeeded(weights,mid) <= days){
                high=mid;
            }
            else{
                low=mid + 1;
            }
           
        }
        return low;
    }
   
}