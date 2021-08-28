package com.srk.strings;

public class Solution {

	public static void main(String args[]) {
		String[] words = new String[] { "cat", "baby", "dog", "bird", "car", "ax"};
		String[] inputs = new String[] {"tcabnihjs", "tbcanihjs", "baykkjl", "ccc", "breadmaking", "bbabylkkj"};

		char[][] grid1 = {
				{'c', 'c', 'x', 't', 'i', 'b'},
				{'c', 'c', 'a', 't', 'n', 'i'},
				{'a', 'c', 'n', 'n', 't', 't'},
				{'t', 'c', 's', 'i', 'p', 't'},
				{'a', 'o', 'o', 'o', 'a', 'a'},
				{'o', 'a', 'a', 'a', 'o', 'o'},
				{'k', 'a', 'i', 'c', 'k', 'i'}
		};
		String word1 = "catnip";
		String word2 = "cccc";
		String word3 = "s";
		String word4 = "bit";
		String word5 = "aoi";
		String word6 = "ki";
		String word7 = "aaa";
		String word8 = "ooo"; 

		char[][] grid2 = {{'a'}};
		String word9 = "a";

		findWords(grid1, word1.toCharArray(), word1.length()-1);

	}

	static int rowNum[] = {0, 1};
	static int colNum[] = {1, 0};
	static void DFS(char mat[][], int row, int col,
			int prevRow, int prevCol, char[] word,
			String path, int index, int n)
	{
		if (index > n || mat[row][col] != word[index])
			return;

		path += (word[index]) + "(" + String.valueOf(row)
		+ ", " + String.valueOf(col) + ") ";
		if (index == n)
		{
			System.out.print(path +"\n");
			return;
		}
		for (int k = 0; k < 2; ++k)
			if (isvalid(row + rowNum[k], col + colNum[k],
					prevRow, prevCol, mat.length, mat[row].length))

				DFS(mat, row + rowNum[k], col + colNum[k],
						row, col, word, path, index + 1, n);
	}

	static boolean isvalid(int row, int col, int prevRow, int prevCol, int ROW, int COL)
	{
		return (row >= 0) && (row < ROW) &&
				(col >= 0) && (col < COL) &&
				!(row == prevRow && col == prevCol);
	}

	static void findWords(char mat[][], char []word, int n)
	{
		for (int i = 0; i < mat.length; ++i)
			for (int j = 0; j < mat[i].length; ++j)
				if (mat[i][j] == word[0])
					DFS(mat, i, j, -1, -1, word, "", 0, n);
	}

	public static String isEmbeddedStringFound(String[] words, String input) {

		for(String word : words) {
			int lenCnt = word.length();
			int[] wordMap = new int[26];
			for(char c : word.toCharArray()){
				wordMap[c-'a']++;
			}
			for(char c : input.toCharArray()) {
				if(wordMap[c-'a'] > 0) {
					wordMap[c-'a']--;
				}
			}       
			boolean isWordFound = true;
			for(int charCount : wordMap) {
				if(charCount > 0){
					isWordFound = false;
					break;
				}
			} 
			if(isWordFound)
				return word;
		}
		return "NOT FOUND";
	}
}
