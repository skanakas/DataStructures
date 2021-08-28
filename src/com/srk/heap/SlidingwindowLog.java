package com.srk.heap;

import java.util.PriorityQueue;

public class SlidingwindowLog {
	
	private int maxCount = 0;
	
	public SlidingwindowLog(int max) {
		this.maxCount = max;
	}
	
	PriorityQueue<Long> log = new PriorityQueue<Long>((l1,l2)->(int)(l1-l2));
	
	public boolean allow() {
		
		long currTime = System.currentTimeMillis()/1000;
		long swStart = currTime - 1000;
		
		synchronized (log) {
			
			while(!log.isEmpty() && log.peek() <= swStart) {
				log.poll();
			}
			log.offer(currTime);
			
			return log.size() <= maxCount;
		}
	}

}
