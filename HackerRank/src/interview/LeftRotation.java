package interview;
/* At the moment the runtime is big O of 2n, if we replace array with linklist intially
 * the runtime will reduce to big of k.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class LeftRotation {
	//Input Example :- 5 4 1 2 3 4 5 
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	int i=0;
    	while (i<n) {
    		ll.addLast(a[i]);
			//System.out.println(a[i]);
			i++;
		}
    	i=0;
    	while(i<k){
    		ll.addLast(ll.removeFirst());
    		i++;
    		//System.out.print(ll.peekFirst()+ " ");
    	}
    	
    	int[] a1 = new int[ll.size()];
    	for(int j=0; j<n;j++){
    		a1[j] = (int)ll.removeFirst();
    	}
    	return a1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        //System.out.println();
        in.close();
      
    }
}