package pieces;

import java.util.List;

public class Knight extends Piece {
	
	private Position position;
	
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
		this.position = position;
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController posControl = new PositionController(position);
		return posControl.findPosition(Direction.KnightDirection());
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}
}
