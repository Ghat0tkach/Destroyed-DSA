import java.util.*;

public class LongestSubarrayWithSumK {
    public static int longestSubarrayWithSumKforPositive(int[] arr, int k) {
        int start = 0, end = 0, currentSum = 0, maxLength = 0;
        
        // Traverse the array
        while (end < arr.length) {
            // Add the current element to the currentSum
            currentSum += arr[end];
            
            // While currentSum is greater than k, shrink the window from the left
            while (currentSum > k && start <= end) {
                currentSum -= arr[start];
                start++;
            }
            
            // Check if the currentSum is equal to k
            if (currentSum == k) {
                // Update maxLength if we found a larger window
                maxLength = Math.max(maxLength, end - start + 1);
            }
            
            // Move the end pointer to the right
            end++;
        }
        
        return maxLength;
    }

  //for both negatives and positives
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        // HashMap to store the cumulative sum and the corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            // If currentSum is equal to k, update maxLength
            if (currentSum == k) {
                maxLength = i + 1;
            }
            
            // If (currentSum - k) is found in the map, update maxLength
            if (map.containsKey(currentSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(currentSum - k));
            }
            
            // Store the currentSum in the map if it's not already there
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 1, 2};
        int k = 5;
        System.out.println("The length of the longest subarray with sum " + k + " is: " + longestSubarrayWithSumK(arr, k));
    }
}
