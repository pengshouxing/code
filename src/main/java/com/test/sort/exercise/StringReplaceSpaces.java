package com.test.sort.exercise;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * 
 *  输入："Mr John Smith    ", 13
          输出："Mr%20John%20Smith"
          
          输入："               ", 5
          输出："%20%20%20%20%20"     
 * 
 *  解决思路:遍历字符串,遍历长度为输入的length，找到空格就替换为%20。
 *
 */
public class StringReplaceSpaces {

	public static void main(String[] args) {
		
		System.out.println(new StringReplaceSpaces().replaceSpaces("Mr John Smith    ", 14));
		System.out.println(new StringReplaceSpaces().replaceSpaces("               ", 5));

	}
	
	public String replaceSpaces(String S, int length) {
		StringBuilder sb = new StringBuilder();
		char[] cs = S.toCharArray();
		for (int i = 0; i < length; i++) {
			if(cs[i] == ' '){
				sb.append("%20");
			}else{
				sb.append(cs[i]);
			}
		}
		return sb.toString();
    }

}
