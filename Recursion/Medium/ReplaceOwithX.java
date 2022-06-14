package Medium;
// Given a matrix mat of size N x M where every element is either ‘O’ or ‘X’.

// Replace all ‘O’ with ‘X’ that are surrounded by ‘X’.
// A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations just below, just above, just left and just right of it.

// Example 1:

// Input: n = 5, m = 4
// mat = {{'X', 'X', 'X', 'X'}, 
//        {'X', 'O', 'X', 'X'}, 
//        {'X', 'O', 'O', 'X'}, 
//        {'X', 'O', 'X', 'X'}, 
//        {'X', 'X', 'O', 'O'}}
// Output: ans = {{'X', 'X', 'X', 'X'}, 
//                {'X', 'X', 'X', 'X'}, 
//                {'X', 'X', 'X', 'X'}, 
//                {'X', 'X', 'X', 'X'}, 
//                {'X', 'X', 'O', 'O'}}
// Explanation: Following the rule the above 
// matrix is the resultant matrix. 
public class ReplaceOwithX {
    public static void main(String[] args) {

    }

    static boolean[][] safeZeros;

    static char[][] fill(int n, int m, char a[][]) {

        if (n == 0 || n == 1 || m == 0 || m == 1)
            return a;
        safeZeros = new boolean[n][m];

        fillSafeZeros(a, n, m);

        for (int i = 1; i < n - 1; i++)
            for (int j = 1; j < m - 1; j++)
                if (a[i][j] == 'O' && !safeZeros[i][j])
                    a[i][j] = 'X';

        return a;
    }

    static void fillSafeZeros(char[][] a, int row, int col) {

        // TOP ROW
        for (int i = 0; i < col; i++)
            if (a[0][i] == 'O' && !safeZeros[0][i])
                searchIn(a, 0, i);

        // LEFT MOST COL
        for (int i = 0; i < row; i++)
            if (a[i][0] == 'O' && !safeZeros[i][0])
                searchIn(a, i, 0);

        // RIGHT MOST COL
        for (int i = 0; i < row; i++)
            if (a[i][col - 1] == 'O' && !safeZeros[i][col - 1])
                searchIn(a, i, col - 1);

        // BOTTOM ROW
        for (int i = 0; i < col; i++)
            if (a[row - 1][i] == 'O' && !safeZeros[row - 1][i])
                searchIn(a, row - 1, i);
    }

    static int[][] directions = {
            { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 },
    };

    static void searchIn(char[][] a, int row, int col) {
        safeZeros[row][col] = true;
        for (int[] dir : directions)
            if (isZero(a, row + dir[0], col + dir[1]))
                searchIn(a, row + dir[0], col + dir[1]);
    }

    static boolean isZero(char[][] a, int row, int col) {

        if (row >= a.length || col >= a[0].length || col < 0 || row < 0 || a[row][col] == 'X' || safeZeros[row][col])
            return false;
        return true;
    }
}
