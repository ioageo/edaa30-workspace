
public class soduku_class {
	private int[][] sudokuMatrix;

	/**
	 * Class constructor
	 */
	public soduku_class() {
		sudokuMatrix = new int[9][9];
	}

	/**
	 * Sets the numbers in sudokuMatrix
	 * 
	 * @param a given matrix
	 */
	void SetMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[0].length; k++) {
				sudokuMatrix[i][k] = matrix[i][k];
			}
		}
	}

	/**
	 * Solves the sudoku if possible
	 */
	public void solve() {
		solve(0, 0);
	}

	/**
	 * Solves the sudoku puzzle recursively
	 * 
	 * @param row    starting row
	 * @param column starting column
	 * @return true if the sudoku puzzle did get solved, false if the puzzle didn't
	 *         get solved
	 */
	private boolean solve(int row, int column) {
			/*
			 * stop condition for recursion
			 */
		if (row == 9)
			return true;

		if (sudokuMatrix[row][column] != 0) {
			if (solve(column == 8 ? (row + 1) : row, (column + 1) % 9))
				return true;
		} else {
			for (int i = 0; i < 9; i++) {
				if (checkRules(sudokuMatrix, row, column, i + 1)) {
					sudokuMatrix[row][column] = (i + 1);
					if (solve(column == 8 ? (row + 1) : row, (column + 1) % 9))
						return true;
					else
						sudokuMatrix[row][column] = 0;
				}
			}

		}

		return false;

	}

	/**
	 * @return true if all is correct
	 */
	private boolean check() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				int nbr = sudokuMatrix[x][y];
				for (int len = 0; len < 9; len++) {
					if (sudokuMatrix[x][len] == nbr && len != y) {
						return false;
					}
					if (sudokuMatrix[len][y] == nbr && len != x) {
						return false;
					}
				}
				int row = (x / 3) * 3;
				int col = (y / 3) * 3;
				for (int i = 0; i < 3; i++) {
					for (int k = 0; k < 3; k++) {

						if ((row + i != x && col + k != y) && sudokuMatrix[row + i][col + k] == nbr) {
							return false;
						}
					}
				}
			}
		}
		return true;

	}

	/**
	 * @return the matrix to be printed
	 */
	public int[][] SolvedMatrix() {
		solve();
		return check() ? sudokuMatrix : null;

	}

	/**
	 * Checks if the sudoku rules apply.
	 * 
	 * @param row    The row of the number.
	 * @param column The column of the number.
	 * @param number The number to be checked.
	 * @return True if the rules apply for the number to be added, False if the
	 *         rules don't apply.
	 */
	public boolean checkRules(int[][] matrix, int x, int y, int nbr) {

		for (int i = 0; i < 9; i++) {
			if (matrix[x][i] == nbr && y != i) {
				return false;
			}
			if (matrix[i][y] == nbr && x != i) {
				return false;
			}
		}
		int row = (x / 3) * 3;
		int col = (y / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if ((row + i != x && col + k != y) && matrix[row + i][col + k] == nbr) {
					return false;
				}
			}
		}
		return true;
	}

}
