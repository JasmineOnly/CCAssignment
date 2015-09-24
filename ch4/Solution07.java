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
	public Stack<Integer> reverse;
	public DFS(Digraph G) {
		isConnected = new boolean[G.V];
		reverse = new Stack<Integer>();
		dfsOrder(G);
	}

	public void dfsOrder(Digraph G) {
		for (int i = 0; i < G.V; i ++) {
			if (!isConnected[i])
				dfsSearch(G, i);
		}
	}

	public void dfsSearch(Digraph G, int start) {
		isConnected[start] = true;
		for (int edge : G.adj(start)) {
			if (!isConnected[edge]) {
				dfsSearch(G, edge);
			}
		}
		reverse.push(start);
	}
	public boolean isConnected(int node) {
		return isConnected[node];
	}
	public Iterable<Integer> topoOrder() {
		return reverse;
	}
}

public class Solution07 {
	public static void main(String[] args) {
		Digraph G = new Digraph(4);
		G.addEdge(1, 3); // 4 is dependent on 2
		G.addEdge(2, 3);
		G.addEdge(0, 2);
		G.addEdge(0, 1);

		DFS dfs = new DFS(G);
		Stack <Integer> stack = (Stack <Integer>) dfs.topoOrder();
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}