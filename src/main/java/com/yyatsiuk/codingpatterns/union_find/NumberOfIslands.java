package com.yyatsiuk.codingpatterns.union_find;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 */
public class NumberOfIslands {

    /**
     * <h3>Complexity Analysis:</h3>
     *
     * <ul>
     *     <li>
     *         <b>Time complexity:</b>O(M×N) where M is the number of rows and N is the number of columns.
     *          Note that Union operation takes essentially constant time[1] when UnionFind is
     *          implemented with both path compression and union by rank.
     *     </li>
     *     <li>
     *          <b>Space complexity:</b> O(M \times N)O(M×N) as required by UnionFind data structure.
     *     </li>
     * </ul>
     * <p>
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1') {
                    grid[x][y] = '0';
                    for (int[] dir : direction) {
                        int xNext = x + dir[0];
                        int yNext = y + dir[1];
                        if ((xNext < m && xNext >= 0) && (yNext < n && yNext >= 0) && grid[xNext][yNext] == '1') {
                            uf.union(uf.getId(x, y), uf.getId(xNext, yNext));
                        }
                    }
                }
            }
        }

        return uf.count();
    }

    private static class UnionFind {

        private final int[] parent;
        private final int[] size;
        private final int colSize;
        private int count;

        public UnionFind(char[][] grid) {
            int rowSize = grid.length;
            this.colSize = grid[0].length;
            this.parent = new int[rowSize * colSize];
            this.size = new int[rowSize * colSize];
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (grid[i][j] == '1') {
                        int id = getId(i, j);
                        parent[id] = id;
                        size[id] = 1;
                        count++;
                    }
                }
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;

            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
            count--;
        }

        public int count() {
            return count;
        }

        private int getId(int row, int col) {
            return row * colSize + col;
        }

    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int res = numberOfIslands.numIslands(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}}
        );
        System.out.println(res);
    }
}
