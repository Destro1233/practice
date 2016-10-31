package interview;

import java.util.Scanner;

public class ValidNumber {
	int counter;

	public static void main(String args[]) {
		// Scanner in = new Scanner(System.in);
		// String s = in.nextLine();
		String s = "[[0,0,0], [0,1,0],[1,0,1]], 3,3,2,1";
		s = (s.replaceAll("[^\\p{Alnum}\\s]", " ")).trim().replaceAll("( )+", " ");
		String[] input = s.split(" ");
		int len = input.length;
		int row = Integer.valueOf(input[len - 4]), col = Integer.valueOf(input[len - 3]),
				exitRow = Integer.valueOf(input[len - 2]), exitCol = Integer.valueOf(input[len - 1]);
		int[][] maze = new int[row + 2][col + 2];
		int z = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 || j == 0 || i == 4 || j == 4) {

				} else {
					maze[i + 2][j + 2] = Integer.valueOf(input[z]);
					z++;
				}
			}
		}
		ValidNumber vn = new ValidNumber();
		vn.solve(exitRow + 2, exitCol + 2, maze);

	}

	public void solve(int x, int y, int[][] maze) {
		if (step(x, y, maze)) {
			maze[x][y] = '2';
		}
	}

	public boolean step(int x, int y, int[][] maze) {

		counter++;

		// System.out.println(this.toString());

		/** Accept case - we found the exit **/
		if (maze[x][y] == '2') {
			return true;
		}

		/** Reject case - we hit a wall or our path **/
		if (maze[x][y] == 1 || maze[x][y] == 1) {
			return false;
		}

		/** Backtracking Step **/

		// Mark this location as part of our path
		maze[x][y] = 3;
		boolean result;

		// Try to go Right
		result = step(x, y + 1, maze);
		if (result) {
			return true;
		}

		// Try to go Up
		result = step(x - 1, y, maze);
		if (result) {
			return true;
		}

		// Try to go Left
		result = step(x, y - 1, maze);
		if (result) {
			return true;
		}

		// Try to go Down
		result = step(x + 1, y, maze);
		if (result) {
			return true;
		}

		/** Deadend - this location can't be part of the solution **/

		// Unmark this location
		// maze[x][y] = ' ';

		// Go back
		return false;
	}

	// public String toString(int[][] maze) {
	// String output = "";
	// for (int x=0; x<10; x++) {
	// for (int y=0; y<10; y++) {
	// output += maze[x][y] + " ";
	// }
	// output += "\n";
	// }
	// return output;
	// }

}