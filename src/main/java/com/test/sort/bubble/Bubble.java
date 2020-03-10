package com.test.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 * 原理：比较两个相邻的元素，将值大的元素交换到右边
 * @author xiaopeng
 *
 */
public class Bubble {

	public static void main(String[] args) {
		
		int arr[] ={2,5,1,3,8,5,7,4,3};
		sort(arr);

	}
	
	public static void sort(int arr[]){
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				//两数据交换
				if(arr[j+1]<arr[j]){
					arr[j+1] = arr[j+1] ^ arr[j];
					arr[j] = arr[j+1] ^ arr[j];
					arr[j+1] = arr[j+1] ^ arr[j];
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
