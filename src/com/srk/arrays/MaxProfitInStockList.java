package com.srk.arrays;

public class MaxProfitInStockList {

	public static void main(String[] args) {
		sellOnce();
		sellMultipleTimes();
		sellOnlyTwice();
	}

	private static void sellOnlyTwice() {
		int prices[] = {3,3,5,0,0,3,1,4};
		
		int fb = Integer.MAX_VALUE;
    int sb = Integer.MAX_VALUE;
    int fs = 0;
    int ss = 0;
    
    for(int i = 0; i<prices.length; i++) {
        fb = Math.min(fb, prices[i]);
        fs = Math.max(fs, prices[i] - fb);
        sb = Math.min(sb, prices[i] - fs);
        ss = Math.max(ss, prices[i] - sb);
    }
		
		System.out.println(ss);
	}

	private static void sellMultipleTimes() {
		int prices[] = {7,1,5,3,6,4};
		int vally = prices[0];
		int peak = prices[0];
		int i = 0;
		int maxProfit = 0;
		while(i<prices.length-1) {
			
			while(i<prices.length-1 && prices[i+1]<=prices[i]) {
				i++;
			}
			vally = prices[i];
			
			while(i<prices.length-1 && prices[i+1]>= prices[i]) {
				i++;
			}
			peak = prices[i];
			
			maxProfit += peak - vally;
			
		}
		
		System.out.println(maxProfit);
		
	}

	private static void sellOnce() {
		int arr[] = {7,1,4,7,6,3};
		
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i] < min)
				min = arr[i];
			else if(arr[i]-min>maxProfit) {
				maxProfit = arr[i]-min;
			}
		}
		System.out.println(maxProfit);
	}

}
