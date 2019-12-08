package ru.geekbrains.java_one.homework_b;

public class LessonArray {
	public static void main(String[] args){
		// задание 1
		int [] ppp = {1, 0, 0, 0, 0, 1};
		invertArray(ppp);
		// задание 2
		int [] pppp = new int [8];
		fillArray(pppp);
		// задание 3
		int[] ar3 = {1,5,3,2,11,4,5,2,4,8,9,1};
		multArray(ar3);
		// задание 4
		max(ar3);
		min(ar3);
		// задание 5
		int [][] ppppp = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		quadrate(ppppp);
		// задание 6-8 к следующему уроку
	}

	private static void invertArray(int[] array){
		for (int i = 0; i < array.length; i++){
			switch (array[i]){
				case 1: array[i] = 0;
					break;
				case 0: array[i] = 1;
					break;
				default: System.out.println("Wrong value");
			}
		}
	}

	private static void fillArray(int[] emptyArray) {
		int j = 1;
		for (int i = 0; i < 8; i++) {
			emptyArray[i]=j;
			j=j+3;
		}
	}

	private static void multArray(int[] arrayValue){
		for (int i = 0; i < arrayValue.length; i++){
			if (arrayValue[i] < 6){
				arrayValue[i]=arrayValue[i]*2;
			}
		}
	}

	private static int max(int[] array){
		int maxCurrent = array[0];
		for (int i = 1; i < array.length; i++){
			if(array[i] > maxCurrent){
				maxCurrent =array[i];
			}
		}
		return maxCurrent;
	}

	private static int min(int[] array){
		int minCurrent = array[0];
		for (int i = 1; i < array.length; i++){
			if(array[i] < minCurrent){
				minCurrent =array[i];
			}
		}
		return minCurrent;
	}

	private static void quadrate(int[][] array){
		for (int i = 0; i < array.length; i++){
			array[i][i]=1;
			array[i][array.length-i-1]=1;
		}
	}
}

