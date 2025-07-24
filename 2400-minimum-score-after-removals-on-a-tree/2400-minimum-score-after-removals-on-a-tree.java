class Solution {

    private int ans = Integer.MAX_VALUE;

    private int helper(int src, ArrayList<Integer>[] graph, int[] arr, int par, int block, int xor1, int tot) { // function to travel 2nd time on the tree and find the second edge to be removed

        int myXOR = arr[src]; // Setting the value for the current subtree's XOR value

        for (int nbr : graph[src]) {
            if (nbr != par && nbr != block) { // If the current nbr is niether the parent of this node nor the blocked node  , then only we'll proceed

                int nbrXOR = helper(nbr, graph, arr, src, block, xor1, tot);
                // 'src <----> nbr' is the second edge to be removed

                int xor2 = nbrXOR; // Getting the XOR value of the current neighbor

                int xor3 = (tot ^ xor1) ^ xor2; // The XOR of the remaining component

                int max = Math.max(xor1, Math.max(xor2, xor3)); // Getting the minimum of the three values
                int min = Math.min(xor1, Math.min(xor2, xor3)); // Getting the maximum of the three value

                this.ans = Math.min(ans, max - min);

                myXOR ^= nbrXOR; // Including the neighbour subtree's XOR value in the XOR value of the subtree rooted at src node

            }
        }

        return myXOR; // Returing the XOR value of the current subtree rooted at the src node
    }

    private int dfs(int src, ArrayList<Integer>[] graph, int[] arr, int par, int tot) { // function to travel 1st time on the tree and find the first edge to be removed and then block the node at which the edge ends to avoid selecting the same node again
        int myXOR = arr[src]; // Setting the value for the current subtree's XOR value
        for (int nbr : graph[src]) {
            if (nbr != par) { // If the current nbr is not the parent of this node, then only we'll proceed

                int nbrXOR = dfs(nbr, graph, arr, src, tot); // After selecting 'src <----> nbr' as the first edge, we block 'nbr' node and then make a call to try all the second edges

                // Calling the helper to find the try all the second edges after blocking the current node
                helper(0, graph, arr, -1, nbr, nbrXOR, tot);

                myXOR ^= nbrXOR; // Including the neighbour subtree's XOR value in the XOR value of the subtree rooted at src node
            }
        }

        return myXOR; // Returing the XOR value of the current subtree rooted at the src node

    }

    public int minimumScore(int[] arr, int[][] edges) {
        int n = arr.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        int tot = 0;

        for (int i = 0; i < n; i++) {
            // Initializing the graph and finding the total XOR
            graph[i] = new ArrayList<>();
            tot ^= arr[i];
        }

        for (int[] edge : edges) {
            // adding the edges 
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        this.ans = Integer.MAX_VALUE;

        dfs(0, graph, arr, -1, tot);

        return this.ans;
    }
}