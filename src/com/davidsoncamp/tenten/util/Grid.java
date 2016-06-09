package com.davidsoncamp.tenten.util;

import java.util.ArrayList;
import java.util.List;

import com.davidsoncamp.tenten.util.Pieces.Piece;
import com.davidsoncamp.tenten.util.Pieces.RelativeCellPosition;

public class Grid {

	private final int dimension;
	private List<Cell> cells;

	public static Grid newGrid(int dimension) {
		return new Grid(dimension);
	}

	public static Grid newGrid(int dimension, List<Cell> cells) {
		return new Grid(dimension, cells);
	}

	public static Grid newGrid(Grid grid) {

		// Copy the cells
		List<Cell> newCells = new ArrayList<Cell>();
		for (int i = 0; i < grid.dimension * grid.dimension; i++) {
			newCells.add(Cell.copyCell((grid.getCell(i))));
		}

		return newGrid(grid.dimension, newCells);
	}

	public Grid placePiece(RelativeCellPosition basePosition, Piece piece) {

		// Copy the current Grid
		Grid newGrid = newGrid(this);

		Cell cell = newGrid.getCell(basePosition, Pieces.RelativeCellPosition.UNITY_CELL_POSITION);
		cell.setAssigned(true);

		// Iterate through the positions in the piece and add them to the new
		// Grid
		if (null != piece.getRelativeCellPositions()) {
			for (RelativeCellPosition pieceOffset : piece.getRelativeCellPositions()) {

				// IAN
				// Assign the cell of the piece
				cell = newGrid.getCell(basePosition, pieceOffset);
				cell.setAssigned(true);

			}
		}
		return newGrid;
	}

	public void setAssigned(int cellId, boolean assigned) {
		getCell(cellId).setAssigned(assigned);
	}

	public void setMostRecentlyAssigned(int cellId, boolean assigned) {
		getCell(cellId).setMostRecentlyAssigned(assigned);
	}

	public String render() {
		StringBuffer buffer = new StringBuffer();

		for (int row = 0; row < dimension; row += 1) {

			for (int cellrow = 0; cellrow < 3; cellrow += 1) {

				for (int col = 0; col < dimension; col += 1) {

					boolean assigned = this.cells.get(row * this.dimension + col).isAssigned();
					boolean mostRecentlyAssigned = this.cells.get(row * this.dimension + col).isMostRecentlyAssigned();
					int cellId = this.cells.get(row * this.dimension + col).getId();
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
			if (row == dimension - 1) {
				for (int i = 0; i < dimension; i += 1) {
					buffer.append("||----");
				}
				buffer.append("||").append("\n");
			}
		}
		return buffer.toString();
	}

	protected String computeFirstCellDigit(int id) {
		return Integer.toString(id / 10);
	}

	protected String computeSecondCellDigit(int id) {
		return Integer.toString(id % 10);
	}

	protected Cell getCell(int cellId) {
		return this.cells.get(cellId);
	}

	protected Cell getCell(RelativeCellPosition basePosition, RelativeCellPosition pieceOffset) {

		// Calculate the cell id based on basePosition and offset
		int row = basePosition.getRow() + pieceOffset.getRow();
		int col = basePosition.getCol() + pieceOffset.getCol();
		int cellId = row * this.dimension + col;

		return getCell(cellId);
	}

	private Grid(int dimension) {
		this.dimension = dimension;

		// Create the initial grid w/ unassigned cells
		this.cells = new ArrayList<Cell>(dimension * dimension);
		for (int row = 0; row < this.dimension; row++) {

			for (int column = 0; column < this.dimension; column++) {

				this.cells.add(Cell.newCell(row * this.dimension + column));
			}
		}
	}

	private Grid(int dimension, List<Cell> cells) {
		this.dimension = dimension;
		this.cells = cells;
	}

}
