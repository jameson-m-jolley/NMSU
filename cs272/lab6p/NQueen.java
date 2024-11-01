public class NQueen {
    public static int rows = 5;
    public static int col = 5;

    //checks the q if it can be put on the bord in the spot and row and col
    public static boolean isSafe(int row, int col, char[][] board) {

        if( row >= board.length){
            return false;
        }
        if(col >= board[1].length){
            return false;
        }
        
        //checking horizontally, if any other queen has been already placed in that row.
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }
      
        //checking vertically, if any other queen has been already placed in that column.
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
      
        //checking if queen has been already placed in that upper left diagonal
        int r = row;
        for(int c=col; c>=0 && r>=0; c--, r--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
      
        //checking if queen has been already placed in that upper right diagonal
        r = row;
        for(int c=col; c<board.length && r>=0; r--, c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
      
       //checking if queen has been already placed in that lower left diagonal
       r = row;
       for(int c=col; c>=0 && r<board.length; r++, c--) {
           if(board[r][c] == 'Q') {
               return false;
           }
       }
      
        //checking if queen has been already placed in that lower right diagonal
        for(int c=col; c<board.length && r<board.length; c++, r++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
      
        return true;
    }

    public static void main(String[] args) {
        char[][] table = new char[5][5];
        linkstack<Integer> points = new linkstack<Integer>();
        for(int i = 0;i<5;i++){
            for(int j=0;j<5; j++){
                table[i][j]='-';
            }
        }
        
        solve(points, table);
        for(int i = 0;i<5;i++){
            for(int j=0;j<5; j++){
                System.out.print(table[i][j]);
            }
            System.out.println("");
        }
    }
    public static void solve(linkstack<Integer> points, char[][] table){
        
        for(int r=0; r < rows-1;r++ ){
            for(int c= 0; c< col-1;c++){
                if(points.isEmpty()){
                    points.push(c);
                    table[0][c]='Q';
                }else{
                    if(points.size() <= 4){
                        if(isSafe(points.size(), c, table)){
                            table[points.size()][c] ='Q';
                            points.push(c);
                            break;
                        }
                    }
                }
            }
        }
    
        if(points.size() < rows-1){
            backtrack(points, table);
        }
    }

    //back tracks the problome so that a Q can be plased on the bord
    public static void backtrack(linkstack<Integer> points, char[][] table){
        int val;
        if(points.top()>=4){
            
            table[points.size()-1][points.top()] ='-';
            val = points.pop();
            backtrack(points, table);
        }else{
            table[points.size()-1][points.top()] ='-';
            val = points.pop();
            val++;
            
            while (!isSafe(points.size(), val, table)&& val < col-1) {
              val++;  
              if(val>=4) backtrack(points, table);
            }
            
            points.push(val);
            try{
            table[points.size()-1][points.top()]='Q';
            } catch(Exception e){
                System.out.println(e);
            }
            solve(points, table);
            
        }
    }



}
