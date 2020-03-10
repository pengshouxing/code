package com.test.sort.quick;

import java.util.Arrays;


/**
 * 快速排序基本思想:
 * 1.先选出一个数作为基准(选择第一位)。
 * 2.从右边开始找到比基准数字小的,和row位置的数据进行交换,此时位置为high
 * 3.从左边开始找到比基准数字大的,和high位置的数据进行交换,此时位置为row
 * 4.循环2和3的步骤。如果没有找到满足条件的则不交换。
 * 5.当row==high的时候，需要将数组分成两半，左半区(left,high) ,右半区(high+1,right)
 * 左半区为什么是left和high:(1,2,4) 此时high为0,为什么是left是因为有可能右半区(9,8,10,6)要分成两半也包括左半区，所以要从left开始
 * 右半区为什么是right:因为有可能左半区(1, 2, 4, 6)要分成两半也包括右半区,所以到尾是right而不是length-1。
 * 
 * @author xiaopeng
 *
 */
public class Quick {

	public static void main(String[] args) {

		int arr[] = { 6, 2, 6, 8,6,9, 4, 1, 10, 6 };
		sort(arr, 0, arr.length - 1);
	}

	// 从到大排序
	public static void sort(int arr[], int left, int right) {
		if (left >= right) {
			return;
		}
		int key, high = right, row = left;
		// 取第一数字作为作为基准
		key = arr[left];
		while (high != row) {
			// 从右边开始找到比基准小的数字,找到了和最左边的数字交换
			while (arr[high] >= key && high > row) {
				high--;
			}
			if(high>row){
				// 交换数据
				arr[row] = arr[row] ^ arr[high];
				arr[high] = arr[row] ^ arr[high];
				arr[row] = arr[row] ^ arr[high];
			}
			// 从左边开始找到比基准大的数字,找到了和此时右边的位置进行交换
			while (arr[row] <= key && high > row) {
				row++;
			}
			if (high > row) {
				// 交换数据
				arr[row] = arr[row] ^ arr[high];
				arr[high] = arr[row] ^ arr[high];
				arr[row] = arr[row] ^ arr[high];
			}

		}
		// 左半区
		sort(arr, left, row);
		// 右半区
		sort(arr, row+1, right);
		System.out.println(Arrays.toString(arr));
	}

}
