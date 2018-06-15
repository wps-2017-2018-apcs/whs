package minesweeper;

/**
 * RandPlace- looks convoluted; is solely for deciding where bombs are- randomly placing them, if you will
 * @author Kevin Khaghani // 1907024@wpsstudent.com
 */
public class RandPlace {
	private int row, col, numTrue;
	private boolean[] truthArr;
	
	/**
	 * This whole class is to create a boolean array
	 * @param r
	 * @param c
	 * @param number
	 * @precondition numTrue <= row * col
	 */
	public RandPlace(int r, int c, int number) {
		if (numTrue > row * col) {
			throw new RuntimeException("Error: array cannot contain that many values");
		}
		row = r;
		col = c;
		numTrue = number;
	}
	
	/** 
	 * numContains counts the number of "true" or "false" (truth) in an array
	 * @param truth
	 * @param array
	 * @return the number of times truth appears in the array
	 */
	public int numContains(boolean truth, boolean[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (truth == array[i]) {
				count++;
			}
		}
		return count;
	}
	public int numContains(boolean truth, boolean[][] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (truth == array[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Bread and butter of the class: creates a valid array (one long one) of [row*col] length, with [numTrue] "true" values
	 * @return the array
	 */
	public boolean[] valid() {
		boolean[] validArr = new boolean[row * col];
		for (int i = 0; i < validArr.length; i++) {
			validArr[i] = false;
		} //all values in validArr initialized to false
		
		for (int i = 0; i < numTrue; i++) {
			int slotsAvailable = numContains(false, validArr); //4x4, 5 should return 16 at i=0
			
			int randIndex = (int)(Math.random() * slotsAvailable); //0-15
			
			for (int j = 0; j < validArr.length; j++) {
				if (j == randIndex) {
					if (validArr[j] == false) {
						validArr[j] = true;
					} else {
						i--;
					}
				}
			}
		}
		truthArr = validArr;
		return validArr;
	}
	
	/**
	 * Returns the number of "true" values in the truth array
	 * @return number of "true" values in the array
	 */
	public int arrTruth() {
		return numContains(true, truthArr);
	}
	
	/**
	 * Generates a usable 2D array from the 1D array truthArr- convoluted? Granted.
	 * @return the 2D array
	 */
	public boolean[][] convert2D() {
		boolean[][] truth2D = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				truth2D[i][j] = truthArr[i * col + j];
			}
		}
		
		return truth2D;
	}
	
	/**
	 * Generates a usable 2D array from any passed boolean[] array- such as the one valid() makes.
	 * @return the 2D array
	 */
	public boolean[][] generate2D() {
		boolean[] arr = this.valid();
		boolean[][] truth2D = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				truth2D[i][j] = arr[i * col + j];
			}
		}
		
		return truth2D;
	}
}
