
public class IntelligentComputer {

	/** Intelligent Computer Move */
	public void bestIntelligentComputerMove(Board board) {
		if(!bestMove(Seed.SYMBOL_O, board)) { // Check if computer could win
			if(!bestMove(Seed.SYMBOL_X, board)) { //Prevent Player X from wining
				nextMove(board.currentRow,board.currentCol, board); //Make potential move
			}
		}
	}
   
   public boolean bestMove(Seed seedContent, Board board) {
	   // Check if row could be formed with same values on one move
		for(int i=0;i<Board.ROWS;i++) {
			for(int j=0;j<Board.COLS-2;j++) {
				if(board.slots[i][j].content == Seed.EMPTY && board.slots[i][j+1].content == seedContent && board.slots[i][j+2].content == seedContent) {
					board.slots[i][j].content = Seed.SYMBOL_O;
					return true;
				}
				else if(board.slots[i][j+1].content == Seed.EMPTY && board.slots[i][j].content == seedContent && board.slots[i][j+2].content == seedContent) {
					board.slots[i][j+1].content = Seed.SYMBOL_O;
					return true;
				}
				else if(board.slots[i][j+2].content == Seed.EMPTY && board.slots[i][j+1].content == seedContent && board.slots[i][j].content == seedContent ) {
					board.slots[i][j+2].content = Seed.SYMBOL_O;
					return true;
				}
			}		
		}
		
		// Check if columns could be formed with same values on one move
		for(int j=0;j<Board.COLS;j++) {
			for(int i=0;i<Board.ROWS-2;i++) {
				if(board.slots[i][j].content == seedContent && board.slots[i+1][j].content == seedContent && board.slots[i+2][j].content == Seed.EMPTY) {
					board.slots[i+2][j].content = Seed.SYMBOL_O;
					return true;
				}else if(board.slots[i+1][j].content == seedContent && board.slots[i+2][j].content == seedContent && board.slots[i][j].content == Seed.EMPTY) {
					board.slots[i][j].content = Seed.SYMBOL_O;
					return true;
				}else if(board.slots[i][j].content == seedContent && board.slots[i+2][j].content == seedContent && board.slots[i+1][j].content == Seed.EMPTY) {
					board.slots[i+1][j].content = Seed.SYMBOL_O;
					return true;
				}
			}
		}
		
		if(checkDiagonal(seedContent, board))
			return true;
		
		
		return false;
	}
	
	public boolean checkDiagonal(Seed seedContent, Board board) {
		//check diagonal from left to bottom
		if(board.slots[0][0].content == Seed.EMPTY && board.slots[1][1].content == seedContent && board.slots[2][2].content == seedContent) {
			board.slots[0][0].content = Seed.SYMBOL_O;
			return true;
		}
		else if(board.slots[1][1].content == Seed.EMPTY && board.slots[0][0].content == seedContent && board.slots[2][2].content == seedContent) {
			board.slots[1][1].content = Seed.SYMBOL_O;
			return true;
		}
		else if(board.slots[2][2].content == Seed.EMPTY && board.slots[0][0].content == seedContent && board.slots[1][1].content == seedContent) {
			board.slots[2][2].content = Seed.SYMBOL_O;
			return true;
		}	
		
		//check diagonal from right to bottom
		if(board.slots[0][2].content == Seed.EMPTY && board.slots[1][1].content == seedContent && board.slots[2][0].content == seedContent) {
			board.slots[0][2].content = Seed.SYMBOL_O;
			return true;
		}
		else if(board.slots[1][1].content == Seed.EMPTY && board.slots[0][2].content == seedContent && board.slots[2][0].content == seedContent) {
			board.slots[1][1].content = Seed.SYMBOL_O;
			return true;
		}
		else if(board.slots[2][0].content == Seed.EMPTY && board.slots[0][2].content == seedContent && board.slots[1][1].content == seedContent) {
			board.slots[2][0].content = Seed.SYMBOL_O;
			return true;
		}
		return false;
	}
	
	
	public boolean nextMove(int row, int col, Board board) {
		// Prevent Player Win
		if(row-1>0) {
			if(board.slots[row-1][col].content == Seed.EMPTY) {
				board.slots[row-1][col].content = Seed.SYMBOL_O;
				return true;
			}
		}else if(col-1>0) {
			if(board.slots[row][col-1].content == Seed.EMPTY) {
				board.slots[row][col-1].content = Seed.SYMBOL_O;
				return true;
			}
		}else if(row+1<board.ROWS) {
			if(board.slots[row+1][col].content == Seed.EMPTY) {
				board.slots[row+1][col].content = Seed.SYMBOL_O;
				return true;
			}
		}else if(col+1 <board.COLS) {
			if(board.slots[row][col+1].content == Seed.EMPTY) {
				board.slots[row][col+1].content = Seed.SYMBOL_O;
				return true;
			}
		}
		
		//Potential move
		for(int i=0;i<board.ROWS;i++) {
			for(int j=0;j<board.COLS;i++) {
				if(board.slots[i][j].content == Seed.EMPTY) {
					board.slots[i][j].content = Seed.SYMBOL_O;
					return true;
				}
			}
		}
		
		return false;
	}
}
