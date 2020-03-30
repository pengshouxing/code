package com.test.sort.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个算法，确定一个字符串 s的所有字符是否全都不同。
 * 输入: s = "leetcode"
        输出: false 
        
        输入: s = "abc"
        输出: true  
        
        解决思路:建立一个map,把字符串转成字符数组,再把每个字符存入map中,相同的则替换掉,不相同则放入map中
                最后拿map的size和字符数组的长度判断即可,相等说明字符串是全都不同,不相等说明字符串中有相同的.
 *
 */
public class StringIsUnique {

	public static void main(String[] args) {
		
		System.out.println(new StringIsUnique().isUnique("leetcode"));
		System.out.println(new StringIsUnique().isUnique("abc"));

	}
	
	public boolean isUnique(String astr) {
         Map<Character,Integer> map = new HashMap<>();
         char[] cs = astr.toCharArray();
         for (int i = 0; i < cs.length; i++) {
			map.put(cs[i], 1);
		}
        if(cs.length == map.size()){
        	return true;
        }
        return false;
    }

}
