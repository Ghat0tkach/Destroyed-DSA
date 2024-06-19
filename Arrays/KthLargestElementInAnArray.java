//brute force : time complexity O(n log n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length=nums.length;
        Arrays.sort(nums);
        return nums[length-k];
    }
}

//optimal solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
