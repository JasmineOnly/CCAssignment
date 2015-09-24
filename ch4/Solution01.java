import java.util.*;

class Digraph {
    public int V;
	public ArrayList<Integer>[] adj;
	public Digraph (int V) {
		this.V = V;
		adj = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}

class DFS {
	public boolean[] isConnected;
	public DFS(Digraph G, int start) {
		isConnected = new boolean[G.V];
		dfsSearch(G, start);
	}
	public void dfsSearch(Digraph G, int start) {
		isConnected[start] = true;
		for (int edge : G.adj(start)) {
			if (!isConnected[edge]) {
				dfsSearch(G, edge);
			}
		}
	}
	public boolean isConnected(int node) {
		return isConnected[node];
	}
}

public class Solution01 {
	public static void main(String[] args) {
		Digraph G = new Digraph(5);
		G.addEdge(0, 1);
		G.addEdge(0, 4);
		G.addEdge(1, 3);
		G.addEdge(1, 2);

		DFS dfs = new DFS (G, 0);
		System.out.println((dfs.isConnected(2) == true)? "true": "false");
	}
}