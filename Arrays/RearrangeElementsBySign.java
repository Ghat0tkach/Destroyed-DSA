//https://leetcode.com/problems/rearrange-array-elements-by-sign/

//brute force
class Solution {
    public int[] rearrangeArray(int[] nums) {
       List<Integer> positive = new ArrayList<>();
       List<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int[] rearranged = new int[nums.length];
        
       
        int posIndex = 0, negIndex = 0;
        for (int i = 0; i < nums.length; i += 2) {
            rearranged[i] = positive.get(posIndex++);
            rearranged[i + 1] = negative.get(negIndex++);
        }
        
        return rearranged;
    }
}


//optimized solution
public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] rearranged = new int[n];
        int posIndex = 0, negIndex = 1;
        
        for (int num : nums) {
            if (num > 0) {
                rearranged[posIndex] = num;
                posIndex += 2;
            } else {
                rearranged[negIndex] = num;
                negIndex += 2;
            }
        }
        
        return rearranged;
    }
