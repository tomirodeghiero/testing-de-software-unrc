package assignment9_exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ThreesBoardInputDomainCharacterizationTest {

	private ThreesBoard board;

	@BeforeEach
	void setUp() {
		board = new ThreesBoard();
	}

	@ParameterizedTest(name = "setTile({0},{1},{2}) fuera de rango debe fallar")
	@CsvSource({
		"-1, 0, 1",
		"0, -1, 1",
		"4, 0, 1",
		"0, 4, 1"
	})
	@DisplayName("setTile rechaza indices fuera del tablero")
	void setTileRejectsOutOfRangeCoordinates(int row, int col, int value) {
		assertThrows(IllegalArgumentException.class, () -> board.setTile(row, col, value));
	}

	@ParameterizedTest(name = "getTile({0},{1}) fuera de rango debe fallar")
	@CsvSource({
		"-1, 0",
		"0, -1",
		"4, 0",
		"0, 4"
	})
	@DisplayName("getTile rechaza indices fuera del tablero")
	void getTileRejectsOutOfRangeCoordinates(int row, int col) {
		assertThrows(IllegalArgumentException.class, () -> board.getTile(row, col));
	}

	@Test
	@DisplayName("setTile/getTile actualizan y recuperan el valor en celda valida")
	void setAndGetTileWithinBounds() {
		board.setTile(2, 3, 6);
		assertEquals(6, board.getTile(2, 3).getValue());
	}

	@Test
	@DisplayName("constructor aleatorio con totalTiles setea exactamente esa cantidad")
	void constructorWithTotalTilesSetsExactAmount() {
		ThreesBoard randomBoard = new ThreesBoard(9);
		assertEquals(9, randomBoard.numberOfSetTiles());
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
				int value = randomBoard.getTile(i, j).getValue();
				assertTrue(value == 0 || value == 1 || value == 2 || value == 3);
			}
		}
	}

	@ParameterizedTest(name = "constructor({0})")
	@CsvSource({
		"-1",
		"17"
	})
	@DisplayName("constructor aleatorio rechaza cantidades invalidas")
	void constructorRejectsInvalidTotalTiles(int totalTiles) {
		assertThrows(IllegalArgumentException.class, () -> new ThreesBoard(totalTiles));
	}

	@Test
	@DisplayName("numberOfSetTiles cuenta correctamente celdas no vacias")
	void numberOfSetTilesCountsNonFreeTiles() {
		load(new int[][] {
			{0, 1, 0, 0},
			{2, 0, 3, 0},
			{0, 6, 0, 0},
			{0, 0, 0, 12}
		});

		assertEquals(5, board.numberOfSetTiles());
	}

	@ParameterizedTest(name = "canTilesCombine({0},{1}) => {2}")
	@CsvSource({
		"1,2,true",
		"2,1,true",
		"3,3,true",
		"6,6,true",
		"1,1,false",
		"2,2,false",
		"3,6,false",
		"0,3,false",
		"0,0,false"
	})
	@DisplayName("canTilesCombine respeta reglas de combinacion")
	void canTilesCombineMatchesRules(int a, int b, boolean expected) {
		assertEquals(expected, board.canTilesCombine(new ThreesTile(a), new ThreesTile(b)));
	}

	@Test
	@DisplayName("canTilesCombine rechaza null")
	void canTilesCombineRejectsNullTiles() {
		assertThrows(IllegalArgumentException.class, () -> board.canTilesCombine(null, new ThreesTile(1)));
		assertThrows(IllegalArgumentException.class, () -> board.canTilesCombine(new ThreesTile(1), null));
	}

	@Test
	@DisplayName("tablero vacio no permite movimientos y esta finalizado")
	void emptyBoardHasNoMovesAndIsFinished() {
		assertFalse(board.canMoveLeft());
		assertFalse(board.canMoveRight());
		assertFalse(board.canMoveUp());
		assertFalse(board.canMoveDown());
		assertTrue(board.isFinished());
	}

	@Test
	@DisplayName("movimientos por huecos detectados en cada direccion")
	void movementByGapsIsDetectedPerDirection() {
		load(new int[][] {
			{0, 1, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0}
		});
		assertTrue(board.canMoveLeft());
		assertTrue(board.canMoveRight());
		assertFalse(board.canMoveUp());
		assertTrue(board.canMoveDown());
	}

	@Test
	@DisplayName("movimientos por combinacion detectados en cada direccion")
	void movementByCombinationIsDetectedPerDirection() {
		load(new int[][] {
			{1, 2, 0, 0},
			{0, 0, 0, 0},
			{3, 0, 0, 0},
			{3, 0, 0, 0}
		});
		assertTrue(board.canMoveLeft());
		assertTrue(board.canMoveRight());
		assertTrue(board.canMoveUp());
		assertTrue(board.canMoveDown());
		assertFalse(board.isFinished());
	}

	@Test
	@DisplayName("tablero lleno sin huecos ni combinaciones queda finalizado")
	void fullBoardWithoutCombinationsIsFinished() {
		load(new int[][] {
			{3, 6, 12, 24},
			{48, 96, 192, 384},
			{768, 1536, 3072, 6144},
			{12288, 24576, 49152, 98304}
		});
		assertFalse(board.canMoveLeft());
		assertFalse(board.canMoveRight());
		assertFalse(board.canMoveUp());
		assertFalse(board.canMoveDown());
		assertTrue(board.isFinished());
	}

	@Test
	@DisplayName("computeScore suma 3 para valor 3 y (v-3)*3 para valores mayores")
	void computeScoreFollowsImplementedRules() {
		load(new int[][] {
			{0, 1, 2, 3},
			{6, 12, 0, 0},
			{0, 0, 24, 0},
			{0, 0, 0, 0}
		});
		int expected = 3 + ((6 - 3) * 3) + ((12 - 3) * 3) + ((24 - 3) * 3);
		assertEquals(expected, board.computeScore());
	}

	private void load(int[][] values) {
		for (int i = 0; i < ThreesBoard.ROWS; i++) {
			for (int j = 0; j < ThreesBoard.COLUMNS; j++) {
				board.setTile(i, j, values[i][j]);
			}
		}
	}
}
