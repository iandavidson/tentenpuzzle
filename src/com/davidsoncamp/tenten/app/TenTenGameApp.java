package com.davidsoncamp.tenten.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.davidsoncamp.tenten.util.Grid;
import com.davidsoncamp.tenten.util.Pieces;
import com.davidsoncamp.tenten.util.Pieces.RelativeCellPosition;

public class TenTenGameApp {

	public static Random RANDOM = new Random();

	public static void main(String[] args) {

		// Instantiate app
		TenTenGameApp app = new TenTenGameApp();

		// Run the game
		app.run();

	}

	public void run() {

		// Construct the initial game grid
		Grid grid = Grid.newGrid(10);

		// Loop until game is finished
		boolean continuePlay = true;
		List<Pieces.Piece> currentPieces = new ArrayList<Pieces.Piece>();
		while (continuePlay) {

			// If there are no more current pieces, get the next three
			if (currentPieces.isEmpty()) {
				currentPieces = nextThreePieces();
			}

			// Display the current (score and) grid
			System.out.println(getCurrentGridDisplay(grid));
			System.out.println("\n\n");

			// Display the current selectable pieces
			System.out.println(getSelectablePiecesDisplay(currentPieces));

			// Get the piece selection from the player
			int pieceSelection;
			int rowSelection;
			int colSelection;
			try {

				System.out.println("Please select a piece: ");
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(System.in));
				pieceSelection = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Please specify row position of piece: ");
				rowSelection = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Please specify col position of piece: ");
				colSelection = Integer.parseInt(bufferedReader.readLine());

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}

			// Place the piece
			grid = grid.placePiece(RelativeCellPosition.newRelativeCellPosition(rowSelection,colSelection), 
					currentPieces.get(pieceSelection));
			System.out.println("Placing : "
					+ currentPieces.get(pieceSelection).getName() + " @ ("
					+ rowSelection + "," + colSelection + ")");
			currentPieces.remove(pieceSelection);

		}

	}

	protected List<Pieces.Piece> nextThreePieces() {

		// Randomly pick three pieces
		List<Pieces.Piece> pieces = new ArrayList<Pieces.Piece>(3);
		for (int i = 0; i < 3; i++) {
			int pieceIndex = RANDOM.nextInt(Pieces.PIECES.size());
			pieces.add(Pieces.PIECES.get(pieceIndex));
		}

		return pieces;

	}

	protected String getCurrentGridDisplay(Grid grid) {

		StringBuffer scoreAndGridBuffer = new StringBuffer();

		// Add the Score
		scoreAndGridBuffer.append("*** SCORE: ").append(grid.getScore())
				.append(" ***");
		scoreAndGridBuffer.append("\n\n\n");

		// Add the rendered Grid
		scoreAndGridBuffer.append(grid.render());

		return scoreAndGridBuffer.toString();
	}

	protected String getSelectablePiecesDisplay(
			List<Pieces.Piece> selectablePieces) {

		StringBuffer selectablePiecesBuffer = new StringBuffer();
		for (int i = 0; i < selectablePieces.size(); i++) {
			selectablePiecesBuffer.append("(" + i + ") ")
					.append(selectablePieces.get(i).getName()).append("\n");

		}

		return selectablePiecesBuffer.toString();
	}
}
