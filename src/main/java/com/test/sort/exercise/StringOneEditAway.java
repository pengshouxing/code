package com.test.sort.exercise;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串， 
 *                 编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 
 * 输入: first = "pale" second = "ple" 输出: True
 * 
 * 输入: first = "pales" second = "pal" 输出: False
 * 
 * 解决思路:先判断两个字符串长度超过了2就说明不符合,返回false。
 *        如果两者长度相差没有超过2,就有可能相等或者相差1:
 *        如果两者长度相等,如果不同大于1,就不符合,返回false。
 *        如果两者长度不同,此时要么是删除和插入,挨个数字比较,碰到不同的字符,就记录一下,已经有1个不符合,
 *        长度长的那个继续往前遍历循环,长度短的保持该字符位置和长度长的继续往前遍历的字符比较。
 *
 */
public class StringOneEditAway {

	public static void main(String[] args) {
		System.out.println(new StringOneEditAway().oneEditAway(null, null));
		System.out.println(new StringOneEditAway().oneEditAway("pale", "ple"));
		System.out.println(new StringOneEditAway().oneEditAway("pale", "plee"));
		System.out.println(new StringOneEditAway().oneEditAway("pale", "palee"));
		System.out.println(new StringOneEditAway().oneEditAway("pale", "paleee"));
	}

	public boolean oneEditAway(String first, String second) {
		if (first == null || second == null) {
			return false;
		}
		int firstLength = first.length();
		int secondLength = second.length();
		int subLenth = firstLength - secondLength;
		if (subLenth > 1 || subLenth < -1) {
			return false;
		}
		int count = 1;
		for (int i = 0, j = 0; i < firstLength && j < secondLength; i++, j++) {
			if (first.charAt(i) != second.charAt(j)) {
				if (subLenth == 1) {
					j--;
				} else if (subLenth == -1) {
					i--;
				}
				count--;
				if (count <= -1) {
					return false;
				}
			}
		}
		return true;
	}
}
