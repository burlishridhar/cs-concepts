package treesAndGraphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import treesAndGraphs.BasicImplementation.Graph;
import treesAndGraphs.BasicImplementation.Node;

public class BFSIterator implements Iterator<Node> {

	private Set<String> visited = null;
	private Queue<String> queue = null;
	private Graph graph;
	
	public BFSIterator(Graph g, String startingVertex) {
			visited = new HashSet<String>();
			queue = new LinkedList<String>();
			this.graph = g;
			this.visited.add(startingVertex);
			this.queue.add(startingVertex);
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge("S", "A");
		g.addEdge("S", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		g.addEdge("B", "D");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		g.addEdge("D", "E");

		BFSIterator bfs = new BFSIterator(g, "S");
		while(bfs.hasNext())
				System.out.println(bfs.next().getVertex());
		
	        
	}

	
	@Override
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}

	@Override
	public Node next() {
			
			String next = queue.remove();
			List<Node> list = graph.getNeighbours(next);
			if(list!=null){
					for(Node neighbour : list){
								if(!visited.contains(neighbour.getVertex())){
										queue.add(neighbour.getVertex()); visited.add(neighbour.getVertex());
								}
					}
			}
		
			return new Node(next);
	}

	@Override
	public void remove() {
			throw new UnsupportedOperationException();
	}	

}
