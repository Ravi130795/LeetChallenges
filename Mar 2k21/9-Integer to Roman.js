
//-----Greedy for minimum coins.......//

/**
 * @param {number} num
 * @return {string}
 */
// var intToRoman = function(n) {
//     const arr=[1,5,10,50,100,500,1000];
//     let coins=[]
    
//         for(let i=arr.length-1;i>=0;i--){
//             while(n>=arr[i]){
//                 n-=arr[i];
//                 coins.push(arr[i]);
                
//             }
//         }
        
    
//     return coins
    
// };

////-----------Roman to Integer------------------///////////////

// var romanToInt = function(s) {

//     const sym = { 
//         'I': 1,
//         'V': 5,
//         'X': 10,
//         'L': 50,
//         'C': 100,
//         'D': 500,
//         'M': 1000
//     }

//     let result = 0;

//     for (i=0; i < s.length; i++){
//         const cur = sym[s[i]];
//         const next = sym[s[i+1]];

//         if (cur < next){
//             result += next - cur // IV -> 5 - 1 = 4
//             i++
//         } else {
//             result += cur
//         }
//     }

//     return result; 
// };




var intToRoman = function(num) {
let romans = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"];
        let value = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000];
        let idx = romans.length - 1;
        let ans = '';

while(num>0){
            while(value[idx]<=num){
                ans += romans[idx];
                num -= value[idx];
            }
            idx--;
        }
        return ans;
    
}
