package javaCollections;
import java.util.Scanner;

public class Java2DArray {
	public static void main(String[] args) {
		Scanner in1 = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in1.nextInt();
			}
		}
		in1.close();
		int maxvalue = -63;
		int value;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				value = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (value > maxvalue) {
					maxvalue = value;
				}
			}
		}
		System.out.println(maxvalue);
	}

}
