package com.davidsoncamp.tenten.util;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	private final int dimension;
	private List<Cell> cells;

	public static Grid newGrid(int dimension) {
		return new Grid(dimension);
	}

	public void setAssigned(int cellId,boolean assigned) {
		getCell(cellId).setAssigned(assigned);
	}

	public void setMostRecentlyAssigned(int cellId,boolean assigned) {
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

	protected String computeFirstCellDigit(int id){
		return Integer.toString(id/10);
	}
	
	protected String computeSecondCellDigit(int id){
		return Integer.toString(id%10);
	}

	protected Cell getCell(int cellId){
		return this.cells.get(cellId);
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

}
