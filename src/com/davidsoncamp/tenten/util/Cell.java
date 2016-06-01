package com.davidsoncamp.tenten.util;

public class Cell {

	private boolean assigned;
	private int id;
	
	public static Cell newCell(int id){
		return new Cell(id);
	}
	
	public void renderCell(){
		
	}

	private Cell(int id){
		this.id = id;
		this.assigned = false;
	}
	
}
