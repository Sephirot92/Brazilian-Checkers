package checkersTests.board;

import checkers.board.Board;
import checkers.board.pawns.FigureColor;
import org.junit.*;

public class BoardTestSuite {
    @Before
    public void before() {
        System.out.println("BoardTestSuite: begin");
    }

    @After
    public void after() {
        System.out.println("BoardTestSuite: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testInitBoard() {
        //Given
        Board board = new Board();
        board.initBoard();
        board.getRows();

        //When
        int totalPawns = 0;
        for (int row = 0; row < board.getRows().size(); row++) {
            for (int col = 0; col < board.getRows().get(row).getCols().size(); col++) {
                if (board.getRows().get(row).getCols().get(col).getColor().equals(FigureColor.RED) || board.getRows().get(row).getCols().get(col).getColor().equals(FigureColor.BLACK)) {
                    totalPawns = totalPawns + 1;
                }
            }
        }
        //Then
        Assert.assertEquals(24, totalPawns);
    }

    @Test
    public void testRedCheckersNumber() {
        //Given
        Board board = new Board();
        board.initBoard();
        board.getRows();

        //When
        int redPawns = 0;
        for (int row = 0; row < board.getRows().size(); row++) {
            for (int col = 0; col < board.getRows().get(row).getCols().size(); col++) {
                if (board.getRows().get(row).getCols().get(col).getColor().equals(FigureColor.RED)) {
                    redPawns = redPawns + 1;
                }
            }
        }
        //Then
        Assert.assertEquals(12, redPawns);
    }

    @Test
    public void testBlackCheckersNumber() {
        //Given
        Board board = new Board();
        board.initBoard();
        board.getRows();

        //When
        int blackPawns = 0;
        for (int row = 0; row < board.getRows().size(); row++) {
            for (int col = 0; col < board.getRows().get(row).getCols().size(); col++) {
                if (board.getRows().get(row).getCols().get(col).getColor().equals(FigureColor.BLACK)) {
                    blackPawns = blackPawns + 1;
                }
            }
        }
        //Then
        Assert.assertEquals(12, blackPawns);
    }
}
