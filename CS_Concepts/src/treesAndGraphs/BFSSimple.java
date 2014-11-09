package treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class BFSSimple {

	public static void main(String[] args) {
		Graph_ID1 g = new Graph_ID1();
		g.addEdge("S", "A");
		g.addEdge("S", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		g.addEdge("B", "D");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		g.addEdge("D", "E");
		
		BFSSimple b = new BFSSimple();
		b.bfs(g, "S");
	}
	
	public void bfs(Graph_ID1 g, String source){
			Set<String> visited = new HashSet<String>(); visited.add(source);
			Queue<String> queue = new LinkedList<String>(); queue.add(source);
			
			while(!queue.isEmpty()){
					String vertex = queue.remove();
					List<String> neighbours = g.getNeighbours(vertex);
					if(neighbours==null) continue;
					for(String n:neighbours)
							if(!visited.contains(n)){
									visited.add(n); queue.add(n);
							}
					
					System.out.println("Vertex Value : " + vertex);
			}
			
	}

}

class Graph_ID1{
	private Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	public List<String> getNeighbours(String vertex){
			return map.get(vertex);
	}
	
	public void addEdge(String v1, String v2){
			List<String> v1Neighbours = getNeighbours(v1);
			if(v1Neighbours==null) map.put(v1, v1Neighbours = new ArrayList<String>());
			v1Neighbours.add(v2);
			
			List<String> v2Neighbours = getNeighbours(v2);
			if(v2Neighbours==null) map.put(v2, v2Neighbours = new ArrayList<String>());
			v2Neighbours.add(v1);
	}
}