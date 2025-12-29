public class Board
{
    public char emptyCellMarker = '-';
    public char[][] board;

    public Board()
    {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = emptyCellMarker;
            }
        }
    }

    public char getEmptyCellMarker()
    {
        return emptyCellMarker;
    }

    public void placeMarker(int row, int col, char marker)
    {
        board[row][col] = marker;
    }

    public boolean isCellEmpty(int row, int col)
    {
        if (board[row][col] == emptyCellMarker)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void displayBoard()
    {
        System.out.println("\n  0 1 2");

        for (int i = 0; i < board.length; i++)
        {
            System.out.print(i + " "); // printing index of row

            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j]); // printing marker

                if (j < board[i].length - 1)
                {
                    System.out.print("|"); // printing separator
                }
            }
            System.out.println(); // goes to next line

            if (i < board.length - 1)
            {
                System.out.println("  -----"); // separator
            }
        }
        System.out.println(); // extra line for spacing
    }

    public char getMarkerAt(int i, int j)
    {
        return board[i][j];
    }
}
