package com.test.sort.exercise;

import java.util.Arrays;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
 * 请你设计一种算法，将图像旋转 90 度。不占用额外内存空间能否做到？
 * 
 * 示例 1:
        给定 matrix = [[1,2,3],[4,5,6],[7,8,9]],
        原地旋转输入矩阵，使其变为:[[7,4,1],[8,5,2],[9,6,3]]
   
       示例 2:
   给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

解决思路:所有的数据以对角线(5,4,6,16)数据互换，然后每行沿着中心互换数据。
                  
       举例:15数字沿着对角线就是11位置,15和11互换位置。然后15数字的位置沿着该行中心
                 就是和5互换位置，这样就是相当于旋转了90度。

 * @author xiaopeng
 *
 */
public class IntRotate {

	public static void main(String[] args) {

		int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
		new IntRotate().rotate(arr);
		
		int arr2[][]= {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		new IntRotate().rotate(arr2);
	}
	
	public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = i+1; j < matrix[i].length; j++) {
        		matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        		matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        		matrix[i][j] = matrix[i][j] ^ matrix[j][i];
			}
        	//每一行进行以中心翻转
        	for (int j = 0; j < matrix[i].length/2; j++) {
        		matrix[i][j] = matrix[i][j] ^ matrix[i][matrix[i].length-1-j];
        		matrix[i][matrix[i].length-1-j] = matrix[i][j] ^ matrix[i][matrix[i].length-1-j];
        		matrix[i][j] = matrix[i][j] ^ matrix[i][matrix[i].length-1-j];
			}
		}
        for (int i = 0; i < matrix.length; i++) {
        	System.out.println(Arrays.toString(matrix[i]));
		}
    }

}
