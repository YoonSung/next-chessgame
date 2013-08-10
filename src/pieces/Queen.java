package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	
	private Position position;
	
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
		this.position = position;
	}

	@Override
	List<Position> getPossibleMoves() {
		ArrayList<Position> moves = new ArrayList<Position>();
		PositionController posControl = new PositionController(position);
		moves.addAll(posControl.findsDiagonalPositionAll());
		moves.addAll(posControl.findsLinearPositionAll());
		return moves;
	}
}
