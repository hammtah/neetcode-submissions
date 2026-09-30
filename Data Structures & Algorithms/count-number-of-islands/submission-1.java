class Solution {
    boolean[][] visited;
        
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1' ){
                    res++;
                    visit(grid, i, j);
                }
            }
        }

        return res;
    }
    
    public void visit(char[][] grid, int i, int j) {
        if (grid[i][j] == '0' || visited[i][j] == true) return;
        visited[i][j] = true;
        // Right
        if (j < grid[0].length - 1) visit(grid, i, j + 1);
        // Top
        if (i < grid.length - 1) visit(grid, i + 1, j);
        // Left
        if (j > 0) visit(grid, i, j - 1);
        // Bottom
        if (i > 0) visit(grid, i - 1, j);

    }
}
