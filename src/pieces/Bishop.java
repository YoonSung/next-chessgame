package pieces;

import java.util.List;


public class Bishop extends Piece {
	
	private Position position;
	
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
		this.position = position;
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position);
		return posControl.findsDiagonalPositionAll();
	}
}