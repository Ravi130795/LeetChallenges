Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3673/


/**---------Approach-1
let map = new Map();
let url = "http://tinyurl.com/";
var encode = function(longUrl) {
    let key = Date.now().toString();
    map.set(key,longUrl);
    return url + key;
};


var decode = function(shortUrl) {
    let key = shortUrl.split(url);
    return map.get(key[1]); 
};
*/

/**
 * Your functions will be called as such:
 * decode(encode(url));
 */


//------------------------Approach-2------------//
let map={}
var encode = function(longUrl) {
    let ret;

    do {
        ret = Math.random().toString(32).slice(5); // 5 char random string
    } while (map[ret]); // make sure no collisions

    map[ret] = longUrl;

    return 'http://tinyurl.com/' + ret;
};

var decode = function(shortUrl) {
    return map[shortUrl.split('com/')[1]];
};
