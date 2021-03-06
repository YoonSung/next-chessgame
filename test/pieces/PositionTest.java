package pieces;

import junit.framework.TestCase;

public class PositionTest extends TestCase {
	public void testCreate() throws Exception {
		Position position = new Position("a8");
		assertEquals(0, position.getX());
		assertEquals(7, position.getY());

		position = new Position("e2");
		assertEquals(4, position.getX());
		assertEquals(1, position.getY());
	}

	public void testMoveOneRoom() throws Exception {
		int startX = 4;
		int startY = 5;
		Position source = new Position(startX, startY);
		assertEquals(new Position(startX, startY + 1), source.move(Direction.NORTH));
		assertEquals(new Position(startX, startY - 1), source.move(Direction.SOUTH));
		assertEquals(new Position(startX + 1, startY), source.move(Direction.EAST));
		assertEquals(new Position(startX - 1, startY), source.move(Direction.WEST));
	}

	public void testMoveDiagonal() throws Exception {
		int startX = 4;
		int startY = 5;
		Position source = new Position(startX, startY);
		assertEquals(new Position(startX + 1, startY + 1), source.move(Direction.NORTH_EAST));
		assertEquals(new Position(startX - 1, startY + 1), source.move(Direction.NORTH_WEST));
		assertEquals(new Position(startX + 1, startY - 1), source.move(Direction.SOUTH_EAST));
		assertEquals(new Position(startX - 1, startY - 1), source.move(Direction.SOUTH_WEST));
	}

	public void testFindsLinearPosition() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);
		verifyPositions(position, Direction.NORTH, 2);
		verifyPositions(position, Direction.SOUTH, 5);
	}

	public void testFindsDiagonalPosition() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);
		verifyPositions(position, Direction.NORTH_EAST, 2);
		verifyPositions(position, Direction.NORTH_WEST, 2);
		verifyPositions(position, Direction.SOUTH_EAST, 3);
		verifyPositions(position, Direction.SOUTH_WEST, 4);
	}

	private void verifyPositions(Position position, Direction direction, int expectedSize) {
		assertEquals(expectedSize, position.findsAllPosition(direction).size());
	}

	public void testIsValid() throws Exception {
		assertTrue(new Position(0, 0).isValid());
		assertTrue(new Position(0, 7).isValid());
		assertTrue(new Position(7, 0).isValid());
		assertTrue(new Position(7, 7).isValid());
		assertFalse(new Position(0, -1).isValid());
		assertFalse(new Position(0, 8).isValid());
		assertFalse(new Position(-1, 0).isValid());
		assertFalse(new Position(8, 0).isValid());
	}
}