package com.graph.generator.model;

import java.util.ArrayList;
import java.util.List;


public class Graph {
	
	
	private List<Vertex> vertices = new ArrayList<>();
	private int edgeAmount = 0;
	private int [][] adjacencyMatrix;
	public void  generateVertices(int n) {
		Vertex v;
		this.adjacencyMatrix = new int [n][n];
		for(int i = 0; i < n; i++) {
			v = new Vertex(i);
			this.vertices.add(v);
			this.adjacencyMatrix[i][0] = 0;
			this.adjacencyMatrix[0][i] = 0;
			
		}
		
		
	}
	
	
	public int[][] getAdjacencyMatrix(){
		return this.adjacencyMatrix;
	}
	public String toString() {
		String str = "";
		for (Vertex vertex : vertices) {
			str = str + vertex.toString() + "\n";
		}
		
		return str;
	}
	
	public int getEdgeAmount() {
		return this.edgeAmount;
	}
	
	public Vertex getVertexByIndex(int index) {
		return this.vertices.get(index);
	}
	
	public List<Vertex >getAdjacencyList(){
		return this.vertices;
	}
	
	public boolean addEdget(Vertex v1, Vertex v2) {
		if(v1.isNeighbor(v2.getIndex())) {
			return false;
		}
		else if(v1.getIndex() == v2.getIndex()) {
			return false;
		}
		
		v1.addNeighbor(v2.getIndex());
		v2.addNeighbor(v1.getIndex());
		
		this.vertices.set(v1.getIndex(), v1);
		this.vertices.set(v2.getIndex(), v2);
		this.adjacencyMatrix[v1.getIndex()][v2.getIndex()] = 1;
		this.adjacencyMatrix[v2.getIndex()][v1.getIndex()] = 1;
		this.edgeAmount = this.edgeAmount + 1;
		return true;
	}
}
