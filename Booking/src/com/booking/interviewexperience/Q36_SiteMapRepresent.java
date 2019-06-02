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
	        for(int v = 1; v < graph.totalPage; v++)
	        {
	        	int i=0, size=graph.adjListArray[v].size();
	        	if(size>0){
		            System.out.print(v+"->");
		            for(Integer pCrawl: graph.adjListArray[v]){
		            	if(i++==size-1)
		            		System.out.print(pCrawl);
		            	else
		            		System.out.print(pCrawl+",");
		            }
		            System.out.println();
	        	}
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
	    	
	    	int max = Integer.MIN_VALUE;
	    	for(int i=0;i<log.length;i++){
	    		String split[] = log[i].split(",");
	    		String userDetails[] = split[0].split(":");
	    		String pageDetails[] = split[1].split(":");
	    		String user = userDetails[1].trim(), page=pageDetails[1].trim();
	    		if(map.containsKey(user)){
	    			String s = map.get(user);
	    			s = s.concat("-"+page);
	    			map.put(user, s);
	    		}
	    		else
	    			map.put(user, page);
	    		if(Integer.parseInt(page)>max)
	    			max = Integer.parseInt(page);
	    	}
	    	System.out.println("Total pages: "+max);
	    	Graph graph = new Graph(max+1);
	    	
	    	Set set = map.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry) iterator.next();
				String val = (String) mentry.getValue();
				String stringRes[] = val.split("-");
				for(int i=0;i<stringRes.length-1;i++){
					int src = Integer.parseInt(stringRes[i]);
					int dest = Integer.parseInt(stringRes[i+1]);
					graph.addEdge(graph, src, dest);
				}
			}
	        printGraph(graph);
	    }

}
