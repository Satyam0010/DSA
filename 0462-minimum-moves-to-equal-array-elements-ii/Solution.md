# Easiest Solution in Java | Use Sorting + Greedy to form the ans

# Intuition
**Core Concept:** The problem requires finding a target integer that minimizes the total absolute distance to all numbers in the array. This is a classic mathematical property: the sum of absolute deviations is minimized at the median of the dataset.

# Approach
	1. Sort the array in ascending order.
	2. Locate the median element at index nums.length / 2.
	3. Iterate through the array and accumulate the absolute difference between each element and the median.


# Complexity
**Time Complexity: O(n log n)**- The dominant operation is sorting the array of size n. The subsequent linear scan takes O(n) time.


**Space Complexity: O(log n)** - Java's Arrays.sort() uses a Dual-Pivot Quicksort for primitive types, which requires O(log n) auxiliary stack space for recursion.

# Code
```java []
class Solution {
    public int minMoves2(int[] nums) {
        int ans = 0;
       Arrays.sort(nums);
       int mid = nums[nums.length/2];
       for(int num : nums){
        ans += Math.abs(mid-num);
       } 
       return ans;
    }
}
```