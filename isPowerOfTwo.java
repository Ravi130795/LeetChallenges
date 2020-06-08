class Solution {
    public boolean isPowerOfTwo(int n) {
        //return n>0 && n==Math.pow(2, Math.round(Math.log(n)/Math.log(2)));
        long i=1;
        while(i<n){
            i*=2;
        }
        return i==n;
    }
}
