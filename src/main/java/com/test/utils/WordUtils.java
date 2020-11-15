package com.test.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordUtils {
	
	private List<String> list ;
	
	

	public List<String> getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}


	public WordUtils() {
		list = new ArrayList<String>();
		list = Arrays.asList("1","2");
		
	}

	public static <T> void main(String[] args) throws IOException {
		
		/*
		 * ArrayList list2 = (ArrayList) Arrays.asList("1","2");
		 * System.out.println(list2);
		 */
		
		List list = new ArrayList();
		list.add("1");
		list.add(0);
		System.out.println(list.get(0).getClass());
		System.out.println(list.get(1).getClass());
		
		List<Sex> sex = list;
		System.out.println(Sex.WOMEN.getClass());
		for (Sex sex2 : sex) {
			
		}
	}

}
