There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000




Solution:

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum=0;
        int countA=0;
        int countB=0;
        int n=costs.length/2;
        
        //As total amount needs to be the least , we need to sort the array ,so that big numbers had not to be counted because of n each limit
        //Comparator<int[]> c =(int[] o1, int[] o2)-> Math.abs(o1[0]-o1[1]) - Math.abs(o2[0]-02[1]);
        
        //Sort
       Arrays.sort(costs, new Comparator<int[]>() {
           
            public int compare(int[] a, int[] b) {
                return Math.abs(b[0]-b[1]) - Math.abs(a[0]-a[1]);
            }
        });
        
        //Greedy Choices
         for(int i=0; i<costs.length; i++) {
            if(countA<n && countB<n){
          if(costs[i][0]<costs[i][1]){
              ++countA;
                 sum=sum+costs[i][0];
          }
                else{
                     ++countB;
                 sum=sum+costs[i][1];
                }
            }
             else if(countA<n){
                 ++countA;
                 sum=sum+costs[i][0];
             }
             else{
                 ++countB;
                 sum=sum+costs[i][1];
             }
        
    }
        return sum;
    }
}
