/////////////////////
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

//////////////////////



Solution :

class Solution {

    int[] accumulatedSum;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        accumulatedSum = new int[w.length];
        int currSum = 0;
        for (int i = 0; i < w.length; i++) {
            currSum += w[i];
            accumulatedSum[i] = currSum;
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(accumulatedSum[accumulatedSum.length - 1]) + 1;
        return binarySearch(accumulatedSum, 0, accumulatedSum.length - 1, target);
    }
    
    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
