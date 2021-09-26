package com.srk.strings;

import java.util.ArrayDeque;
import java.util.Queue;

public class PalindromeNumber {

	private static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

	private static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {

		if(grid[sr][sc] != 1 || grid[tr][tc] !=1) {
			return -1;
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{sr,sc});
		int hops = 0;

		while(!q.isEmpty()) {
			int[] cell = q.poll();
			int r = cell[0];
			int c = cell[1];
			hops += grid[r][c];
			grid[r][c] = 0;

			for(int[] d : dir){   
				int nr = r + d[0]; int nc = c + d[1];
				if(nr>=0 && nr < grid.length && nc >=0 && nc <grid[0].length){
					if(nr == tr && nc == tc)
						return hops;
					else if(grid[nr][nc] == 1){
						q.offer(new int[]{nr,nc});
					}
				}
			}
		}
		return -1;


	}

	public static void main(String[] args) {
		System.out.println(shortestCellPath(new int [][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}}, 0, 0, 2, 0));
	}
}
