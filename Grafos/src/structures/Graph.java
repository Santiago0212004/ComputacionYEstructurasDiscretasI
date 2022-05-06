package structures;

import java.util.ArrayList;

public class Graph<T> {
	
	private ArrayList<Vertex<T>> graph;
	
	public Graph(){
		graph = new ArrayList<>();
	}
	
	public void addVertex(Vertex<T> adding, Vertex<T> source) {
		if(!graph.contains(adding) && graph.contains(source)) {
			graph.add(adding);
			source.addAdjacency(adding);
		}
	}
	
}
