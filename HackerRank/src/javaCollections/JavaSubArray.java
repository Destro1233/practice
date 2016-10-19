package javaCollections;
import java.util.Scanner;

public class JavaSubArray {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int n = String.valueOf(s);
        int arr[] = new int[n];
        for (int i = 0; i<arr.length;i++){
            arr[i] = in.nextInt();
        }
        int value,count=0;
        for (int i = 0; i < arr.length; i++) {
            value=0;
			for (int j = i; j < arr.length; j++) {
				value += arr[j];
                if (value<0){
                    count++;
                }
			}
		}
        System.out.print(count);
    }
}
