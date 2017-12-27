import java.util.Random;
/**
 * The Computer is one of the Player of Tic Tac Toe Game
 */
public class ComputerPlayer implements Player{	
    /** Random Computer move - as per requirements*/
    @Override
    public void move(Board board) {
        // TODO Random implementation can be done better
        int min =1, max = 9;
	Random rn = new Random();
	while(true) {
	    int move = rn.nextInt(max - min + 1) + min;
	    int row = board.index[move-1][0];
	    int col = board.index[move-1][1];
	    if(board.slots[row][col].content == Seed.EMPTY) {
		board.slots[row][col].content = Seed.SYMBOL_O;
		break;
	    }else {
		continue;
	    }	
	 }
    }
}
