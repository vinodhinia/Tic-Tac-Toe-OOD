import java.util.Random;
import java.util.Scanner;

/**
 * The main class for the Tic-Tac-Toe 
 * It acts as the overall controller of the game.
 */
public class TicTacToeMain {
   private Board board;            
   private GameState currentState; // the current state of the game (of enum GameState)
   private Seed currentPlayer;     // the current player (of enum Seed)
   
   private HumanPlayer player;
   private ComputerPlayer computer;
   private IntelligentComputerPlayer intelligentC;
 
   private static Scanner in = new Scanner(System.in);  // input Scanner
 
   
   /** Constructor to setup the game */
   public TicTacToeMain() {
      intelligentC = new IntelligentComputerPlayer();
      player = new HumanPlayer();
      computer = new ComputerPlayer();
      board = new Board(); 
      initGame();
      do {
    	 player.move(board); // update the content, currentRow and currentCol
         board.displayBoard();
         updateGame(currentPlayer);
         checkState();
         if(currentState == GameState.PLAYING) {
        	 System.out.println("Player 'O' move\n");
        	 //computer.move(board); //Pluggable Interface
        	 intelligentC.move(board);
	         board.displayBoard();
	         updateGame(currentPlayer); // update currentState
	         checkState();
         }
      } while (currentState == GameState.PLAYING);  // repeat until game-over
   }
 
   /** Check the state of the game */
   public void checkState() {
	   if (currentState == GameState.X_WON) {
           System.out.println("'X' won! Bye!");
        } else if (currentState == GameState.O_WON) {
           System.out.println("'O' won! Bye!");
        } else if (currentState == GameState.TIE) {
           System.out.println("It's Draw! Bye!");
        }
   }

   /** Initialize the game */
   public void initGame() {
      board.init();  // clear the board contents
      currentPlayer = Seed.SYMBOL_X;       // SYMBOL_X plays first
      currentState = GameState.PLAYING; // Current Game State is PLAYING
   }
  
 
   public void updateGame(Seed theSeed) {      
      if(board.hasWon(Seed.SYMBOL_X)) { // check if SYMBOL_X has won
    	  currentState = GameState.X_WON;
      }else if(board.hasWon(Seed.SYMBOL_O)) // check if SYMBOL_O has won
    	  currentState = GameState.O_WON;
      else if(board.isTied()) // check if game is a tie
    	  currentState = GameState.TIE;
   }
   

 
   public static void main(String[] args) {
      new TicTacToeMain();  
   }
}
