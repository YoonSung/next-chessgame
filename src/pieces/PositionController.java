package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsAllPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsAllPosition(direction));
		}
		return positions;
	}
	
	public List<Position> findsLinearPosition() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.add(position.move(direction));
		}
		return positions;
	}

	
	public List<Position> findsDiagonalPosition() {
		Direction[] linears = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.add(position.move(direction));
		}
		return positions;
	}

	public List<Position> findPositions(Direction[] directions) {
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : directions) {
			positions.add(position.move(direction));
		}
		return positions;
	}
}
