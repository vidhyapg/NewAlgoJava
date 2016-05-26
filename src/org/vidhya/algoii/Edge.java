package org.vidhya.algoii;

public class Edge {
	private Vertex one;
	private Vertex other;
	private int weight;
	
	public Edge(Vertex one, Vertex other, int weight) {
		this.one = one;
		this.other = other;
		this.weight = weight;
	}
	
	public Vertex either() {
		return one;
	}
	
	public Vertex other(Vertex v) {
		return (v.equals(one) ? other : one);
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return one + " -> " + other +" : " +weight;
	}

}
