package com.srk.arrays;

import java.util.Arrays;

public class MergeSort {

	private static void merge(int Arr[], int start, int mid, int end) {

		// create a temp array
		int temp[] = new int[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start, j = mid+1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(Arr[i] <= Arr[j]) {
				temp[k] = Arr[i];
				k += 1; i += 1;
			}
			else {
				temp[k] = Arr[j];
				k += 1; j += 1;
			}
		}

		// add elements left in the first interval 
		while(i <= mid) {
			temp[k] = Arr[i];
			k += 1; i += 1;
		}

		// add elements left in the second interval 
		while(j <= end) {
			temp[k] = Arr[j];
			k += 1; j += 1;
		}

		// copy temp to original interval
		for(i = start; i <= end; i += 1) {
			Arr[i] = temp[i - start];
		}
	}

	public static void binarySearch(int arr[], int first, int last, int key){  
		int mid = (first + last)/2;  
		while( first <= last ){  
			int midVal = arr[mid];
			System.out.println(midVal);
			if ( midVal < key ){  
				first = mid + 1;     
			}else if ( midVal == key ){  
				System.out.println("Element is found at index: " + mid);  
				break;  
			}else{  
				last = mid - 1;  
			}  
			mid = (first + last)/2;  
		}  
		if ( first > last ){  
			System.out.println("Element is not found!");  
		}  
	}  

	// Arr is an array of integer type
	// start and end are the starting and ending index of current interval of Arr

	private static void mergeSort(int Arr[], int start, int end) {

		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(Arr, start, mid);
			mergeSort(Arr, mid+1, end);
			merge(Arr, start, mid, end);
			System.out.println(Arrays.toString(Arr));
		}
	}

	public static long minPerimeter(int n)
	{
		int l = (int) Math.sqrt(n);
		int sq = l * l;

		// if n is a perfect square
		if (sq == n) 
			return l * 4;
		else
		{
			// Number of rows 
			long row = n / l; 

			// perimeter of the 
			// rectangular grid 
			long perimeter 
			= 2 * (l + row); 

			// if there are blocks left 
			if (n % l != 0) 
				perimeter += 2;
			return perimeter;
		}
	}

	private static int CalculateApples(int x)
	{
		int result = 0;
		for (int i = -x+1; i <= x-1; i++)
		{
			result += Math.abs(i) + x;
		}

		result = result * 4 + (x+x)*4;

		return result;
	}

	private static int GetMinimalPerimeter(int X)
	{
		int result;

		int cur = 1;
		while (true)
		{
			int num_apples = CalculateApples(cur);
			if (num_apples == X)
			{
				result = 8 * cur;
				return result;
			}

			if (num_apples > X)
			{
				result = 8 * cur;
				break;
			}
			cur *= 2;
		}

		if (cur == 1) return result;

		int left = cur / 2, right = cur;
		while (left <= right)
		{
			int m = left + (right - left) / 2;
			int num_apples = CalculateApples(m);
			if (num_apples == X)
			{
				result = 8 * m;
				return result;
			}
			else if (num_apples > X)
			{
				result = 8 * m;
				right = m - 1;
			}
			else
			{
				left = m + 1;
			}
		}

		return result;
	}


	private static int function(int n, int i) {
		System.out.println(i);
		return (n<3)?n-1:function(n-1,i+1)+function(n-2, i+1);
	}

	public static void main(String[] args) {
		int[] arr = new int[] {15,98,66,24,76,33,19,82,10,50,75,48};
		//binarySearch(arr, 0, 14, 89);
		mergeSort(arr, 0, 11);
		//System.out.println(Arrays.toString(arr));
		//function(5, 0);
		//int n = 3;
		//System.out.println(minPerimeter(n));
		//System.out.println(GetMinimalPerimeter(13));
	}
}
