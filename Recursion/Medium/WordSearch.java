package Medium;

// Given a 2D board of letters and a word. Check if the word exists in the 

// board. The word can be constructed from letters of adjacent cells only. 
// ie - horizontal or vertical neighbors. The same letter cell can not be 
// used more than once.
// Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
// word = "geeks"
// Output: 1
// Explanation: The board is-
// a G b c
// q E E l
// g b K S  

//Solution Explaination

// Find First Letter of word in board

// If not found return false

// Else Search around 1st letter's position for the entire word

// Repeat for each point

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'a', 'g', 'b', 'c' },
                { 'q', 'e', 'e', 'l' },
                { 'g', 'b', 'k', 's' }
        };
        String word = "geeks";
        System.out.println(isWordExist(board, word));
    }

    public static boolean isWordExist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] != word.charAt(0))
                    continue;

                visited[i][j] = true;

                if (searchWord(board, i, j, word.substring(1), visited))
                    return true;

                visited[i][j] = false;

            }
        }

        return false;

    }

    static int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { -1, 0 },
            { 0, -1 },
    };

    public static boolean searchWord(char[][] board, int row, int col, String word, boolean[][] visited) {

        if (word.length() == 0)
            return true;

        boolean out = false;

        for (int i = 0; i < directions.length; i++) {
            if (charIsHere(
                    board,
                    row + directions[i][0],
                    col + directions[i][1],
                    word.charAt(0),
                    visited)) {

                visited[row + directions[i][0]][col + directions[i][1]] = true;

                out = out || searchWord(board,
                        row + directions[i][0], col + directions[i][1],
                        word.substring(1), visited);

                visited[row + directions[i][0]][col + directions[i][1]] = false;

            }
        }

        return out;

    }

    public static boolean charIsHere(char[][] board, int row, int col, char curChar, boolean[][] visited) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0)
            return false;
        // System.out.println(row+" "+col+" "+" "+curChar);

        if (visited[row][col])
            return false;

        if (board[row][col] == curChar)
            return true;

        return false;
    }
}
