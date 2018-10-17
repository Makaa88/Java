
public class Sudoku
{
	public static void main(String[] args)
	{
		int[][] sudoku = 	{{0,0,0,0,0,4,3,0,0}, 
							 {0,7,0,9,0,0,0,0,0}, 
							 {9,1,0,0,3,0,0,0,0}, 
							 {0,4,0,5,1,8,0,0,0}, 
							 {3,0,0,4,7,0,0,0,9}, 
							 {0,0,0,0,0,3,0,5,0}, 
							 {1,2,0,0,5,7,0,0,0}, 
							 {7,9,8,0,0,0,0,0,0}, 
							 {0,0,5,0,4,0,0,8,0}};
		Board board = new Board(sudoku);
		board.printBoard();
		board.solveSudoku();

		System.out.println("\n\n\n End Result");
		board.printBoard();
		
	}
}