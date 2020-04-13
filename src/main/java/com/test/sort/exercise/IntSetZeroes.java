package com.test.sort.exercise;

import java.util.Arrays;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
   示例 1：                                        
           输入：
		[
		  [1,1,1],
		  [1,0,1],
		  [1,1,1]
		]
		输出：
		[
		  [1,0,1],
		  [0,0,0],
		  [1,0,1]
		]
   示例 2：
             输入：
		[
		  [0,1,2,0],
		  [3,4,5,2],
		  [1,3,1,5]
		]
		输出：
		[
		  [0,0,0,0],
		  [0,4,5,0],
		  [0,3,1,0]
		]
		
  解决思路:定义两个一位数组，一个存储行，一个存储列。
                    遍历原来的二位数组,记录元素为0的数组下标行和列，给当前行和列元素置为1。默认为0，说明该行和列不为0
                    再遍历行的数组,给该行下所有的列置为0；
                    再遍历列的数组,给该列下所有的行置为0；
 *
 */
public class IntSetZeroes {

	public static void main(String[] args) {

		int arr[][]= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		new IntSetZeroes().setZeroes(arr);
	}
	
	public void setZeroes(int[][] matrix) {

		//行，默认为0，为1说明该行存在一个元素为0
		int row[] = new int[matrix.length]; 
		//列，默认为0，为1说明该列存在一个元素为0
		int line[] = new int[matrix[0].length]; 
		//记录元素为0的行和列
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					row[i]=1;
					line[j]=1;
				}
			}
		}
		//遍历每行，给每行的列置为0
		for (int i = 0; i < row.length; i++) {
			if(row[i] == 1) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j]=0;
				}
			}
		}
		//遍历每列，给列的行置为0
		for (int i = 0; i < line.length; i++) {
			if(line[i] == 1) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
					
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
    }

}
