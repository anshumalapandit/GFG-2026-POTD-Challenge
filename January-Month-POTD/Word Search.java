class Solution {

    public boolean helper(int i, int j, char[][] mat, String word, int idx, int[][] mark) {

        // base cases
        if (idx == word.length()) return true;

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;

        if (mark[i][j] == 1 || mat[i][j] != word.charAt(idx))
            return false;

        // choose
        mark[i][j] = 1;

        // explore all 4 directions
        boolean found =
                helper(i - 1, j, mat, word, idx + 1, mark) ||
                helper(i, j + 1, mat, word, idx + 1, mark) ||
                helper(i + 1, j, mat, word, idx + 1, mark) ||
                helper(i, j - 1, mat, word, idx + 1, mark);

        // backtrack
        mark[i][j] = 0;

        return found;
    }

    public boolean isWordExist(char[][] mat, String word) {

        int[][] mark = new int[mat.length][mat[0].length];

        // try starting from every cell
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (helper(i, j, mat, word, 0, mark))
                    return true;
            }
        }
        return false;
    }
}
