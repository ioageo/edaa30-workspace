
public class soduku_main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[9][9];
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		
		
		/*
		 * fila up en matrix
		 */
		
		int i = 0;
		int vol = 1;
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				matrix[x][y] = num[i];
				i = (i + 1) % 9;
			}
			i = vol;
			vol++;
		}
		
		
		
		
		
		System.out.println("BEFORE " + test(matrix));
		show(matrix);
		matrix[0][0] =-1;
		System.out.println();

		System.out.println("AFTER " + test(matrix));

		System.out.println();
		show(matrix);

	}

	/**
	 * @param put en (sudoku) matrix 
	 * @return true if matrix is ok 
	 */
	static boolean test(int[][] matrix) {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				int i = matrix[x][y];
				for (int k = 0; k < 9; k++) {
					if (k == x || k == y)
						continue;
					if (matrix[k][x] == i || matrix[y][k] == i)
						return false;

				}
			}
		}
		return true;

	}
/*
 * Print out a matrix 9*9
 */
	static void show(int[][] matrix) {
		int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, };
		for (int x : num) {
			for (int y : num) {
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
	}

}
