package org.vidhya.epi;

import java.util.HashMap;
import java.util.Map;

/*
 * Find the word with minimum distance of any closest pair of equal entries. 
 * E.g. input = {"All", "Work", "and", "no", "play", "makes", "for", "no", "fun", "and", "no", "results"}
 * returns: "no" with distance 2 between them. 
 * Runtime: O(n) number of words
 *  */
public class _13_8_ClosestPairofWords {

	static String findClosestWordPair(String[] input) {
		String ans = null;
		int min_dis = Integer.MAX_VALUE;
		Map<String, Integer> lposmap = new HashMap<String, Integer>(); 
		for (int i = 0; i < input.length; i++) {
			if (lposmap.containsKey(input[i])) {
				int dis = i - lposmap.get(input[i]);
				if(dis < min_dis) {
					min_dis = dis;
					ans = input[i];
				}
			}
			lposmap.put(input[i], i);
		}	
		
		return ans;
	}
	
	public static void main(String args[]) {
		String[] input = {"All", "Work", "and", "no", "play", "makes", "play", "for", "fun", "no", "and", "results"};
		
		System.out.println("The closest word pair is: " + findClosestWordPair(input));
	}
}
