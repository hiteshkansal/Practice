package com.booking.interviewexperience;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*input log = [
  { 'user': 'A', 'page': 1},
  { 'user': 'B', 'page': 5},
  { 'user': 'A', 'page': 2},
  { 'user': 'A', 'page': 1},
  { 'user': 'B', 'page': 2},
  { 'user': 'C', 'page': 7},
  { 'user': 'C', 'page': 3},
  { 'user': 'A', 'page': 3},
  { 'user': 'C', 'page': 1},
]

please implement
discover_site_map(log)

discover_site_map returns a representation of the links between pages, using whatever data structure you think is suitable:
1 -> 2, 3
2 -> 1
3 -> 1
5 -> 2
7 -> 3 */

class Graph {
	int totalPage;
	LinkedList<Integer> adjListArray[];

	Graph(int totalPage) {
		this.totalPage = totalPage;
		adjListArray = new LinkedList[totalPage];

		for (int i = 0; i < totalPage; i++) {
			adjListArray[i] = new LinkedList<>();
		}
	}

	static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
	}
}

public class Q36_SiteMapRepresent {

	 static void printGraph(Graph graph)
	    {       
	        for(int v = 0; v < graph.totalPage; v++)
	        {
	            System.out.println("Adjacency list of vertex "+ v);
	            System.out.print("head");
	            for(Integer pCrawl: graph.adjListArray[v]){
	                System.out.print(" -> "+pCrawl);
	            }
	            System.out.println("\n");
	        }
	    }
	      
	    public static void main(String args[])
	    {
	    	String log[]= {"'user': 'A', 'page': 1",
	    	               "'user': 'B', 'page': 5",
	    	               "'user': 'A', 'page': 2",
	    	               "'user': 'A', 'page': 1",
	    	               "'user': 'B', 'page': 2",
	    	               "'user': 'C', 'page': 7",
	    	               "'user': 'C', 'page': 3",
	    	               "'user': 'A', 'page': 3",
	    	               "'user': 'C', 'page': 1"};
	    	HashMap<String, String> map = new HashMap<>();
	    	
	    	for(int i=0;i<log.length;i++){
	    		String split[] = log[i].split(",");
	    		String userDetails[] = split[0].split(":");
	    		String pageDetails[] = split[1].split(":");
	    		if(map.containsKey(userDetails[1].trim())){
	    			String s = map.get(userDetails[1].trim());
	    			s = s.concat("-"+pageDetails[1].trim());
	    			map.put(userDetails[1].trim(), s);
	    		}
	    		else
	    			map.put(userDetails[1].trim(), pageDetails[1].trim());
	    	}
	    	/*Set set = map.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry) iterator.next();
				System.out.println(mentry.getValue());
			}*/
			
	        int V = 5;
	        Graph graph = new Graph(V);
	        graph.addEdge(graph, 0, 1);
	        graph.addEdge(graph, 0, 4);
	        graph.addEdge(graph, 1, 0);
	        graph.addEdge(graph, 1, 3);
	        graph.addEdge(graph, 1, 4);
	        graph.addEdge(graph, 2, 3);
	        graph.addEdge(graph, 3, 4);
	      
	        printGraph(graph);
	    }

}
