# Solve - totalSum - (min*length) | Beats 100 % in Time and Space | Best and Easy Solution | JAVA

# Intuition
Instead of physically incrementing n - 1 elements by 1 during each move, we can look at the problem from the opposite perspective. Incrementing n - 1 elements by 1 is mathematically equivalent to decrementing exactly 1 element by 1 relative to the rest.
To make all elements equal, our ultimate goal is to bring every element down to the minimum value in the array. Therefore, the minimum number of moves required is simply the sum of the differences between each element and the minimum element.

# Approach
Let S be the initial sum of the array, n be the length of the array, m be the minimum value, and x be the number of moves.
After x moves, the total sum becomes S + x * (n - 1).
Since all elements become equal to some final value F, the final sum is also equal to n * F.
Because the minimum element must be incremented in every single move to catch up, the final value F will be m + x.
Equating the two forms of the final sum:
S + x * (n - 1) = n * (m + x)
S + xn - x = nm + nx
S - x = nm
x = S - (m * n)
This perfectly matches the code logic: totalSum - (min * nums.length).

# Complexity
**Time Complexity:** O(n)
We iterate through the nums array exactly once to calculate both the totalSum and find the min value.
**Space Complexity:** O(1)
The algorithm runs in constant extra space as we only instantiate two primitive integer variables (totalSum and min).

# Code
```java []
class Solution {
    public int minMoves(int[] nums) {
        int totalSum = 0;
        int min = nums[0];
        for(int num : nums){
            if(num < min) min = num;
            totalSum += num;
        }
        return totalSum - (min*nums.length);
    }
}
```