class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high=0;
        for(int ele: piles){
            high = Math.max(ele,high);
        }
        while(low < high){
            int mid= low + (high-low)/2;
            if( possibleEatingSpeed(piles,mid,h)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean possibleEatingSpeed(int[]piles,int speed , int h){
        int hours=0;
        for(int ele: piles){
            hours+= Math.ceil((double)ele/speed);
        }
        return hours <=h;
    }
}