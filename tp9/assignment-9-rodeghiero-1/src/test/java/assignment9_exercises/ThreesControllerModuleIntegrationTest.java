package assignment9_exercises;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ThreesControllerModuleIntegrationTest {

	private ThreesBoard board;

	@BeforeEach
	void setUp() {
		board = new ThreesBoard();
	}

	@Test
	@DisplayName("constructor por defecto: tablero inicial con 9 baldosas y nextTile valido")
	void defaultConstructorCreatesExpectedInitialState() {
		ThreesController controller = new ThreesController();
		ThreesBoard initialBoard = controller.getBoard();
		assertEquals(9, initialBoard.numberOfSetTiles());
		int next = controller.getNextTileValue();
		assertTrue(next >= 1 && next <= 3);
	}

	@ParameterizedTest(name = "{0} sin cambios")
	@MethodSource("noChangeMoves")
	@DisplayName("si no hay cambios, cualquier movimiento retorna false y conserva estado")
	void noChangeMoveKeepsBoardAndNextTile(String name, MoveExecutor moveExecutor) {
		load(board, new int[][] {
			{3, 6, 12, 24},
			{48, 96, 192, 384},
			{768, 1536, 3072, 6144},
			{12288, 24576, 49152, 98304}
		});
		board.generator = new SequenceRandomGenerator(1);
		ThreesController controller = new ThreesController(board);
		int nextBefore = controller.getNextTileValue();
		int[][] before = snapshot(board);

		boolean moved = moveExecutor.execute(controller);

		assertFalse(moved);
		assertEquals(nextBefore, controller.getNextTileValue());
		assertBoardEquals(before, board);
	}

	@Test
	@DisplayName("moveLeft: combina, desplaza y carga nueva baldosa en borde derecho")
	void moveLeftCombinesShiftsAndLoadsNextTileOnRightEdge() {
		load(board, new int[][] {
			{0, 1, 2, 0},
			{3, 3, 0, 0},
			{6, 12, 0, 0},
			{0, 0, 0, 0}
		});
		board.generator = new SequenceRandomGenerator(
			1, // constructor: nextTileValue = 2
			1, // moveLeft: elige movedRows[1] => fila 1
			0  // nuevo nextTileValue = 1
		);
		ThreesController controller = new ThreesController(board);

		boolean moved = controller.moveLeft();

		assertTrue(moved);
		assertBoardEquals(new int[][] {
			{3, 0, 0, 0},
			{6, 0, 0, 2},
			{6, 12, 0, 0},
			{0, 0, 0, 0}
		}, board);
		assertEquals(1, controller.getNextTileValue());
	}

	@Test
	@DisplayName("moveRight: combina caso 2+1 y carga nueva baldosa en borde izquierdo")
	void moveRightCombinesTwoPlusOneAndLoadsNextTileOnLeftEdge() {
		load(board, new int[][] {
			{0, 0, 1, 2},
			{0, 0, 3, 3},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		});
		board.generator = new SequenceRandomGenerator(
			2, // constructor: nextTileValue = 3
			0, // moveRight: movedRows[0] => fila 0
			1  // nuevo nextTileValue = 2
		);
		ThreesController controller = new ThreesController(board);

		boolean moved = controller.moveRight();

		assertTrue(moved);
		assertBoardEquals(new int[][] {
			{3, 0, 0, 3},
			{0, 0, 0, 6},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		}, board);
		assertEquals(2, controller.getNextTileValue());
	}

	@Test
	@DisplayName("moveUp: combina y carga nueva baldosa en fila inferior")
	void moveUpCombinesAndLoadsNextTileOnBottomRow() {
		load(board, new int[][] {
			{0, 3, 0, 0},
			{1, 3, 0, 0},
			{2, 0, 0, 0},
			{0, 0, 0, 0}
		});
		board.generator = new SequenceRandomGenerator(
			2, // constructor: nextTileValue = 3
			0, // moveUp: movedColumns[0] => columna 0
			1  // nuevo nextTileValue = 2
		);
		ThreesController controller = new ThreesController(board);

		boolean moved = controller.moveUp();

		assertTrue(moved);
		assertBoardEquals(new int[][] {
			{3, 6, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{3, 0, 0, 0}
		}, board);
		assertEquals(2, controller.getNextTileValue());
	}

	@Test
	@DisplayName("moveDown: combina y carga nueva baldosa en fila superior")
	void moveDownCombinesAndLoadsNextTileOnTopRow() {
		load(board, new int[][] {
			{0, 0, 0, 0},
			{2, 0, 0, 0},
			{1, 3, 0, 0},
			{0, 3, 0, 0}
		});
		board.generator = new SequenceRandomGenerator(
			0, // constructor: nextTileValue = 1
			1, // moveDown: movedColumns[1] => columna 1
			2  // nuevo nextTileValue = 3
		);
		ThreesController controller = new ThreesController(board);

		boolean moved = controller.moveDown();

		assertTrue(moved);
		assertBoardEquals(new int[][] {
			{0, 1, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{3, 6, 0, 0}
		}, board);
		assertEquals(3, controller.getNextTileValue());
	}

	@Test
	@DisplayName("test de modulo: dos movimientos diferentes en secuencia")
	void sequentialDifferentMovesBehaveConsistently() {
		load(board, new int[][] {
			{1, 2, 0, 0},
			{0, 3, 3, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		});
		board.generator = new SequenceRandomGenerator(
			0, // constructor: nextTileValue = 1
			0, // moveLeft: movedRows[0] => fila 0
			2, // nuevo nextTileValue = 3
			0, // moveDown: movedColumns[0] => columna 0
			1  // nuevo nextTileValue = 2
		);
		ThreesController controller = new ThreesController(board);

		boolean leftMoved = controller.moveLeft();
		boolean downMoved = controller.moveDown();

		assertTrue(leftMoved);
		assertTrue(downMoved);
		assertBoardEquals(new int[][] {
			{3, 0, 0, 0},
			{0, 0, 0, 0},
			{3, 0, 0, 0},
			{6, 0, 0, 1}
		}, board);
		assertEquals(2, controller.getNextTileValue());
	}

	private void load(ThreesBoard boardToLoad, int[][] values) {
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
				boardToLoad.setTile(i, j, values[i][j]);
			}
		}
	}

	private int[][] snapshot(ThreesBoard sourceBoard) {
		int[][] snap = new int[ThreesBoard.ROWS][ThreesBoard.COLUMNS];
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
				snap[i][j] = sourceBoard.getTile(i, j).getValue();
			}
		}
		return snap;
	}

	private void assertBoardEquals(int[][] expected, ThreesBoard actualBoard) {
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			int[] actualRow = new int[ThreesBoard.COLUMNS];
			for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
				actualRow[j] = actualBoard.getTile(i, j).getValue();
			}
			assertArrayEquals(expected[i], actualRow, "Fila " + i + " distinta");
		}
	}

	private static class SequenceRandomGenerator implements RandomGenerator {
		private final int[] sequence;
		private int index;

		SequenceRandomGenerator(int... sequence) {
			this.sequence = sequence;
			this.index = 0;
		}

		@Override
		public int getRandom(int bound) {
			if (bound <= 0) {
				throw new IllegalArgumentException("bound must be positive");
			}
			if (index >= sequence.length) {
				return 0;
			}
			int value = sequence[index++];
			return Math.floorMod(value, bound);
		}
	}

	private static Stream<Arguments> noChangeMoves() {
		return Stream.of(
			Arguments.of("moveLeft", (MoveExecutor) ThreesController::moveLeft),
			Arguments.of("moveRight", (MoveExecutor) ThreesController::moveRight),
			Arguments.of("moveUp", (MoveExecutor) ThreesController::moveUp),
			Arguments.of("moveDown", (MoveExecutor) ThreesController::moveDown)
		);
	}

	@FunctionalInterface
	private interface MoveExecutor {
		boolean execute(ThreesController controller);
	}
}
