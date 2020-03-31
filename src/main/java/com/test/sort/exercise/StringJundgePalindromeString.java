package com.test.sort.exercise;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
       回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
       回文串不一定是字典当中的单词。
   
       输入："tactcoa"
       输出：true（排列有"tacocat"、"atcocta"，等等）
 * 
 * 解决思路:回文串最多存在一个字符不同。
 * 定义一个数组,默认所有位置都是0。定义一个数count(判断是否为回文),
 *        如果偶数个数在一个位置,map[c]++ & 1为0,就代表该位置肯定满足回文没有多出来的字符,count就要进行--操作。
 *        如果奇数个数在一个位置,map[c]++ & 1为1,就代表该位置多出来一个字符,count就要++操作。
 *
 */
public class StringJundgePalindromeString {

	public static void main(String[] args) {
		
      System.out.println(new StringJundgePalindromeString().canPermutePalindrome("tactcoa"));       
      System.out.println(new StringJundgePalindromeString().canPermutePalindrome("1111"));       
      System.out.println(new StringJundgePalindromeString().canPermutePalindrome("code"));       
	}
	
	public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
        	//map[char]会把char进行int转换的,找到对应的位置
            if ((map[c]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

}
