package org.vidhya.algoii;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class MSTPrims {
	private EdgeWeightedGraph G;
	
	public MSTPrims() {
		G = new EdgeWeightedGraph();
	}
	
	public void addEdge(Vertex one, Vertex other, int weight) {		
		G.addEdge(one, other, weight);
	}
	
	public void addEdge(Edge n_edge) {		
		G.addEdge(n_edge);
	}
	
	public int getNumEdges() {
		return G.getNumEdges();
	}

	public int getNumVertices() {
		return G.getNumVertices();
	}
	
	private class VertexComparator implements Comparator<Entry<Vertex, Edge>> {
		public int compare(Entry<Vertex, Edge> o1, Entry<Vertex, Edge> o2) {
			return o1.getValue().getWeight() - o2.getValue().getWeight();
		}	
	}
	
	public Iterable<Edge> computeMST() {
		ArrayList<Edge> mst = new ArrayList<Edge>();
		HashSet<Vertex> seenSet = new HashSet<Vertex>();
		
		PriorityQueue<Entry<Vertex, Edge>> minPQ = new PriorityQueue<Map.Entry<Vertex,Edge>>(G.getNumVertices(), new VertexComparator());
		HashMap<Vertex, Entry<Vertex, Edge>> mapScore = new HashMap<Vertex, Entry<Vertex, Edge>>();

		
		Set<Vertex> vertices = G.vertices();
		Vertex source = vertices.iterator().next();
		
		for (Edge e: G.adjList(source)) {
			Integer k = e.getWeight();
			Vertex v = e.other(source);
			// if <v,k> already in hash, check if k is larger than previous, then do nothing. 
			// if <v,k> not already in hash or k is smaller than previous, update entries in both map and minpq. 
			if (mapScore.containsKey(v)) {
				Entry<Vertex, Edge> c_entry =  mapScore.get(v);
				if (k < c_entry.getValue().getWeight()) {
					minPQ.remove(c_entry);
					Entry<Vertex, Edge> n_entry = new AbstractMap.SimpleEntry<Vertex, Edge>(v, e);
					minPQ.add(n_entry);	
					mapScore.put(v, n_entry);
				}
			}else{
				Entry<Vertex, Edge> n_entry = new AbstractMap.SimpleEntry<Vertex, Edge>(v, e);
				minPQ.add(n_entry);	
				mapScore.put(v, n_entry);
			}
			
			vertices.remove(v);
		}
		vertices.remove(source);
		
		for (Vertex vertex: vertices) {
			Entry<Vertex, Edge> n_entry = new AbstractMap.SimpleEntry<Vertex, Edge>(vertex, new NonEdge(source, vertex));
			minPQ.add(n_entry);	
			mapScore.put(vertex, n_entry);
		}
		
		System.out.println("Initial size of PQ is: " + minPQ.size());
		seenSet.add(source);
		
		while(! minPQ.isEmpty()) {
			Entry<Vertex, Edge> min_entry = minPQ.poll();
			Vertex min_vertex = min_entry.getKey();
			seenSet.add(min_vertex);
			mst.add(min_entry.getValue());
			
			for (Edge e: G.adjList(min_vertex)) {
				Integer k = e.getWeight();
				Vertex w = e.other(min_vertex);
				if (!seenSet.contains(w)) {
					if (mapScore.containsKey(w)) {
						Entry<Vertex, Edge> c_entry =  mapScore.get(w);
						if (k < c_entry.getValue().getWeight()) {
							minPQ.remove(c_entry);
							Entry<Vertex, Edge> n_entry = new AbstractMap.SimpleEntry<Vertex, Edge>(w, e);
							minPQ.add(n_entry);	
							mapScore.put(w, n_entry);
						}
					}
					else {
						assert(false);
					}
				}				
			}	
		}
		return mst;
	}
	
	public int computeMSTCost(){
		int sum= 0;
		for (Edge e : computeMST()){
			sum += e.getWeight();
		}
		return sum;
	}

}
