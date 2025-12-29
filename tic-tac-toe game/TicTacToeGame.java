
public class TicTacToeGame
{
    public static void main(String[] args)
    {
        int running = 0;
        int win = 1;
        int tie = 2;

        char markerX = 'X';
        char markerO = 'O';

        Board board = new Board();

        GameChecker checker = new GameStatus();

        Player player1 = new HumanPlayer(markerX);
        Player player2 = new HumanPlayer(markerO);

        Player[] players = {player1, player2};

        int status = running;
        int currentPlayerIndex = 0;

        System.out.println("Player 1 is " + markerX + ", and Player 2 is " + markerO + ".");

        while (status == running)
        {
            Player currentPlayer = players[currentPlayerIndex];

            board.displayBoard();

            int[] move = currentPlayer.getMove(board);
            int row = move[0];
            int col = move[1];

            board.placeMarker(row, col, currentPlayer.getMarker());

            status = checker.checkStatus(board, currentPlayer.getMarker());

            if(status == running)
            {
                System.out.println("Game is running...");
                currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            }
            else if (status == win)
            {
                board.displayBoard();
                System.out.println("\n Congratulations! Player " + players[currentPlayerIndex].getMarker() + " wins!");
            }
            else if(status == tie)
            {
                board.displayBoard();
                System.out.println("\n Game Over! It's a Tie.");
            }
        }
    }
}
