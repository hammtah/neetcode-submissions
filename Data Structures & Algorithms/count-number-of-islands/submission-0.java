class Solution {
    boolean[][] visited;
        
    public int numIslands(char[][] grid) {
        visited = new boolean[1000][1000];
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
        
        if (j < grid[0].length - 1) visit(grid, i, j + 1);
        if (i < grid.length - 1) visit(grid, i + 1, j);

        if (j > 0) visit(grid, i, j - 1);
        if (i > 0) visit(grid, i - 1, j);

    }
}
