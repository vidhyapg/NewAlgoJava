package org.vidhya.algoii;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMSTPrims {

	MSTPrims mst; 
	
	@Before
	public void createNewGraph() {
		mst = new MSTPrims();	
	}	
	
	@Test
	public void testAddEdges() {
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		
		mst.addEdge(A, B, 1);
		mst.addEdge(A, D, 2);
		mst.addEdge(B, D, 3);
		mst.addEdge(B, C, 4);
		mst.addEdge(C, D, 5);
		assertEquals(mst.getNumVertices(), 4);
		assertEquals(mst.getNumEdges(), 5);
		
		for(Edge e : mst.computeMST()) {
			System.out.println(e);	
		}
		System.out.println("Cost of MST is: "+ mst.computeMSTCost());
	}
	
	@Test
	public void testMST2() {
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		Vertex G = new Vertex("G");
		Vertex H = new Vertex("H");
		
		mst.addEdge(A, B, 1);
		mst.addEdge(A, D, 2);
		mst.addEdge(B, D, 3);
		mst.addEdge(B, C, 4);
		mst.addEdge(C, D, 5);
		mst.addEdge(A, E, 6);
		mst.addEdge(A, F, 7);
		mst.addEdge(B, G, 2);
		mst.addEdge(C, H, 9);
		mst.addEdge(A, D, 1);
		mst.addEdge(C, F, 11);
		mst.addEdge(D, H, 5);
		mst.addEdge(E, C, 8);
		mst.addEdge(H, G, 7);
		mst.addEdge(B, F, 14);
		
		assertEquals(mst.getNumVertices(), 8);
		assertEquals(mst.getNumEdges(), 15);
		
		for(Edge e : mst.computeMST()) {
			System.out.println(e);	
		}
		System.out.println("Cost of MST is: "+ mst.computeMSTCost());
	}

}
