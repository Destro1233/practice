package javaCollections;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaArray {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<int[]> al = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
			int k = in.nextInt();
			int arr[] = new int[k];
			for (int j = 0; j < k; j++) {
				arr[j] = in.nextInt();
			}
			al.add(arr);
		}
        n = in.nextInt();
        String value="";
        //int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
        	int row = in.nextInt();
        	int colomn = in.nextInt();
        	if(al.size()>row&&row>0){
        		int[] arr = al.get(row-1);
        		if(arr.length>=colomn&&colomn>0){
        			value = String.valueOf(arr[colomn-1]);
        		}else{
        			value = "ERROR!";
        		}
        	}else{
        		value = "ERROR!";
        	}
        	System.out.println(value);
        }
        in.close();
        //System.out.println(al.stream());
        
    }
}
