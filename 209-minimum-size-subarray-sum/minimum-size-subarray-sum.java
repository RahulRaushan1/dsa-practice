class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int minSubArrayLen = Integer.MAX_VALUE;
        int currSum = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand the window
            currSum += nums[right];

            // Current window is valid, so record and shrink
            while (currSum >= target) {

                minSubArrayLen = Math.min(
                    minSubArrayLen,
                    right - left + 1
                );

                // Shrink from left
                currSum -= nums[left];
                left++;
            }
        }

        return minSubArrayLen == Integer.MAX_VALUE
                ? 0
                : minSubArrayLen;
    }
}