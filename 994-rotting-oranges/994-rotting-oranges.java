class Solution {
    Queue<int[]> q = new LinkedList<>();
    int level = 0;
    int fresh = 0;
    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 9;
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        
        // while loop
        while(!q.isEmpty()) {
            boolean updated = false;
            int loop = q.size();
            while (loop > 0) {
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                if (i > 0) {
                    if (grid[i-1][j] == 1) {
                        grid[i-1][j] = 9;
                        q.offer(new int[]{i-1, j});
                        updated = true;
                        fresh--;
                    }
                }
                if (i < grid.length-1) {
                    if (grid[i+1][j] == 1) {
                        grid[i+1][j] = 9;
                        q.offer(new int[]{i+1, j});
                        updated = true;
                        fresh--;
                    }
                }
                if (j > 0) {
                    if (grid[i][j-1] == 1) {
                        grid[i][j-1] = 9;
                        q.offer(new int[]{i, j-1});
                        updated = true;
                        fresh--;
                    }
                }
                if (j < grid[0].length-1) {
                    if (grid[i][j+1] == 1) {
                        grid[i][j+1] = 9;
                        q.offer(new int[]{i, j+1});
                        updated = true;
                        fresh--;
                    }
                }
                loop--;
            }
            if(updated) level++;
        }
        return (fresh == 0) ? level : -1;
    }
}