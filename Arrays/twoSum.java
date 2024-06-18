//brute force ; time complexity O(n2)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
             for(int j=i+1;j<nums.length;j++){
                 if(nums[i]+nums[j]==target){
                    return new int[] {i,j }; 
                 }
        }
    }
    return new int[] {0,0 }; 
    }}



//optimal solution time /space complexity o(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for(int i=0;i<nums.length;i++){
        
        if(map.containsKey(target-nums[i])){
            return new int[]{i,map.get(target-nums[i])};
        }
        map.put(nums[i],i);

      }

    return new int[] {0,0 }; 
    }}
