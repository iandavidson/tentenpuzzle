package com.davidsoncamp.tenten.util;

import java.util.Random;

public class TestRenderMain {

	public static void main(String[] args) {
		System.out.println("||----||----||");
		System.out.println("|| 0  || 0  ||");
		System.out.println("||  0 ||  1 ||");
		System.out.println("||----||----||");
		System.out.println("+++++++++++++++++");
		System.out.println("||----||----||");
		System.out.println("|| ** || ** ||");
		System.out.println("|| ** || ** ||");
		System.out.println("||----||----||");
		System.out.println("|| ** || 0  ||");
		System.out.println("|| ** ||  1 ||");
		System.out.println("||----||----||");

		int dimension = 10;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		for (int row = 0; row < dimension; row += 1) {

			for (int cellrow = 0; cellrow < 3; cellrow += 1) {

				// Assigned or Unassigned
				boolean assigned = random.nextInt(2) == 0 ? true : false;

				
				for (int col = 0; col < dimension; col += 1) {

					if (cellrow == 0) {
						buffer.append("||----");
					}

					else if (cellrow == 1) {
						if (assigned) {
							buffer.append("|| ** ");

						} else {
							buffer.append("|| ").append(row).append("  ");
						}
					} else if (cellrow == 2) {
						if (assigned) {
							buffer.append("|| ** ");

						} else {
							buffer.append("||  ").append(col).append(" ");
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
		System.out.print(buffer.toString());
		
		
		Grid grid = Grid.newGrid(10);
		
		for(int x = 0; x < 10; x+=1){
			grid.setAssigned(x*10 + x, true);
			grid.setMostRecentlyAssigned(x*10 + 6, true);
		}
		System.out.print(grid.render());
	}
}
