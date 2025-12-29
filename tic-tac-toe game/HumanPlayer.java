import java.util.Scanner;

public class HumanPlayer implements Player
{
    public char marker;
    

    public HumanPlayer(char marker)
    {
        this.marker = marker;
    }

    @Override
    public char getMarker()
    {
        return this.marker;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public int[] getMove(Board board)
    {
        int row = -1;
        int col = -1;
        boolean moveValid = false;

        System.out.println("Player " + marker + "'s turn. Enter your move (row and column): ");

        while (!moveValid)
        {
            boolean inputClean = false;
            
            try
            {
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();

                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();

                inputClean = true;
            }

            catch (java.util.InputMismatchException e)
            {
                System.out.println("Invalid input: Please enter only numbers (0, 1, 2).");
                scanner.nextLine();
            }

            if (inputClean)
            {
                if (row < 0 || row > 2 || col < 0 || col > 2)
                {
                    System.out.println("Invalid move: Coordinates must be between 0 and 2.");
                }
                else if (!board.isCellEmpty(row, col))
                {
                    System.out.println("Invalid move: That cell is already occupied. Try again.");
                }
                else
                {
                    moveValid = true;
                }
            }
        }
        //scanner.close();

        int[] coordinates = {row, col};
        return coordinates;
    }
    
}
