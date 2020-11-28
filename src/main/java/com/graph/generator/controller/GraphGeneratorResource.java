package com.graph.generator.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graph.generator.generator.Generator;
import com.graph.generator.model.Graph;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/graphs")
@Api(value="API REST Graph Generator")
@CrossOrigin(origins = "*")
public class GraphGeneratorResource {
	private Generator generador = new Generator();
	
	@GetMapping(value="/simple/{vertex}/{edge}")
	@ApiOperation(value="Returns a simple random graph with with reported vertex numbers and edge numbers.")
	public ResponseEntity<Graph> getSimpleGraph(@PathVariable int vertex, @PathVariable int edge) {
		Graph g =  generador.GraphRand(vertex, edge);
		if(g == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(g); 
	}
	
	@GetMapping(value = "/tree/{vertex}")
	@ApiOperation(value = "Returns a random tree with reported vertex numbers.")
	public ResponseEntity<Graph> getTree(@PathVariable int vertex){
		Graph g = generador.TreeRand(vertex);
		if(g == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(g);
	}
	
	@GetMapping(value = "/partialgrid/{n}/{m}/{p}")
	@ApiOperation(value = "Returns a random partial grid with the dimensions (n x m), with p as the percentage of an edge appear between the two vertex of the grid.")
	public ResponseEntity<Graph> getRandomPartialGrid(@PathVariable int n, @PathVariable int m, @PathVariable int p){
		Graph g = generador.PartialGridRand(n, m, p);
		if(g == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(g);
	}
	
	@GetMapping(value = "/bipartite/{n}/{p}")
	@ApiOperation(value = "Returns a random bipartite graph with n vertices, and with p as the percentage of an edge appear between the two vertex of the graph.")
	public ResponseEntity<Graph> getRandomBipartiteGraph(@PathVariable int n, @PathVariable int p){
		Graph g = generador.BipartiteGraph(n, p);
		if(g == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(g);
	}
}
