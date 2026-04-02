package assignment9_exercises;

import java.util.LinkedList;

public class ThreesController {
	
	//Stores the Threes board
	private ThreesBoard board;
	//Stores the next tile that will appear in the board.
	private int nextTileValue;
	
	//Stores the rows that move during the last movement
	private LinkedList<Integer> movedRows;
	
	//Stores the columns that move during the last movement
	private LinkedList<Integer>  movedColumns;
	
	public ThreesController() {
		//Create the initial board.
		//9 random tails set with 1, 2 or 3.
		board = new ThreesBoard(9);
		//Set randomly the next tile to appear in the board.
		nextTileValue = board.generator.getRandom(3) + 1;
		//initially no row or column has been moved.
		movedRows = new LinkedList<Integer>();
		movedColumns = new LinkedList<Integer>();
	}
	
	public ThreesController(ThreesBoard b) {
		this.board = b;
		//Set randomly the next tile to appear in the board.
		nextTileValue = board.generator.getRandom(3) + 1;
		//initially no row or column has been moved.
		movedRows = new LinkedList<Integer>();
		movedColumns = new LinkedList<Integer>();
	}
	
	public ThreesBoard getBoard(){
		return board;
	}
	
	public int getNextTileValue(){
		return nextTileValue;
	}
	
	
	
	
	/**
	 * Moves the game pieces on the board upward, merging adjacent pieces
	 * according to specified game rules.
	 *
	 * If a merge occurs, the board's state is updated accordingly.
	 *
	 * @return true if any pieces were moved or merged, 
	 *         false if no pieces could be shifted upward.
	 */
	public boolean moveUp() {
		movedRows.clear();
		movedColumns.clear();
		boolean modified = false;
		for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
			int[] original = readColumn(j, true);
			int[] moved = collapseAndMergeLine(original);
			if (!sameLine(original, moved)) {
				modified = true;
				markMovedColumn(j);
				writeColumn(j, moved, true);
			}
		}
		if (modified) {
			loadNextTileOnColumns(true);
		}
		return modified;
	}
	
	
	
	/**
	 * Moves the game pieces on the board downward, merging adjacent pieces
	 * according to specified game rules.
	 *
	 * If a merge occurs, the board's state is updated accordingly.	 
	 * 
	 * @return true if any pieces were moved or merged, 
	 *         false if no pieces could be shifted upward.
	 */
	public boolean moveDown(){
		movedRows.clear();
		movedColumns.clear();
		boolean modified = false;
		for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
			int[] original = readColumn(j, false);
			int[] moved = collapseAndMergeLine(original);
			if (!sameLine(original, moved)) {
				modified = true;
				markMovedColumn(j);
				writeColumn(j, moved, false);
			}
		}
		if (modified) {
			loadNextTileOnColumns(false);
		}
		return modified;
	}
	
	
	
	/**
	 * Moves the game pieces on the board to the left, merging adjacent pieces
	 * according to specified game rules.
	 *
	 * If a merge occurs, the board's state is updated accordingly.
	 *
	 * @return true if any pieces were moved or merged, 
	 *         false if no pieces could be shifted to the left.
	 */
	public boolean moveLeft(){
		movedRows.clear();
		movedColumns.clear();
		boolean modified = false;
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			int[] original = readRow(i, true);
			int[] moved = collapseAndMergeLine(original);
			if (!sameLine(original, moved)) {
				modified = true;
				markMovedRow(i);
				writeRow(i, moved, true);
			}
		}
		if (modified) {
			loadNextTileOnRows(true);
		}
		return modified;
	}
	
	
	
	/**
	 * Moves the game pieces on the board to the right, merging adjacent pieces
	 * according to specified game rules.
	 *
	 * This method shifts all movable pieces towards the right side of the board,
	 *
	 * @return true if any pieces were moved or merged, 
	 *         false if no pieces could be shifted to the right.
	 */
	public boolean moveRight(){
		movedRows.clear();
		movedColumns.clear();
		boolean modified = false;
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			int[] original = readRow(i, false);
			int[] moved = collapseAndMergeLine(original);
			if (!sameLine(original, moved)) {
				modified = true;
				markMovedRow(i);
				writeRow(i, moved, false);
			}
		}
		if (modified) {
			loadNextTileOnRows(false);
		}
		return modified;
	}

	/**
	 * Reads a row in move order.
	 *
	 * @param row row index
	 * @param left true for left-to-right, false for right-to-left
	 * @return row values ordered by movement direction
	 */
	private int[] readRow(int row, boolean left) {
		int[] line = new int[ThreesBoard.COLUMNS];
		for (int k = 0; k < ThreesBoard.COLUMNS; k++) {
			int col = left ? k : ThreesBoard.COLUMNS - 1 - k;
			line[k] = board.getTile(row, col).getValue();
		}
		return line;
	}

	/**
	 * Writes a row from movement order back to board coordinates.
	 *
	 * @param row row index
	 * @param line values to store
	 * @param left true for left-to-right, false for right-to-left
	 */
	private void writeRow(int row, int[] line, boolean left) {
		for (int k = 0; k < ThreesBoard.COLUMNS; k++) {
			int col = left ? k : ThreesBoard.COLUMNS - 1 - k;
			board.setTile(row, col, line[k]);
		}
	}

	/**
	 * Reads a column in move order.
	 *
	 * @param col column index
	 * @param up true for top-to-bottom, false for bottom-to-top
	 * @return column values ordered by movement direction
	 */
	private int[] readColumn(int col, boolean up) {
		int[] line = new int[ThreesBoard.ROWS];
		for (int k = 0; k < ThreesBoard.ROWS; k++) {
			int row = up ? k : ThreesBoard.ROWS - 1 - k;
			line[k] = board.getTile(row, col).getValue();
		}
		return line;
	}

	/**
	 * Writes a column from movement order back to board coordinates.
	 *
	 * @param col column index
	 * @param line values to store
	 * @param up true for top-to-bottom, false for bottom-to-top
	 */
	private void writeColumn(int col, int[] line, boolean up) {
		for (int k = 0; k < ThreesBoard.ROWS; k++) {
			int row = up ? k : ThreesBoard.ROWS - 1 - k;
			board.setTile(row, col, line[k]);
		}
	}

	/**
	 * Collapses and merges one board line according to Threes rules.
	 *
	 * @param line values ordered by movement direction
	 * @return processed line preserving fixed size
	 */
	private int[] collapseAndMergeLine(int[] line) {
		int[] compact = new int[line.length];
		int compactSize = 0;
		for (int value : line) {
			if (value != 0) {
				compact[compactSize++] = value;
			}
		}

		int[] merged = new int[line.length];
		int mergedSize = 0;
		int i = 0;
		while (i < compactSize) {
			if (i + 1 < compactSize && canValuesCombine(compact[i], compact[i + 1])) {
				merged[mergedSize++] = compact[i] + compact[i + 1];
				i += 2;
			} else {
				merged[mergedSize++] = compact[i];
				i++;
			}
		}
		return merged;
	}

	/**
	 * Compares two lines element by element.
	 *
	 * @param a first line
	 * @param b second line
	 * @return true iff every position has the same value
	 */
	private boolean sameLine(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if two non-zero values are combinable in Threes.
	 *
	 * @param a first value
	 * @param b second value
	 * @return true when values can merge
	 */
	private boolean canValuesCombine(int a, int b) {
		return (a == 1 && b == 2) ||
			   (a == 2 && b == 1) ||
			   (a >= 3 && a == b);
	}

	/**
	 * Registers a row index as moved without duplicates.
	 *
	 * @param row row to register
	 */
	private void markMovedRow(int row) {
		if (!movedRows.contains(row)) {
			movedRows.add(row);
		}
	}

	/**
	 * Registers a column index as moved without duplicates.
	 *
	 * @param col column to register
	 */
	private void markMovedColumn(int col) {
		if (!movedColumns.contains(col)) {
			movedColumns.add(col);
		}
	}
	
	
	
	
	
	
	/**
	 * Places the next tile on a random column after an upward or downward move.
	 *
	 * This method is called after a move is performed to add a new tile
	 * at the top or bottom of a randomly selected column from the list of 
	 * recently moved columns. If the move was upward, the tile is added at 
	 * the bottom row; if downward, it is added at the top row.
	 *
	 * The tile's value is determined by  nextTileValue. After placing 
	 * the tile, a new random value between 1 and 3 is assigned to nextTileValue.
	 *
	 * @param up true if the previous move was upward, false if downward.
	 */
	private void loadNextTileOnColumns(boolean up) {
		
		//Assume an upward or downward was performed.
		if(!movedColumns.isEmpty()){
			int pos = board.generator.getRandom(movedColumns.size());
			if(up)
				board.setTile(ThreesBoard.ROWS - 1, movedColumns.get(pos), nextTileValue);
			else
				board.setTile(0, movedColumns.get(pos),nextTileValue);
			nextTileValue = board.generator.getRandom(3) + 1;
		}
	}
	
	
	/**
	 * Places the next tile on a random row after a leftward or rightward move.
	 *
	 * This method is called after a move is performed to add a new tile
	 * at the leftmost or rightmost position of a randomly selected row from 
	 * the list of recently moved rows. If the move was leftward, the tile is 
	 * added at the rightmost column; if rightward, it is added at the leftmost column.
	 *
	 * The tile's value is determined by {@code nextTileValue}. After placing 
	 * the tile, a new random value between 1 and 3 is assigned to {@code nextTileValue}.
	 *
	 * @param left true if the previous move was leftward, false if rightward.
	 */
	private void loadNextTileOnRows(boolean left) {
		//Assume an upward or downward was performed.
		if(!movedRows.isEmpty()){
			int pos = board.generator.getRandom(movedRows.size());
			if(left)
				board.setTile(movedRows.get(pos), ThreesBoard.COLUMNS - 1, nextTileValue);
			else
				board.setTile(movedRows.get(pos), 0 , nextTileValue);
			nextTileValue = board.generator.getRandom(3) + 1;
		}
	}
	
	
}
