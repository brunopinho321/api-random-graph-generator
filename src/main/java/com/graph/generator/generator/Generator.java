package com.graph.generator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.graph.generator.model.Graph;
import com.graph.generator.model.Vertex;

public class Generator {
	private Graph g;
	private Random rand = new Random();
	
//	public Vertex randV(Graph g) {
//		int a = 0;
//		a = rand.nextInt(g.getAdjacencyList().size());
//		return g.getAdjacencyList().get(a);
//	}
	public Vertex randV(List<Vertex> list) {
		int a = rand.nextInt(list.size());
		return list.get(a);
	}
	
	public Graph GraphRand(int v, int e) {
		if(v < 1 && e > 0) {
			return null;
		}
		this.g = new Graph();
		this.g.generateVertices(v);
		
		if(e > (v*(v - 1)/2)) {
			System.out.println("the Number of edges must be less");
			return null;
		}
		while(this.g.getEdgeAmount() < e) {
			Vertex v1 = randV(this.g.getAdjacencyList());
			Vertex v2 = randV(this.g.getAdjacencyList());
			this.g.addEdget(v1, v2);

		}
		return this.g; 
	}
	
	public Graph TreeRand(int v) {
		if(v < 1) {
			return null;
		}
		this.g = new Graph();
		this.g.generateVertices(v);
		Vertex v1, v2;
		List<Vertex> list = new ArrayList<>();
		v1 = randV(this.g.getAdjacencyList());
		list.add(v1);
		while(list.size() < v) {
			v1 = randV(list);
			v2 = randV(this.g.getAdjacencyList());
			if(!list.contains(v2)) {
				this.g.addEdget(v1, v2);
				list.add(v2);
			}
		}
		return this.g;
	}
	
	public Graph PartialGridRand(int n, int m, int p) {
		if((n < 1 && m < 1) || (n < 0) || (m < 0)) {
			return null;
		}
		
		this.g = new Graph();
		
		this.g.generateVertices((n * m));
		
		int bottomInit = (n - 1) * m;
		
		List<Integer> rightCorner = new ArrayList<>();
		List<Integer> bottomCorner = new ArrayList<>();
		
		for(int i = 1; i < n+1; i++) {
			rightCorner.add((m * i) - 1);
		}
		for(int i = 0; i < m; i++) {
			bottomCorner.add(bottomInit + i);
		}
		double a;
		for (Vertex v : this.g.getAdjacencyList()) {
			a = rand.nextDouble();
			if(!rightCorner.contains(v.getIndex())) {
				if(a <= (p/100.0)) {
					this.g.addEdget(v, g.getVertexByIndex((v.getIndex() + 1)));
				}
			}
			
			if(!bottomCorner.contains(v.getIndex())) {
				a = rand.nextDouble();
				if(a <= (p/100.0)) {
					this.g.addEdget(v,this.g.getVertexByIndex((v.getIndex() + m)));
				}
			}
		}
		return this.g;
	}
}
