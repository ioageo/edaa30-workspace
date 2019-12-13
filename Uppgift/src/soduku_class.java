
public class soduku_class {
	public int[][] sudokuMatrix = new int[9][9];

	soduku_class(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int k = 0; k < a[0].length; k++) {
				sudokuMatrix[i][k] = a[i][k];
			}
		}
	}

	/**
	 * Solves the puzzle, if it could be solved .
	 * 
	 * @return 0 if the puzzle can't be solved, 1 if the puzzle can be solved.
	 */
	public void solve() {
		solve(0, 0);
	}

	public boolean check(int[][] matrix) {		
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				int nbr = matrix[x][y];
				for (int len = 0; len < 9; len++) {
					if (matrix[x][len] == nbr && len != y) {
						return false;
					}
					if (matrix[len][y] == nbr && len != x) {
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
			}
		}
		return true;

	}

	public int[][] SolvedMatrix() {
		solve();
		return  check(sudokuMatrix) ? sudokuMatrix : null;

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
	private boolean checkRules(int row, int column, int number) {

		return rowAvailabilityCheck(row, number) && columnAvailabilityCheck(column, number)
				&& boxAvailabilityCheck(row, column, number);

	}

	/**
	 * Check if the number can be added to the Row.
	 * 
	 * @param row    The row of the number to be added.
	 * @param number The number to be added.
	 * @return True if the number could be added, False if the number couldn't be
	 *         added.
	 */
	private boolean rowAvailabilityCheck(int row, int number) {

		for (int i = 0; i < 9; i++) {
			if (sudokuMatrix[row][i] == number)
				return false;
		}

		return true;

	}

	/**
	 * Check if the number can be added to the Column.
	 * 
	 * @param column The column of the number to be added.
	 * @param number The number to be added.
	 * @return True if the number could be added, False if the number couldn't be
	 *         added.
	 */
	private boolean columnAvailabilityCheck(int column, int number) {

		for (int i = 0; i < 9; i++) {
			if (sudokuMatrix[i][column] == number)
				return false;
		}

		return true;
	}

	/**
	 * Check if the number can be added to the 3x3 box.
	 * 
	 * @param row    The row of the number to be added.
	 * @param column The column of the number to be added.
	 * @param number The number to be added.
	 * @return True if the number could be added, False if the number couldn't be
	 *         added.
	 */
	private boolean boxAvailabilityCheck(int row, int column, int number) {

		int rr = row - row % 3;
		int cc = column - column % 3;

		for (int i = rr; i < rr + 3; i++) {
			for (int j = cc; j < cc + 3; j++) {
				if (sudokuMatrix[i][j] == number)
					return false;
			}
		}
		return true;
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

		if (row == 9)
			return true;

		if (sudokuMatrix[row][column] != 0) {
			if (solve(column == 8 ? (row + 1) : row, (column + 1) % 9))
				return true;
		} else {
			for (int i = 0; i < 9; i++) {
				if (checkRules(row, column, i + 1)) {
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

}
