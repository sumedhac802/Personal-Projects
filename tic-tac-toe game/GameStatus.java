public class GameStatus implements GameChecker
{
    private final int running = 0;
    private final int win = 1;
    private final int tie = 2;

    public GameStatus()
    {
       
    }

    
    @Override
    public int checkStatus(Board board, char marker)
    {
        // checking rows and columns
        for (int i = 0; i < 3; i++)
        {
            // row i
            if (board.getMarkerAt(i, 0) == marker &&
                board.getMarkerAt(i, 1) == marker &&
                board.getMarkerAt(i, 2) == marker)
            {
                return win;
            }

            // column i
            if (board.getMarkerAt(0, i) == marker &&
                board.getMarkerAt(1, i) == marker &&
                board.getMarkerAt(2, i) == marker)
            {
                return win;
            }
        }

        // diagonal #1 (top left to bottom right)
        if (board.getMarkerAt(0, 0) == marker &&
            board.getMarkerAt(1, 1) == marker &&
            board.getMarkerAt(2, 2) == marker)
        {
            return win;
        }

        // diagonal #2 (top right to bottom left)
        if (board.getMarkerAt(0, 2) == marker &&
            board.getMarkerAt(1, 1) == marker &&
            board.getMarkerAt(2, 0) == marker)
        {
            return win;
        }
        
        // tie (no empty cells remaining)
        char empty = board.getEmptyCellMarker();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board.getMarkerAt(i, j) == empty)
                {
                    // found empty cell --> game still running
                    return running;
                }
            }
        }

        // no win & no empty cells --> tie
        return tie;
    }
}