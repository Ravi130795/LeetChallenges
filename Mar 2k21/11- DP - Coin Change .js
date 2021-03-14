https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/

u are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104



--------------------------------

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
**/


// assume that coins is an array of positive integers
// assume that amount is non-negative
var coinChange = function(coins, amount) {
// create an array to hold the minimum number of coins to make each amount
// amount + 1 so that you will have indices from 0 to amount in the array
const minCoins = new Array(amount + 1).fill(Infinity);
// there are 0 ways to make amount 0 with positive coin values
minCoins[0] = 0;
// look at one coin at a time
for(let coin of coins) {
for(let i = 0; i <= amount; i += 1) {
// make sure the difference between the current amount and the current coin is at least 0
// replace the minimum value
if((i - coin) >= 0) minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
}
}
// if the value remains Infinity, it means that no coin combination can make that amount
return minCoins[amount] !== Infinity ? minCoins[amount] : -1;
}
