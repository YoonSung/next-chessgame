package pieces;

public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1),
	
	SOUTHSOUTH(0, -2),
	NORTHNORTH(0, 2);
	
	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}
	
	public static Direction[] linearDirection() {
		return new Direction[] { NORTH, EAST, SOUTH, WEST };
	}

	public static Direction[] diagonalDirection() {
		return new Direction[] { NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	}

	
	public static Direction[] blackPawnStartDirection() {
		return new Direction[] {SOUTH, SOUTHSOUTH};
	}

	public static Direction[] whitePawnStartDirection() {
		return new Direction[] {NORTH, NORTHNORTH};
	}

	public static Direction[] whitePawnDirection() {
		return new Direction[] {NORTH};
	}

	public static Direction[] blackPawnDirection() {
		return new Direction[] {SOUTH};
	}
}
