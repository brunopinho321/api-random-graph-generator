package com.graph.generator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Vertex {
	private int index;
	private List<Integer> neighbors;
	public Vertex(int index){
		super();
		this.index = index;
		this.neighbors = new ArrayList<>();
	}
	public void addNeighbor(int neighbor) {
		this.neighbors.add(neighbor);
		Collections.sort(this.neighbors);
	}

	public boolean isNeighbor(int vertex) {
		return this.neighbors.contains(vertex);
	}
	
	public int getIndex() {
		return this.index;
	}
	public List<Integer> getNeighbors(){
		return this.neighbors;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String toString() {
		String str = "vertex: "+ this.index + "\n";
		str = str+" neighbors: ";
		for (Integer neighbor : neighbors) {
			str = str + neighbor+", ";
		}
		return str;
	}
}