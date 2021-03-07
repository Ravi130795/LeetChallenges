You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
-----------------------------------------
  /**
 * @param {number[]} nums
 * @return {number[]}
 */
// var findErrorNums = function(nums) {
//     const result=[];
//     nums.sort((a,b)=>a-b)
//     const len=nums.length
//     let sum=0;
    
//     for(let i=0;i<len;i++){
//         sum+=nums[i];
//         if(nums[i]==nums[i+1]){
//             result.push(nums[i]);
//             sum-=nums[i]
            
//         }
//     }
//     result.push((len*(len+1)/2)-sum)
//     return result;
// };

var findErrorNums = function(nums) {
    let arr=Array(nums.length).fill(0);
    const res=[];
    for(let i in nums){
        arr[nums[i]-1]++
    }
    
    for(let i in arr){
        if(arr[i]>1) res[0]=+i+1;
        else if(arr[i]==0) res[1]=+i+1;
    }
    
    return res;
    
    
}
