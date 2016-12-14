import java.util.Arrays;

/**
 * Created by rico on 2016/12/14.
 */
public class Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {

        return validRow(board) && validColumn(board) && validGrid(board);
    }

    private boolean validGrid(char[][] board) {

        boolean[] appeared = new boolean[10];
        for(int i = 0; i < board.length; i += 3) {
            for(int j = 0; j < board.length; j += 3) {

                Arrays.fill(appeared, false);
                //检查一个Grid
                for(int m = i; m < (i + 3); m++) {
                    for(int n = j; n < (j + 3); n++) {
                        if(checkIfAlreadyExist(board[m][n], appeared)) return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean validColumn(char[][] board) {

        boolean[] appeared = new boolean[10];

        for(int i = 0; i < board.length; i++) {
            Arrays.fill(appeared, false);

            for(int j = 0; j < board.length; j++) {
                if (checkIfAlreadyExist(board[j][i], appeared)) return false;
            }
        }

        return true;
    }

    private boolean checkIfAlreadyExist(char c, boolean[] appeared) {

        if(c == '.') return false;

        if(appeared[c - '0']) return true;

        appeared[c - '0'] = true;
        return false;
    }

    private boolean validRow(char[][] board) {

        boolean[] appeared = new boolean[10];
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(appeared, false);

            for(int j = 0; j < board.length; j++) {
                if (checkIfAlreadyExist(board[i][j], appeared)) return false;
            }
        }

        return true;
    }
}
