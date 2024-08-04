import java.util.Arrays; // Import Arrays class for sorting

class Solution {
  
    // This method calculates the sum of values within a given range of subarray sums from nums array
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Calculate the total number of subarray sums
        int totalSubarrays = n * (n + 1) / 2;
        // Initialize an array to store all possible subarray sums
        int[] subarraySums = new int[totalSubarrays];
      
        int index = 0; // Index to insert the next sum into subarraySums
        // Loop over nums array to define starting point of subarray
        for (int i = 0; i < n; ++i) {
            int currentSum = 0; // Holds the temporary sum of the current subarray
            // Loop over nums array to create subarrays starting at index i
            for (int j = i; j < n; ++j) {
                currentSum += nums[j]; // Add the current number to the current subarray sum
                subarraySums[index++] = currentSum; // Store the current subarray sum and increment index
            }
        }
      
        // Sort the array of subarray sums
        Arrays.sort(subarraySums);
      
        int result = 0; // Initialize the result to 0
        final int mod = (int) 1e9 + 7; // Modulo value to prevent integer overflow
        // Add the values from position "left" to "right" in the sorted subarray sums
        for (int i = left - 1; i < right; ++i) {
            result = (result + subarraySums[i]) % mod;
        }
      
        return result; // Return the computed sum
    }
}