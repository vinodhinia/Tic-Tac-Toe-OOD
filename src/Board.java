/**
 * The Board class models the game-board.
 */
public class Board {  
	//Board dimensions
   public static final int ROWS = 3; // Number of rows in the board
   public static final int COLS = 3; // Number of columns in the board
   
   public int[][] index = {{0,0}, {0,1}, {0,2},  // Maps the cell number to the rows and columns
			   {1,0}, {1,1}, {1,2},
			   {2,0}, {2,1}, {2,2}};
 
   Slot[][] slots;  
   int currentRow, currentCol;  // the current row and column
 
   /** Constructor to initialize the game board */
   public Board() {
      slots = new Slot[ROWS][COLS];  
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            slots[row][col] = new Slot(row, col); // allocate element of the array
         }
      }
   }
 
   /** Initialize the board */
   public void init() { 
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            slots[row][col].clear();  
         }
      }
   }
 
   /** Check if game is a tie */
   public boolean isTied() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (slots[row][col].content == Seed.EMPTY) {
               return false; 
            }
         }
      }
      return true; 
   }
 

   public boolean hasWon(Seed theSeed) {
	 //Check if rows is formed with same values
	 for(int i=0;i<ROWS;i++) {
	     if(slots[i][0].content == theSeed && slots[i][0].content == slots[i][1].content && slots[i][1].content == slots[i][2].content)
	         return true;
		}
	//Check if column is formed with same values
	for(int j=0;j<COLS;j++) {
	    for(int i=0;i<ROWS-2;i++) {
		if(slots[i][j].content == theSeed && slots[i][j].content == slots[i+1][j].content && slots[i+1][j].content == slots[i+2][j].content) {
		    return true;
			}
		}
	}
      return (currentRow == currentCol            // 3-in-the-diagonal
                   && slots[0][0].content == theSeed
                   && slots[1][1].content == theSeed
                   && slots[2][2].content == theSeed
              || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                   && slots[0][2].content == theSeed
                   && slots[1][1].content == theSeed
                   && slots[2][0].content == theSeed);
   }
   
   
 
   /** Display Board */
   public void displayBoard() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            slots[row][col].paint();   
            if (col < COLS - 1) System.out.print("|");
         }
         System.out.println();
         if (row < ROWS - 1) {
            System.out.println("-----------");
         }
      }
   }
}
