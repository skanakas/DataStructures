package com.srk.algos;

import java.util.Arrays;

public class QuickSort {

	private static void sortInc(int[] arr) {
		int left = 0;
		int right = arr.length-1;
		quickSortInc(arr, left, right);
	}

	private static void sortDec(int[] arr) {
		int left = 0;
		int right= arr.length-1;

		quickSortDec(arr, left, right);
	}

	private static void quickSortDec(int[] arr, int left, int right) {
		if(left < right) {
			int pivotIndex = pickPivotForDecSort(arr, left, right);

			quickSortDec(arr, left, pivotIndex-1);
			quickSortDec(arr, pivotIndex+1, right);
		}
	}

	private static int pickPivotForDecSort(int[] arr, int left, int right) {
		int pivot = arr[left];

		int i = right + 1;
		for(int j = right; j > left; j--) {
			if(arr[j]<=pivot) {
				i--;
				swap(arr, i , j);
			}
		}

		swap(arr, i-1, left);

		return i-1;
	}

	private static void quickSortInc(int[] arr, int left, int right) {
		if(left<right) {
			int pivotIndex = pickPivotForIncSort(arr, left, right);

			quickSortInc(arr, left, pivotIndex-1);
			quickSortInc(arr, pivotIndex+1, right);
		}
	}

	private static int pickPivotForIncSort(int[] arr, int left, int right) {

		int pivot = arr[right];

		int i = left - 1;
		for(int j = left; j<right; j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(arr, i , j);
			}
		}

		swap(arr, i+1, right);

		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,6,8,4,3,6,8,4,3};
		System.out.println("Before Sort = "+Arrays.toString(arr));

		sortInc(arr);

		System.out.println("Acs order = "+Arrays.toString(arr));

		arr = new int[] {1,6,8,4,3,6,8,4,3};

		sortDec(arr);

		System.out.println("Desc order = "+Arrays.toString(arr));
	}

}
