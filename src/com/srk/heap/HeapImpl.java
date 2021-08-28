package com.srk.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapImpl {

	public static void main(String[] args) {
		
		int[] arr = {-4,4,6,7,8,9,-9,10,0,14,6};
		
		constructMaxHeap(arr);
		
		System.out.println(Arrays.toString(arr));
		
		constructMinHeap(arr);
		
		System.out.println(Arrays.toString(arr));
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
	}

	private static void constructMinHeap(int[] arr) {
		for(int i = ((arr.length-1)/2); i>=0; i--) {
			minheapify(i, arr, arr.length);
		}
	}

	private static void minheapify(int index, int[] arr, int length) {
		int small = index;
		
		while(small < length/2) {
			
			int left = index * 2 +1;
			int right = index * 2 +2;
			
			if(left < length && arr[left] < arr[index]) {
				small = left;
			}
			
			if(right < length && arr[right] < arr[small]) {
				small = right;
			}
			
			if(index != small) {
				swap(arr, index, small);
				index = small;
			} else {
				break;
			}
			
		}
		
	}

	private static void constructMaxHeap(int[] arr) {
		
		for(int i = ((arr.length-1)/2); i>=0; i--) {
			maxheapify(i, arr, arr.length);
		}
		
	}

	private static void maxheapify(int index, int[] arr, int length) {
		int largest = index;
		
		while(largest<length/2) {
			
			int left = (index*2) +1;
			int right = (index*2) +2;
			
			if(left < length && arr[left] > arr[index])
				largest = left;
			
			if(right < length && arr[right] > arr[largest])
				largest = right;
			
			if(largest == index)
				break;
			else {
				swap(arr, index, largest);
				index = largest;
			}
		}
	
		
	}

	private static void swap(int[] arr, int index, int child) {
		int temp = arr[child];
		arr[child] = arr[index];
		arr[index] = temp;
	}

}
