class Solution {
    public int singleNumber(int[] nums) {
        int target=nums[0];
        for(int i=1;i<nums.length;i++){
              target=target^nums[i];
        }
        return target;
    }

}
