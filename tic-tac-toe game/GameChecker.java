public interface GameChecker
{
    public int checkStatus(Board board, char lastMarkerPlayed);      // returns integer; 0 = running, 1 = win, 2 = tie
}
