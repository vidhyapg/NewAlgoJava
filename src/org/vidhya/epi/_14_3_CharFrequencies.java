package org.vidhya.epi;

import java.util.Arrays;

public class _14_3_CharFrequencies {

	/*
	 * Assuming each char is between a-z (97-122) or A-Z (65-90)
	 * RunTime: O(n) number of chars in string
	 * Space: O(1) 58 elements 
	 */
	static void countCharFreq(String input) {
		char[] arr = input.toCharArray();
		int N = 58;
		int map[] = new int[N];
		for (int i = 0 ; i < arr.length; i++) {
			int k = arr[i] - 'A';
			if ((k > 0) && (k < N)) {
				map[k]++;
			}
		}
		
		for (int i = 0 ; i < map.length; i++) {
			if (map[i] != 0)
				System.out.println((char)(i+'A') + " -> "+ map[i]);
		}
		
	}
	/*
	 * 
	 * RunTime: O(nlogn) number of chars in string
	 * Space: O(1) nothing
	 */
	static void countCharFreqBySort(String input) {
		int count = 1;
		char[] arr = input.toCharArray();
		Arrays.sort(arr);
		int i = 1;
		for (; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				System.out.println(arr[i-1] + " -> "  + count);
				count = 1;
			}
			else {
				count++;
			}			
		}
		System.out.println(arr[i-1] + " -> "  + count);		
	}
	
	
	public static void main(String args[]) {
		String in = "sivamsivaya";
		countCharFreqBySort(in);
		System.out.println();
		countCharFreq(in);
	}
	
}
