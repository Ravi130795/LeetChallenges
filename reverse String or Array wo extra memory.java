class Solution {
    public void reverseString(char[] arr) {
        reverse(arr,0,arr.length-1);
    }
    
    
    char[] reverse(char[] arr,int start ,int end){
         char temp; 
        
        if (start >= end) 
            return arr; 
        temp = arr[start]; 
        arr[start] = arr[end]; 
        arr[end] = temp; 
        return reverse(arr, start+1, end-1); 
    }
}
