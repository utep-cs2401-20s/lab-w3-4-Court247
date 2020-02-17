public class GameOfLife {
    int size;
    int[][] board;
    int[][] prev;

    public GameOfLife() {
    }

    public GameOfLife(int size){
        this.size = size;
        board = new int [size][size];
        prev = new int [size][size];
    }

    public GameOfLife(int[][] b1 ){
        this.size = b1.length;
        board = b1;
       // board = new int [this.size][this.size];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length;j++){
                board = new int [this.size][this.size];
            }
        }
    }


    public int[][] getBoard() {
        return board;
    }

    public int neighbors(int r, int c){ //count the neighbors
        int alive = 0;
        for (r = 0; r < board.length; r++){
            for (c = 0; c < board[0].length; c++){
                if (board[r][c] == 1) {
                    alive += 1;
                }
            }
        }
        return alive;
    }

    public void oneStep(){//implement the rules of the game
        //copy previous board first
        for( int i = 0; i<prev.length;i++){
            for (int j = 0; j<prev[0].length;j++){
                prev[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[0].length;j++){
                if(board[i][j]== 1){
                    if (neighbors(i, j) < 2){ //use neighbors method
                        board[i][j] = 0;
                    }else if (neighbors(i, j)>3){
                       board[i][j] = 0;
                    }
                }else if (board[i][j]== 0){
                    if ( neighbors(i, j) ==3){
                        board[i][j]=1;
                    }

                }else{
                    board[i][j] = prev[i][j];
                }
            }
        }
    }


    public void evolution(int n){
        for (int i = 0; i< n;i++){
            oneStep();
        }
    }
}
