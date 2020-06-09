//
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.



////





Sol:



//1.recursive approcah

class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS=s.length();
        int lenT=t.length();
        if(lenS==0)
            return true;
        if(lenT==0)
            return false;
        if(s.charAt(lenS-1)==(t.charAt(lenT-1)))
            return isSubsequence(s.substring(0,lenS-1),t.substring(0,lenT-1));
        else
            return isSubsequence(s.substring(0,lenS),t.substring(0,lenT-1));
            
    }
}




//2.one more way  -> bestway
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
        //search for a char staring from right side param i.e index;->maintain the order of chars in string s
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
