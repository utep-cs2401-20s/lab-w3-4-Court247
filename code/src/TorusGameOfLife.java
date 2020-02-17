public class TorusGameOfLife extends GameOfLife {

    public TorusGameOfLife() {

    }

   public TorusGameOfLife(int size){
        this.size = size;
        board = new int [size][size];
        prev = new int [size][size];
    }

    public TorusGameOfLife(int[][] b1 ){
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


    @Override
    public int neighbors(int r, int c) {
        int alive = 0;

        for( int i= r-1;i< r+1;i++){
            for( int j = c-1; j< c+1; j++){
               if((i>=0) && (i<size) && (j<size) &&(j>=0)){
                   r = r % board.length;
                   c = c % board.length;
                   if(r < 0){
                       r += board.length;
                   }else if( c < 0){
                       c += board.length;
                   }
               }
            }
        }
        return alive;
    }
}

