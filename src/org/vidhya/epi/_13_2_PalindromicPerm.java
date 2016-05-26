package org.vidhya.epi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Find whether a string can be permuted to form a palindrome.
 * eg. edified -> deified (palindrome) 
 */
public class _13_2_PalindromicPerm {
	/*
	 * Runtime: O(nlogn)
	 * Space: O(1)
	 */
	static boolean canBePermutedModifyString(String in)
	{
		boolean flag = true;
		if (in.isEmpty())
			return false;
		char[] arr = in.toCharArray();
		Arrays.sort(arr);
		// count frequencies in a sorted array. Only one should be of odd count		
		System.out.print(arr[0]);
		int count = 1;	
		boolean odd = false;
		for (int i = 1; i < arr.length; i++){
			System.out.print(arr[i]);
			if(arr[i] != arr[i-1]) {
				if (count%2 != 0) {
					if (!odd) {
						odd = true;
					}else {
						flag = false;
						break;
					}					
				}
				// reset counter
				count = 1;				
			}
			else
			{
				count++;
			}
		}
		System.out.println();
		
		if ((count%2 != 0) && (odd) && (flag)) {
			System.out.println("last is odd");
			flag = false;					
		}		
		return flag;
	}
	/*
		* Runtime: O(n) where n is length of input string
		* Space: O(c) where c is number of distinct chars in string
	 */
	static boolean canBePermutedtoPalnidrome(String in)
	{
		boolean flag = true;
		Map<Character, Integer> cmap = new HashMap<Character, Integer>();
		for(char c: in.toCharArray())
		{
			if (cmap.containsKey(c)){
				cmap.put(c, (cmap.get(c)+1));
			}
			else{
				cmap.put(c, 1);
			}
		}
		boolean odd = false;
		for(int v : cmap.values()){
			if ((v % 2) != 0 ){
				// if v is odd for first time, then set odd flag
				if (!odd){
					odd = true;
				}
				// if v is odd for second time, then return false;
				else {
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}
	
	public static void main(String args[])
	{
		String[] in = {"edified","denmarkamnedk", "denmark"};  
		
		for (String input: in){
			System.out.println(input+ " can be permuted to a Palindrome: " + canBePermutedModifyString(input));
		}
	}
}
