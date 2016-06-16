package com.davidsoncamp.tenten.util;

import com.davidsoncamp.tenten.util.Pieces.Piece;
import com.davidsoncamp.tenten.util.Pieces.RelativeCellPosition;

public class GameBoard {

	private Grid grid;

	/**
	 * Place a piece on the game board
	 * 
	 * @param basePosition
	 * @param piece
	 */
	public void placePiece(RelativeCellPosition basePosition, Piece piece) {

		// copy the current grid
		Grid newGrid = Grid.newGrid(grid);

		Cell cell = newGrid.getCell(basePosition, Pieces.RelativeCellPosition.UNITY_CELL_POSITION);
		cell.setAssigned(true);

		// iterate through positions in piece and add them to newGrid
		if (null != piece.getRelativeCellPositions()) {
			for (RelativeCellPosition pieceOffset : piece.getRelativeCellPositions()) {

				// assign the cell of the piece
				cell = newGrid.getCell(basePosition, pieceOffset);
				cell.setAssigned(true);
			}
		}

		grid = newGrid;

	}

	// TODO Move to game board
	public int getScore() {
		return grid.getScore();
	}

	/**
	 * Render the game board and return the rendering as a String
	 * 
	 * @return a String representation of the rendered game board
	 */
	public String render() {

		StringBuffer buffer = new StringBuffer();

		for (int row = 0; row < grid.getDimension(); row += 1) {

			for (int cellrow = 0; cellrow < 3; cellrow += 1) {

				for (int col = 0; col < grid.getDimension(); col += 1) {

					boolean assigned = grid.getCells().get(row * grid.getDimension() + col).isAssigned();
					boolean mostRecentlyAssigned = grid.getCells().get(row * grid.getDimension() + col)
							.isMostRecentlyAssigned();
					int cellId = grid.getCells().get(row * grid.getDimension() + col).getId();
					if (cellrow == 0) {
						buffer.append("||----");
					}

					else if (cellrow == 1) {
						if (assigned) {
							buffer.append("|| ** ");

						} else if (mostRecentlyAssigned) {
							buffer.append("|| $$ ");
						} else {
							buffer.append("|| ").append(computeFirstCellDigit(cellId)).append("  ");
						}
					} else if (cellrow == 2) {
						if (assigned) {
							buffer.append("|| ** ");

						} else if (mostRecentlyAssigned) {
							buffer.append("|| $$ ");
						} else {
							buffer.append("||  ").append(computeSecondCellDigit(cellId)).append(" ");
						}
					}

				}

				buffer.append("||").append("\n");
			}
			if (row == grid.getDimension() - 1) {
				for (int i = 0; i < grid.getDimension(); i += 1) {
					buffer.append("||----");
				}
				buffer.append("||").append("\n");
			}
		}
		return buffer.toString();
	}

	// TODO Move to GameBoard (w/ the render method)
	protected String computeFirstCellDigit(int id) {
		return Integer.toString(id / 10);
	}

	// TODO Move to GameBoard (w/ the render method)
	protected String computeSecondCellDigit(int id) {
		return Integer.toString(id % 10);
	}
}
