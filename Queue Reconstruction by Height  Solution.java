/***
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

***/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
    int[][] result = new int[people.length][];
    
    //sort the array based on decreasing h and increasing k
    Arrays.sort(people, new Comparator<int[]>(){
        public int compare(int[] a1, int[] a2){
            if(a1[0]!=a2[0]){
                return a2[0]-a1[0];
            }else{
                return a1[1]-a2[1];
            }
        }
    });
 
    ArrayList<int[]> list = new ArrayList<int[]>();
 //add the persons to list to the index k 
    for(int i=0; i<people.length; i++){
        int[] arr = people[i];
        list.add(arr[1],arr);
    }
 //form result aray
    for(int i=0; i<people.length; i++){
        result[i]=list.get(i);
    }
 
    return result;
}
}
