package com.srk.airbnb;

import java.util.Arrays;
import java.util.Comparator;

public class RoundTheAmounts {

	public int[] roundUp(double[] prices) {
		int n = prices.length;
		PriceWithDiff[] priceWithDiff = new PriceWithDiff[n];
		double sum = 0.0;
		int floorSum = 0;
		for (int i = 0; i < n; i++) {
			int floor = (int) prices[i];
			int ceil = (int) Math.ceil(prices[i]);
			floorSum += floor;
			sum += prices[i];
			priceWithDiff[i] = new PriceWithDiff(ceil, floor, ceil - prices[i]);
		}

		int target = (int) Math.round(sum);
		int d = target - floorSum;
		Arrays.sort(priceWithDiff, new Comparator<PriceWithDiff>() {
			@Override
			public int compare(PriceWithDiff n1, PriceWithDiff n2) {
				if (n1.diff <= n2.diff) return -1;
				else return 1;
			}
		});

		int[] res = new int[n];
		int i = 0;

		// pick first d ceil values from array
		for (; i < d; i++) {
			res[i] = priceWithDiff[i].ceilPrice; //ceil
		}
		// Now target will be reached just by taking floor prices
		for (; i < n; i++) {
			res[i] = priceWithDiff[i].floorPrice; //floor
		}
		return res;
	}

	class PriceWithDiff {
		int ceilPrice;
		int floorPrice;
		double diff;

		public PriceWithDiff(int ceil, int floor, double c) {
			this.ceilPrice = ceil;
			this.floorPrice = floor;
			this.diff = c;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PriceWithDiff [ceilPrice=").append(ceilPrice).append(", floorPrice=").append(floorPrice)
			.append(", diff=").append(diff).append("]");
			return builder.toString();
		}
	}

	public static void main(String[] args) {
		double [] prices = {0.70, 2.80, 4.90};
		System.out.println("Prices: " + Arrays.toString(prices));
		RoundTheAmounts r = new RoundTheAmounts();
		System.out.println("Rounded Prices: " + Arrays.toString(r.roundUp(prices)));

		prices = new double[]{30.9, 2.4, 3.9};
		System.out.println("Prices: " + Arrays.toString(prices));
		r = new RoundTheAmounts();
		System.out.println("Rounded Prices: " + Arrays.toString(r.roundUp(prices)));
		
		prices = new double[]{1.99,1.99,1.99,1.99,1.99};
		System.out.println("Prices: " + Arrays.toString(prices));
		r = new RoundTheAmounts();
		System.out.println("Rounded Prices: " + Arrays.toString(r.roundUp(prices)));
	}
}
