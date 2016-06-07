package com.davidsoncamp.tenten.util;

public class Cell {

	private boolean mostRecentlyAssigned;
	private boolean assigned;
	private final int id;

	public boolean isMostRecentlyAssigned() {
		return mostRecentlyAssigned;
	}

	public void setMostRecentlyAssigned(boolean mostRecentlyAssigned) {
		this.mostRecentlyAssigned = mostRecentlyAssigned;
	}


	public static Cell newCell(int id) {
		return new Cell(id);
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
