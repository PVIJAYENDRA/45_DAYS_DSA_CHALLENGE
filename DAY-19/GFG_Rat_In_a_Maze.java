class Solution {

    boolean isSafe(int x, int y, int n, int[][] maze, int[][] visited) {
        return (x >= 0 && x < n && y >= 0 && y < n &&
                maze[x][y] == 1 && visited[x][y] == 0);
    }

    // Function to solve maze using backtracking
    void solve(int x, int y, int n, int[][] maze, int[][] visited,
               String path, ArrayList<String> res) {

        // If destination reached, store the path
        if (x == n - 1 && y == n - 1) {
            res.add(path);
            return;
        }

        // Mark the cell visited
        visited[x][y] = 1;

        // Try moving Down
        if (isSafe(x + 1, y, n, maze, visited)) {
            solve(x + 1, y, n, maze, visited, path + "D", res);
        }
        // Try moving Left
        if (isSafe(x, y - 1, n, maze, visited)) {
            solve(x, y - 1, n, maze, visited, path + "L", res);
        }
        // Try moving Right
        if (isSafe(x, y + 1, n, maze, visited)) {
            solve(x, y + 1, n, maze, visited, path + "R", res);
        }
        // Try moving Up
        if (isSafe(x - 1, y, n, maze, visited)) {
            solve(x - 1, y, n, maze, visited, path + "U", res);
        }

        // Backtrack: unmark cell as visited
        visited[x][y] = 0;
    }

    // Main function to find all paths
    public ArrayList<String> ratInMaze(int[][] maze){
        int n = maze.length;
        ArrayList<String> res = new ArrayList<>();
        int[][] visited = new int[n][n];
        if (maze[0][0] == 1) {
            solve(0, 0, n, maze, visited, "", res);
        }
        return res;
    }
}