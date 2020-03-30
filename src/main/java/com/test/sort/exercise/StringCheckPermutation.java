package com.test.sort.exercise;

/**
 * 
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 输入: s1 = "abc", s2 = "bca"
        输出: true 
        
       输入: s1 = "abc", s2 = "bad"
       输出: false
       
        解决思路:采用异或的思想解决。如果同长度的字符串,内容相同对两者所有的字符采用异或处理结果会是0。
 */
public class StringCheckPermutation {

	public static void main(String[] args) {

		StringCheckPermutation stringCheckPermutation = new StringCheckPermutation();
		System.out.println(stringCheckPermutation.checkPermutation("abcc", "abca"));
		System.out.println(stringCheckPermutation.checkPermutation("abcc", "abcc0"));
		System.out.println(stringCheckPermutation.checkPermutation("abc", "bad"));
		System.out.println(stringCheckPermutation.checkPermutation("asvnpzurz", "urzsapzvn"));
	}

	public boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		int result = 0;
		for (int i = 0; i < cs1.length; i++) {
			result = result ^ cs1[i] ^ cs2[i];
		}
		return result == 0;
	}
}
