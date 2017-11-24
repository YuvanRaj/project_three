package com.datastructures.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int vertex;
	private int edge;
	private LinkedList<Integer>[] adj;
	private int[] marked;

	public Graph(int vertex) {
		this.vertex = vertex;
		adj = new LinkedList[vertex];
		marked = new int[vertex];
	}

	public Integer V() {
		return vertex;
	}

	public Integer E() {
		return edge;
	}

	public void addEdge(int s, int t) {
		// assuming bi directional
		if (adj[s] == null) {
			adj[s] = new LinkedList<>();
		}
		adj[s].add(t);
		edge++;
	}

	public void traverse(TRAVERSE action, int element) {
		Arrays.fill(marked, 0);
		if (action.equals(TRAVERSE.DFS)) {
			DFS(element);
		} else {
			BFS(element);
		}
	}

	private void DFS(int v) {
		marked[v] = 1;
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (marked[n] == 0) {
				System.out.println("DFS: "+n);
				DFS(n);
			}
		}
	}

	private void BFS(int v) {
		LinkedList<Integer> queue = new LinkedList<>();
		marked[v] = 1;
		queue.add(v);
		while (!queue.isEmpty()) {
			v = queue.poll();
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (marked[n] == 0) {
					marked[n] = 1;
					queue.add(n);
					System.out.println(n);
				}
			}
		}
	}

	@Override
	public String toString() {
		return null;
	}

	// enum
	enum TRAVERSE {
		DFS("DFS"), BFS("BFS");
		public String description;

		TRAVERSE(String description) {
			this.description = description;
		}
	}
}