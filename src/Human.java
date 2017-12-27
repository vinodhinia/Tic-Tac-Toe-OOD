import java.util.*;
/**
 * Human is one of the Player of Tic Tac Toe Game
 */

public class Human {

	/** Human move */
	public void playerMove(Board board, Seed theSeed) {
		Scanner in = new Scanner(System.in);
		boolean validInput = false;  
	      do {
	         if (theSeed == Seed.SYMBOL_X) {
	            System.out.print("Player 'X', enter the cell you want to move (First row: 1-3, Second row: 4-6, Third row: 7-9) ");
	         } 
	         int cell = in.nextInt() - 1;
	         int row = board.index[cell][0];
	         int col = board.index[cell][1];
	         if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
	               && board.slots[row][col].content == Seed.EMPTY) {
	            board.slots[row][col].content = theSeed;
	            board.currentRow = row;
	            board.currentCol = col;
	            validInput = true; 
	         } else {
	            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
	                  + ") is not valid. Try again...");
	         }
	      } while (!validInput);   
	   }
	   
}
