/**
 * 
 */
package com.srk.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

class RottenApple{
	public int row;
	public int col;

	public RottenApple(int r, int c){
		this.row = r;
		this.col = c;
	}
}

public class RottenAppleSolution {


	int getDaysToRot(int[][] grid) {

		Queue<RottenApple> q = new ArrayDeque<>();
		int fresh = 0;
		int R = grid.length;
		int C = grid[0].length;

		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++){
				if(grid[i][j] == 1)
					fresh++;
				else if(grid[i][j] == 2)
					q.offer(new RottenApple(i,j));
			}
		}

		int days = -1;
		if(fresh==0)
			return 0;

		System.out.println("fresh = "+fresh);

		int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};		
		while(!q.isEmpty()) {
			int size = q.size();
			days++;
			while(size-- > 0){
				RottenApple a = q.poll();
				int r = a.row;
				int c = a.col;

				for(int[] d : dir) {
					int nextR = r+d[0];
					int nextC = c+d[1];
					if(nextR>=0 && nextR<R && nextC>=0 && nextC<C && grid[nextR][nextC] == 1){
						fresh--;
						grid[nextR][nextC] = 2;
						q.offer(new RottenApple(nextR, nextC));
					}
				}
			}
		}

		System.out.println("days="+days);

		return fresh == 0 ? days : -1;
	}

}
