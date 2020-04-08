package com.test.sort.exercise;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * 
 * 输入："aabcccccaaa" 输出："a2b1c5a3"
 * 
 * 输入："abbccd" 输出："abbccd" 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 
 * 解决思路:记录一下上个字符和连续次数。如果出现不同的字符,就把上个字符和次数添加到字符串中，遍历最后一个
 *        字符时要把最后一个字符和次数也要添加到字符串中。最后拿原来字符串长度和新的字符串长度比较。
 * 
 * @author xiaopeng
 *
 */
public class StringCompressString {

	public static void main(String[] args) {

		System.out.println(new StringCompressString().compressString("aabcccccaaa"));
		System.out.println(new StringCompressString().compressString("abbccd"));
		System.out.println(new StringCompressString().compressString("abccd"));
		System.out.println(new StringCompressString().compressString(""));
	}

	public String compressString(String S) {
		if ("".equals(S)) {
			return S;
		}
		StringBuilder sb = new StringBuilder();
		char[] cs = S.toCharArray();
		char preChar = cs[0];
		int num = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] != preChar) {
				sb.append(preChar);
				sb.append(num);
				num = 1;
				preChar = cs[i];
			} else {
				num++;
			}
			if (i == S.length() - 1) {
				sb.append(preChar);
				sb.append(num);
			}
		}
		return sb.length() >= S.length() ? S : sb.toString();
	}

}
