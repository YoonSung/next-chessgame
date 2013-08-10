package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	
	private Position position;
	
	public King(Color color, Position position) {
		super(color, Type.KING, position);
		this.position = position;
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position);
		ArrayList<Position> moves = new ArrayList<Position>();
		moves.addAll(posControl.findsLinearPosition());
		moves.addAll(posControl.findsDiagonalPosition());
		
		return moves;
	}
}

