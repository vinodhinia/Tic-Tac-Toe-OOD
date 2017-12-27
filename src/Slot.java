/**
 * The Slot class models each individual slot of the game board.
 */
public class Slot {  
   Seed content; 
                 
   int row, col; 
   
   public Slot(int row, int col) {
      this.row = row;
      this.col = col;
      clear(); 
   }
 
   public void clear() {
      content = Seed.EMPTY;
   }
 
   public void paint() {
      switch (content) {
         case SYMBOL_X:  System.out.print(" X "); break;
         case SYMBOL_O: System.out.print(" O "); break;
         case EMPTY:  System.out.print("   "); break;
      }
   }
}