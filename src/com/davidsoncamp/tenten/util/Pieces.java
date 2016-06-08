package com.davidsoncamp.tenten.util;

import java.util.Arrays;
import java.util.List;

public class Pieces {

	public static Piece ONE_BY_ONE = Piece.newPiece(null);
	public static Piece TWO_BY_TWO = Piece.newPiece(Arrays.asList(
			RelativeCellPosition.newRelativeCellPosition(0, 1),
			RelativeCellPosition.newRelativeCellPosition(1, 0),
			RelativeCellPosition.newRelativeCellPosition(1, 1)));

	public static List<Piece> PIECES = Arrays.asList(ONE_BY_ONE, TWO_BY_TWO);

	public static class RelativeCellPosition {

		private static RelativeCellPosition newRelativeCellPosition(int row,
				int col) {
			return new RelativeCellPosition(row, col);
		}

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
