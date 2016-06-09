package com.davidsoncamp.tenten.util;

import java.util.Arrays;
import java.util.List;

public class Pieces {

	
	//format is (row, col), (0, 0) is also always included by default
	
	//square pieces
	public static Piece ONE_BY_ONE = Piece.newPiece(null);
	public static Piece TWO_BY_TWO = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(1, 1)));
	public static Piece THREE_BY_THREE = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(0, 2),
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(1, 1),
			RelativeCellPosition.newRelativeCellPosition(1, 2),
			RelativeCellPosition.newRelativeCellPosition(2, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 1),
			RelativeCellPosition.newRelativeCellPosition(2, 2)));
	
	//corner pieces
	public static Piece TOP_LEFT_ELBOW_BIG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(0, 2),
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 0)));
	public static Piece TOP_LEFT_ELBOW_SMALL = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(1, 0)));
	public static Piece TOP_RIGHT_ELBOW_BIG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(0, 2),
			RelativeCellPosition.newRelativeCellPosition(1, 2),
			RelativeCellPosition.newRelativeCellPosition(2, 2)));
	public static Piece TOP_RIGHT_ELBOW_SMALL = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(1, 1)));
	public static Piece LOW_LEFT_ELBOW_BIG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(2, 1),
			RelativeCellPosition.newRelativeCellPosition(2, 2),
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 0)));
	public static Piece LOW_LEFT_ELBOW_SMALL = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(1, 1),
			RelativeCellPosition.newRelativeCellPosition(1, 0)));
	public static Piece LOW_RIGHT_ELBOW_BIG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(2, -1),
			RelativeCellPosition.newRelativeCellPosition(2, -2),
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 0)));
	public static Piece LOW_RIGHT_ELBOW_SMALL = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(1, -1),
			RelativeCellPosition.newRelativeCellPosition(1, 0)));
	
	//straight Pieces
	public static Piece HORIZONTAL_TWO_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1)));
	public static Piece HORIZONTAL_THREE_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(0, 2)));
	public static Piece HORIZONTAL_FOUR_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(0, 2),
			RelativeCellPosition.newRelativeCellPosition(0, 3)));
	public static Piece HORIZONTAL_FIVE_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(0, 2),
			RelativeCellPosition.newRelativeCellPosition(0, 3),
			RelativeCellPosition.newRelativeCellPosition(0, 4)));
	public static Piece VERTICAL_TWO_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(1, 0)));
	public static Piece VERTICAL_THREE_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 0)));
	public static Piece VERTICAL_FOUR_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 0),
			RelativeCellPosition.newRelativeCellPosition(3, 0)));
	public static Piece VERTICAL_FIVE_LONG = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(2, 0),
			RelativeCellPosition.newRelativeCellPosition(3, 0),
			RelativeCellPosition.newRelativeCellPosition(4, 0)));
	
	
	
	public static List<Piece> PIECES = Arrays.asList(ONE_BY_ONE, TWO_BY_TWO, THREE_BY_THREE, TOP_LEFT_ELBOW_BIG,
			TOP_LEFT_ELBOW_BIG, TOP_RIGHT_ELBOW_BIG, TOP_RIGHT_ELBOW_SMALL, LOW_LEFT_ELBOW_BIG,LOW_LEFT_ELBOW_SMALL,
			LOW_RIGHT_ELBOW_BIG, LOW_RIGHT_ELBOW_SMALL, HORIZONTAL_TWO_LONG, HORIZONTAL_THREE_LONG,
			HORIZONTAL_FOUR_LONG, HORIZONTAL_FIVE_LONG, VERTICAL_TWO_LONG, VERTICAL_THREE_LONG,
			VERTICAL_FOUR_LONG, VERTICAL_FIVE_LONG);

	public static class RelativeCellPosition {
		
		private static RelativeCellPosition newRelativeCellPosition(int row,
				int col) {
			return new RelativeCellPosition(row, col);
		}

		public static final RelativeCellPosition UNITY_CELL_POSITION = new RelativeCellPosition(0, 0);
		private final int row;
		private final int col;

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}

		private RelativeCellPosition(int row, int col) {
			this.row = row;
			this.col = col;

		}
	}

	public static class Piece {

		public static Piece newPiece(
				List<RelativeCellPosition> relativeCellPositions) {
			return new Piece(relativeCellPositions);
		}

		private final List<RelativeCellPosition> relativeCellPositions;

		public List<RelativeCellPosition> getRelativeCellPositions() {
			return this.relativeCellPositions;
		}

		private Piece(List<RelativeCellPosition> relativeCellPositions) {
			this.relativeCellPositions = relativeCellPositions;
		}
	}

}
