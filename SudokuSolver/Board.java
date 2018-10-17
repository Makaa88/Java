public class Board
{
	private int [][] sudoku;

	public Board(int[][] sudoku)
	{
		this.sudoku = sudoku;
	}

	public void printBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				System.out.print(sudoku[i][j] + " ");
			}

			System.out.print("\n");
		}
	}

	public void solveSudoku()
	{
		int counter = 0;
		boolean timeToBreak = false;
		while(this.isntFilled() && (!timeToBreak))
		{
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					if(sudoku[i][j] == 0)
					{
						sudoku[i][j] = this.applyValue(i,j);
					}
				}
			}

			if((counter++) > 81)
			{
				System.out.println("\n\nNie udalo sie!");
				timeToBreak = true;
			}
		}	
	}

	private boolean isntFilled()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(sudoku[i][j] == 0) return true;
			}
		}
		return false;
	}

	private int applyValue(int row, int column)
	{
		int validity = 0;
		int correctValue = 0;
		for(int i = 1; i <= 9; i++)
		{
			boolean rowAv = true;
			boolean colAv = true;
			boolean sqAv = true;
			if(!(rowAv = checkRow(i, row))) continue;
			if(!(colAv = checkColumn(i, column))) continue;
			if(!(sqAv = checkSquare(i,row,column))) continue;
			
			correctValue = i;
			validity++;
			
		}
		if(validity != 1) correctValue = 0;

		return correctValue;
	}

	private boolean checkRow(int value, int row)
	{
		for(int i = 0; i < 9; i++)
		{
			if(sudoku[row][i] == value) return false;
		}
		return true;
	}

	private boolean checkColumn(int value, int column)
	{
		for(int i = 0; i < 9; i++)
		{
			if(sudoku[i][column] == value) return false;
		}
		return true;
	}

	private boolean checkSquare(int value, int row, int column)
	{
		for(int i = 3*(row/3); i < 3*(row/3) + 3; i++)
		{
			for(int j = 3 * (column/3); j < 3 * (column/3) + 3; j++)
			{
				if(sudoku[i][j] == value) return false;
			}
		}
		return true;
	}
}



