package treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {

	public static void main(String[] args) {
		Graph_ID2 g = new Graph_ID2();
		g.addEdge("S", "A");
		g.addEdge("S", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		g.addEdge("B", "D");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		g.addEdge("D", "E");
		
		Dijkstra d = new Dijkstra();
		d.findShortestPath(g, "S", "E");
	}

	public void findShortestPath(Graph_ID2 g, String source, String destination){
			Set<String> visited = new HashSet<String>(); visited.add(source);
			Queue<String> queue = new LinkedList<String>(); queue.add(source);
			Map<String, String> previous = new HashMap<String, String>();
			Map<String, Integer> dist = new HashMap<String, Integer>();
			
			while(!queue.isEmpty()){
					String vertex = queue.remove();
					List<String> neighbours = g.getNeighbours(vertex);
					if(neighbours==null) continue;
					for(String neighbour:neighbours){
							Integer alt = dist.get(vertex)==null?0:dist.get(vertex) + 1;
							if(alt< (dist.get(neighbour)==null?0:dist.get(vertex))){
										dist.put(neighbour, alt); previous.put(neighbour,vertex);
							}
								
					}
			}
			
			List<String> shortestPath = new ArrayList<String>();
			String target = destination;
			while(previous.containsKey(target)){
					shortestPath.add(target);
					target = previous.get(target);
			}
			
			for(String s:shortestPath)
				System.out.println(s);
	}
}

class Graph_ID2{
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	public List<String> getNeighbours(String vertex){
			return map.get(vertex);
	}
	
	public void addEdge(String v1, String v2){
			List<String> v1Neighbours = map.get(v1);
			if(v1Neighbours==null) map.put(v1, v1Neighbours=new ArrayList<String>());
			v1Neighbours.add(v2);
			
			List<String> v2Neighbours = map.get(v2);
			if(v2Neighbours==null) map.put(v2, v2Neighbours=new ArrayList<String>());
			v2Neighbours.add(v1);
	}
}
