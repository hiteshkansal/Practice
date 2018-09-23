package com.booking.interviewexperience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*10. You are given user request for hotels in format:
     {
          id: 1 -> name: 'Hotel name',
          id: 2 -> name: 'Yet another hotel name',
          id: 3 -> name: 'This is also a hotel name',
    }

You are also given a list of paris hotels ids: [32, 1, 45, 123, 456, 2, 52, 78, 12, 33, ....]
Your task is to write a function that will return you sorted list of hotel names from user request, where all hotels are located in paris.
*/
class Hotel1{
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hotel1(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class Q10_SortedParisHotel {

	public static void main(String[] args) {

		Hotel1 h1 = new Hotel1(1,"Hotel name");
		Hotel1 h2 = new Hotel1(32,"Yet another hotel name");
		Hotel1 h3 = new Hotel1(45,"This is also a hotel name");
		Hotel1 h4 = new Hotel1(123,"Not a paris hotel");
		
		List<Hotel1> list = new ArrayList<Hotel1>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);

		HashMap<Integer, Integer> parisHotel = new HashMap<>();
		parisHotel.put(32, 32);
		parisHotel.put(1, 1);
		parisHotel.put(45, 45);
		parisHotel.put(123, 123);
		parisHotel.put(456, 456);
		parisHotel.put(52, 52);
		parisHotel.put(2, 2);
		
		Map<String, Integer> out = new TreeMap<>();
		for(int i=0;i<list.size();i++){
			Hotel1 h = list.get(i);
			if(parisHotel.containsKey(h.getId())){
				out.put(h.getName(), h.getId());
			}
		}
		
		Set s = out.entrySet();
		Iterator i = s.iterator();
		
		while(i.hasNext()){
			Map.Entry m = (Map.Entry) i.next();
			System.out.println(m.getKey());
		}
	}

}
