package org.vidhya.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution_old {
	
    static int[] fibonacci(int n) {
    	int[] res = new int[n];
    	// 1 <= N <=10
    	res[0] = 0;
    	
    	if (n > 1)
    	{
    		res[1] = 1;        		
    	}   		
    	
    	for (int i = 2; i < n; i++)
    	{
    		res[i] = res[i-1] + res[i-2];
    	} 	
    	return res;
	}
    
    static int lonelyInteger(int[] arr) {
    	HashSet<Integer> hset = new HashSet<Integer>();
    	
    	for (int i : arr)
    	{
    		if (hset.contains(i))
    		{
    			hset.remove(i);
    		}else
    		{
    			hset.add(i);
    		}
    	}
    	
    	if (hset.size() != 1)
    	{
    		throw new InvalidParameterException();
    	}
    	
    	int res = 0; 
    	for (Integer x: hset)
    	{
    		res = x;
    	}    	
    	return res;
    }
	 
    static ArrayList<String> buildSubsequencesHelper(String s, int n, int fn){
    	int len = (int)Math.pow(2, n);
    	ArrayList<String> full = new ArrayList<String>();
    	//System.out.println(s);
    	if (n == 1)
    	{
    		full.add(s);
    		full.add("");
    		return full;
    	}
    	ArrayList<String> partial = buildSubsequencesHelper(s.substring(0, n-1), n-1, fn);
    	for(String p: partial)
    	//for (int i = 0 ; i < len/2; i++)
    	{
    		if (!((n == fn) && (p.isEmpty())))
    			full.add(p);
    		String derived = new String (p+ s.charAt(n-1));
    		full.add(derived); 
    	}
    	
    	return full;    	
    }
    
    /*
    static String[] buildSubsequencesHelper(String s, int n, int fn){
    	int len = (int)Math.pow(2, n);
    	String[] full = new String[len];
    	//System.out.println(s);
    	if (n == 1)
    	{
    		full[0] = s;
    		full[1] = "";
    		return full;
    	}
    	String[] partial = buildSubsequencesHelper(s.substring(0, n-1), n-1, fn);
    	for (int i = 0 ; i < len/2; i++)
    	{
    		//if (!((n == fn) && (partial[i].isEmpty())))
    		full[i] = partial[i];
    		String derived = new String (partial[i]+ s.charAt(n-1));
    		full[i+(len/2)]= derived; 
    	}
    	
    	return full;    	
    }
    */
    
    /*
    static void buildSubsequencesHelper(String s, int n){
    	System.out.println(s);
    	if (n == 1)
    	{
    		return;
    	}

    	buildSubsequencesHelper(s.substring(0, n-1), n-1);
    }
    */
    
    static String[] buildSubsequences(String s) {
    	 ArrayList<String> resList = buildSubsequencesHelper(s, s.length(), s.length());
    	 String[] resArray = resList.toArray(new String[resList.size()]);
    	 return resArray;
    }
    
    
	 
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
       /*
        final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _arr_size = Integer.parseInt(in.nextLine());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine());
            _arr[_arr_i] = _arr_item;
        }
        
        
        res = lonelyInteger(_arr);
        System.out.println("output is: " + res);
        */
        //buildSubsequences("abcde");
        
        for(String res: buildSubsequences("abcd"))
        	System.out.println(res);
        
        /*bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close(); */
    }
}
