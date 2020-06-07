Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

sol:
class Solution {
    public int change(int amount, int[] coins) {
        //DP solution
        int size = coins.length;
    	int[][] arr = new int[size + 1][amount + 1];
    	
      // 
      // because a sum of 0 can be made
      // in one possible way: {0} not to choose
    	for(int i = 0; i < size + 1; i++)
    		arr[i][0] = 1;
    	
      // Applying the recursive solution:
    	for(int i = 1; i <= size; i++)
    		for(int j = 0; j <=amount; j++)
    			if(coins[i-1] > j)  // copy the previous row value:
    				arr[i][j] = arr[i - 1][j];
    			else  // add the previous row value to current row value (current row= amount-coin value)
    				arr[i][j] = arr[i - 1][j]+arr[i][j - coins[i-1]];
    	
    	return arr[size][amount];
        
    }
    }
