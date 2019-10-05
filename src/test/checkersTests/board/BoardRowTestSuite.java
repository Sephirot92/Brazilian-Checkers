package checkersTests.board;


import checkers.board.BoardRow;
import org.junit.Assert;
import org.junit.Test;

public class BoardRowTestSuite {
    @Test
    public void testGetBoardRow() {
        //Given
        BoardRow boardRow = new BoardRow();

        //When
        int numberOfCols = boardRow.getCols().size();

        //Then
        Assert.assertEquals(8, numberOfCols);
    }

}
