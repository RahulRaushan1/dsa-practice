class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0;
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i] + nums[i-1];
        }
        totalSum=nums[nums.length-1];
        if(totalSum-nums[0]==0){
            return 0;
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==(totalSum-nums[i])){
                return i;
            }
           
        }
        return -1;
    }
}