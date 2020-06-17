

//https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
class Solution {
    public void solve(char[][] board) {
        int M = board.length;
    
        if(M==0){
             System.out.println("[]"); 
        }
        else{
             int N = board[0].length;
         replaceSurrounded(board);
      
        for (int i = 0; i < M; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(board[i][j] + " ");  
                  
            System.out.println(""); 
        } 
        }
   
    }
    
    
    
    
    //floodfill algo
    static void floodFillUtil(char board[][], int x,  
                              int y, char prevV,  
                              char newV) {
         int M = board.length;
     int N = board[0].length;
    { 
        // Base cases 
        if (x < 0 || x >= M || 
            y < 0 || y >= N) 
            return; 
              
        if (board[x][y] != prevV) 
            return; 
      
        // Replace the color at (x, y) 
        board[x][y] = newV; 
      
        // Recur for north, 
        // east, south and west 
        floodFillUtil(board, x + 1, y,  
                      prevV, newV); 
        floodFillUtil(board, x - 1, y,  
                      prevV, newV); 
        floodFillUtil(board, x, y + 1,  
                      prevV, newV); 
        floodFillUtil(board, x, y - 1,  
                      prevV, newV); 
    } 
    
    }
    
    
    
    
    
    //   // Returns size of maximum  
    // size subsquare matrix 
    // surrounded by 'X' 
     static void replaceSurrounded(char board[][]) 
    { 
         
        int M = board.length;
     int N = board[0].length;
          
    // Step 1: Replace  
    // all 'O' with '-' 
    for (int i = 0; i < M; i++) 
        for (int j = 0; j < N; j++) 
            if (board[i][j] == 'O') 
                board[i][j] = '-'; 
      
    // Call floodFill for  
    // all '-' lying on edges 
    for (int i = 0; i < M; i++) // Left side 
        if (board[i][0] == '-') 
            floodFillUtil(board, i, 0,  
                          '-', 'O'); 
    for (int i = 0; i < M; i++) // Right side 
        if (board[i][N - 1] == '-') 
            floodFillUtil(board, i, N - 1, 
                          '-', 'O'); 
    for (int i = 0; i < N; i++) // Top side 
        if (board[0][i] == '-') 
            floodFillUtil(board, 0, i, 
                          '-', 'O'); 
    for (int i = 0; i < N; i++) // Bottom side 
        if (board[M - 1][i] == '-') 
            floodFillUtil(board, M - 1,  
                          i, '-', 'O'); 
      
    // Step 3: Replace  
    // all '-' with 'X' 
    for (int i = 0; i < M; i++) 
        for (int j = 0; j < N; j++) 
            if (board[i][j] == '-') 
                board[i][j] = 'X'; 
    } 
}
