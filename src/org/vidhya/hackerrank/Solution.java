package org.vidhya.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
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
    
  
    static String[] buildSubsequences(String s) {
    	 ArrayList<String> resList = buildSubsequencesHelper(s, s.length(), s.length());
    	 String[] resArray = resList.toArray(new String[resList.size()]);
    	 return resArray;
    }
    
}
