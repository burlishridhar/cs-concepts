package treesAndGraphs.BasicImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<String, List<Node>> edges = null;
	
	public Graph(){
			edges = new HashMap<String, List<Node>>();
	}
	
	public void addEdge(String src, String dest){
			List<Node> srcNeighbours = getNeighbours(src);
			if(srcNeighbours==null) this.edges.put(src, srcNeighbours=new ArrayList<Node>());
			srcNeighbours.add(new Node(dest));
			
			List<Node> destNeighbours = getNeighbours(dest);
			if(destNeighbours==null) this.edges.put(dest, destNeighbours=new ArrayList<Node>());
			destNeighbours.add(new Node(src));
	}
	
	public List<Node> getNeighbours(String vertex){
		return this.edges.get(vertex);
		
	}
	
}
