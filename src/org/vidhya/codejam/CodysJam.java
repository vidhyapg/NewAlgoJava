package org.vidhya.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class CodysJam {

	List<Integer> findSaleItems(int B, TreeMap<Integer, Integer> tmap)
	{
		List<Integer> res = new ArrayList<Integer>();
		
		while(!tmap.isEmpty())
		{
			Integer sk = tmap.firstKey();
			Integer rk = (sk/3)*4;
			if (tmap.containsKey(rk))
			{
				res.add(sk);
				// if corres rk exists, decr sk and rk count.
				tmap.put(sk, tmap.get(sk)-1);
				tmap.put(rk, tmap.get(rk)-1);
				if (tmap.get(sk) == 0)
					tmap.remove(sk);
				if (tmap.get(rk) == 0)
					tmap.remove(rk);
			}
		}		
		//res.add(B);
		return res;
	}
	
	
	public static void main(String args[])
	{
		/* Tip# To read from file and write to file.
		 * 
		 */
		CodysJam mobj = new CodysJam();
		String infileName = args[0];
		String outfileName = args[1];
		System.out.println(infileName);
		System.out.println(outfileName);

		//String infileName = "A-small-practice.in";
		//String outfileName = "A-small-practice.out";

        //try {
        	Scanner in = new Scanner(System.in);
            //Scanner in = new Scanner(new File(infileName));
        	/* Use Scanner instead of br, can parse tokens
        	 * BufferedReader br = 
                new BufferedReader(new FileReader(infileName));
			*/
            /*PrintWriter pw =
            		new PrintWriter(new BufferedWriter(new FileWriter(outfileName)));
            */
            PrintWriter pw = new PrintWriter(System.out);
            
            int N = in.nextInt();
            //pw.println(N);
            for (int z = 1; z <= N; z++)
            {
            	int B = in.nextInt();
            	TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
            	//pw.println(B);
            	for (int y = 0 ; y < 2*B; y++)
            	{
            		int item = in.nextInt();
            		
            		if(!tmap.containsKey(item)) {
            			tmap.put(item,1);
            		}
        			else {
        				tmap.put(item, tmap.get(item)+1);
        			}
            	}
            	pw.print("Case #"+ z + ": ");
                for (Integer x: mobj.findSaleItems(B , tmap))
    			{
    				pw.print(x + " ");
    			}
                pw.println();
            }     	

            // Always close files.
            in.close(); 
            // Always close files.
            pw.close();
        //}
        /*
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file ");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file ");                  
        }
		*/
	}
	
}


