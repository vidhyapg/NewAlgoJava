package org.vidhya.algoii;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.lang.Exception;


public class EdgeWeightedGraph {
	private int E;
	private int V;
	private HashMap<Vertex, LinkedList<Edge>> adjMatrix;
	
	public EdgeWeightedGraph() {
		E = 0; 
		V = 0;
		adjMatrix = new HashMap<Vertex, LinkedList<Edge>>();
	}
	
	private void addEdgeinAdjList(Vertex one, Edge n_edge) {
		if(adjMatrix.containsKey(one)) {
			adjMatrix.get(one).addFirst(n_edge);
		}else {
			LinkedList<Edge> n_list = new LinkedList<Edge>();
			n_list.addFirst(n_edge);
			adjMatrix.put(one, n_list);
			V++;
		}
	}
	
	public void addEdge(Vertex one, Vertex other, int weight) {		
		Edge n_edge = new Edge(one, other, weight);
		addEdgeinAdjList(one, n_edge);
		addEdgeinAdjList(other, n_edge);
		E++;
	}
	
	public void addEdge(Edge n_edge) {		
		addEdgeinAdjList(n_edge.either(), n_edge);
		addEdgeinAdjList(n_edge.other(n_edge.either()), n_edge);
		E++;
	}

	public int getNumEdges() {
		return E;
	}

	public int getNumVertices() {
		return V;
	}
	
	/* @param	vertex v 
	 * @return	if v is present in G - list of edges incident on v 
	 * @throws	InvalidParameterException if v is not in G. 
	 */
	public Iterable<Edge> adjList(Vertex v) {
		if (!adjMatrix.containsKey(v))
			throw new InvalidParameterException("Vertex "+ v+ " Not Found! ");
		return adjMatrix.get(v);
	}
	
	public Set<Vertex> vertices() {
		Set<Vertex> vertices = new HashSet<Vertex>();
		for(Vertex v: adjMatrix.keySet()) {
			vertices.add(v);
		}
		return vertices;		
	}
	
	public Vertex getRandomVertex() {
		return adjMatrix.keySet().iterator().next();
	}
	
}
