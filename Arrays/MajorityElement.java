// O(n) space and time complexity
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
            
            if(map.get(nums[i])>nums.length/2) return nums[i];


        }
        return -1;
    }
}

//optimal bayer moore voting algorithm

public class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        // Phase 1: Find a candidate for majority element
        int candidate = findCandidate(nums);
        
        // Phase 2: Verify that the candidate is the majority element
        if (isMajority(nums, candidate)) {
            return candidate;
        } else {
            // This line is redundant for problems guaranteeing a majority element.
            // It's here for safety and completeness.
            return -1; 
        }
    }

    private static int findCandidate(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    private static boolean isMajority(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("The majority element is: " + findMajorityElement(nums));
    }
}
