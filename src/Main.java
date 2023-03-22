public class Main {
    private static void print(char[][] maze) {
        System.out.println("-----------------------");
        for(int x = 0; x < 10; x++) {
            System.out.print("| ");
            for(int y = 0; y < 10; y++) {
                System.out.print(maze[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------");
    }
   public static boolean isValidSpot(char[][] maze, int row, int col) {
	   if(row >= 0 && row < 10 && col >= 0 && col < 10) {
		   return maze[row][col]=='.';
	   }else
	   return false;
   }
   public static boolean traverse(char[][] maze, int row, int col) {
	   if(isValidSpot(maze, row, col)) {
		   // valid spot to walk throw 
		   if(row == 9 && col ==9) {
			   maze[row][col] = ' ';
			   return true;
		   }
		   maze[row][col] = '*';
		   // checking up
		   boolean returnTraverse = traverse(maze,row-1,col);
		   //checking down
		   if(!returnTraverse)
		   returnTraverse = traverse(maze,row+1,col);
		   //checking right
		   if(!returnTraverse)
		   returnTraverse = traverse(maze, row, col+1);
		   //checking left
		   if(!returnTraverse)
		   returnTraverse = traverse(maze, row, col-1);
		   if(returnTraverse) {
		        System.out.println("("+row + "," + col+")");
		        maze[row][col] = ' ';
		    } return returnTraverse;
	   } return false;
   }
	public static void main(String[] args) {
		char[][] maze = {
                {'.', '.', '.', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                {'0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'.', '0', '0', '0', '.', '.', '.', '0', '.', '0'},
                {'.', '.', '.', '0', '0', '.', '0', '.', '.', '0'},
                {'.', '0', '0', '0', '.', '.', '0', '.', '.', '0'},
                {'.', '.', '.', '0', '0', '.', '0', '0', '.', '.'},
                {'0', '0', '.', '0', '0', '.', '.', '.', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '.', '.', '.'},
        };
        print(maze);

        if(traverse(maze, 0, 0)) {
            System.out.println("SOLVED maze");
        } else {
            System.out.println("could NOT SOLVE maze");
        }
        print(maze);
	}
}


