package com.srk.kth.problems;

import java.util.PriorityQueue;

public class SumOfElements {

  public static int findSumOfElements(int[] nums, int k1, int k2) {
    if(nums == null || nums.length == 0 || k1>nums.length || k2>nums.length)
      return -1;
    
    if(k1>k2)
    {
      int t = k1;
      k1 = k2;
      k2 = t;
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
    for(int i = 0; i<nums.length; i++) {

      if(maxHeap.size()>k2) {
        if(maxHeap.peek()>nums[i]){
          maxHeap.poll();
          maxHeap.offer(nums[i]);
        }
      } else {
        maxHeap.offer(nums[i]);
      }
    }
    
    int sum = 0;
    while(!maxHeap.isEmpty()) {
    	if(maxHeap.size() < k2 && maxHeap.size()>k1)
    		sum += maxHeap.peek();
    	maxHeap.poll();
    }

    return sum;
  }

  public static void main(String[] args) {
    int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}
