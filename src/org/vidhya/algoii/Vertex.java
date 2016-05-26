package org.vidhya.algoii;

public class Vertex {
	private String label;
	public Vertex (String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public boolean equals(Vertex v1) {
		return label.equals(v1.getLabel());		
	}
	
	public String toString() {
		return label;
	}
}
