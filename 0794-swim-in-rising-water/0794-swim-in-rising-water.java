
class DisjointSet {
    private int[] size;
    private int[] parent;

    public DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];

        Arrays.fill(size, 1); // to take care of 1-based indexing as well

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = findParent(parent[u]);
    }

    public void unionBySize(int u, int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);

        if (up_u == up_v)
            return;

        if (size[up_u] > size[up_v]) {
            parent[up_v] = up_u;
            size[up_u] += size[up_v];
        } else {
            parent[up_u] = up_v;
            size[up_v] += size[up_u];
        }
    }
}

class Solution {
    public boolean isValid(int x, int y, int n) {
        return x>=0 && y>=0 && x<n && y<n;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        if (n == 1) return 0;

        HashMap<Integer, int[]> map = new HashMap<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        DisjointSet ds = new DisjointSet(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }

        int time = 0;

        while (ds.findParent(0) != ds.findParent(n * n - 1)) {
            int[] node = map.get(time);
            int row = node[0];
            int col = node[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (isValid(nrow,  ncol, n) && grid[nrow][ncol] <= time) {
                    int nodeNo = row * n + col;
                    int adjNodeNo = nrow * n + ncol;

                    ds.unionBySize(nodeNo, adjNodeNo);
                }
            }

            time++;
        }
        return time - 1;
    }
}