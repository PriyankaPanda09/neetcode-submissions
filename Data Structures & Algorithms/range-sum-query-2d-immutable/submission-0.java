class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // padded array: one extra row on top, one extra column on the left, both zeros
        prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // prefix[i][j] = top strip + left strip - double-counted corner + new cell
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1]
                             - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // A - B - C + D, using the +1 shift for "include" edges (row2, col2)
        // and no shift for "exclude" edges (row1, col1)
        return prefix[row2 + 1][col2 + 1]
             - prefix[row1][col2 + 1]
             - prefix[row2 + 1][col1]
             + prefix[row1][col1];
    }
}