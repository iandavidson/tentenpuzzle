package com.davidsoncamp.tenten.util;

/**
 * Represents an individual element w/in the game that has a unique identifier (id) and integer value (value)
 * 
 * @author scdavidson
 *
 */
public class Cell {

	// TODO Replace assigned and most recently assigned w/ a single integer value
	private boolean mostRecentlyAssigned;
	private boolean assigned;
	private final int id;

	public static Cell copyCell(Cell cell) {
		Cell newCell = new Cell(cell.getId());
		newCell.setAssigned(cell.isAssigned());
		newCell.setMostRecentlyAssigned(cell.isMostRecentlyAssigned());
		return newCell;
	}

	public static Cell newCell(int id) {
		return new Cell(id);
	}
	
	public boolean isMostRecentlyAssigned() {
		return mostRecentlyAssigned;
	}

	public void setMostRecentlyAssigned(boolean mostRecentlyAssigned) {
		this.mostRecentlyAssigned = mostRecentlyAssigned;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public int getId() {
		return id;
	}

	private Cell(int id) {
		this.id = id;
		this.assigned = false;
		this.mostRecentlyAssigned = false;
	}

}
