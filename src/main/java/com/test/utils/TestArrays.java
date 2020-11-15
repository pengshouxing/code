package com.test.utils;

import java.util.ArrayList;
import java.util.List;

public class TestArrays {
	
	public static <T> void main(String[] args) {
		WordUtils wordUtils = new WordUtils();
		ArrayList<T> as = new ArrayList<T>();
//		as.add();
		wordUtils.setList(as);
		
		List<String> list = wordUtils.getList();
		for (String string : list) {
		System.out.println(string);	
		}
		
	}

}
