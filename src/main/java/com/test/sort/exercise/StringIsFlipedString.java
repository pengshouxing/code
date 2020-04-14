package com.test.sort.exercise;

/**
 * 字符串轮转。给定两个字符串s1和s2,请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * 
 * 示例1:
            输入：s1 = "waterbottle", s2 = "erbottlewat"
            输出：True

    示例2:
           输入：s1 = "aa", "aba"
           输出：False
           
   解决思路:翻转就是把前面几个字符放到后面去。
                     所以如果两个翻转后的字符串拼接包含原先字符串，证明就是后者是前者翻转过来的。
 * @author xiaopeng
 *
 */
public class StringIsFlipedString {

	public static void main(String[] args) {
		System.out.println(new StringIsFlipedString().isFlipedString("waterbottle", "erbottlewat"));
		System.out.println(new StringIsFlipedString().isFlipedString("aa", "aba"));
	}

	public boolean isFlipedString(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		s2 += s2;
		return s2.contains(s1);
	}

}
