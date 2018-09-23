package com.booking.interviewexperience;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 3. We want to implement a feature to suggest to users the  cheapest hotel that is more popular than the one they are looking at. Write a function that given an array of hotels, sorted by their popularity returns a map from the hotel ids that associates each hotel with the cheapest hotel that is more popular than the one in question. if there is no hotel that is cheaper and more popular than the one with that id, then it shouldn't be put in the map. You can assume that hotel ids and prices are integers and that hotels have the following format: struct hotel{ int id; int price; } 
Example 1: input = 
[{ id => 123, price => 200 }, # Most popular
 { id => 55, price => 150 }, # Second most popular 
 { id => 17, price => 70 }, # Third most popular
 { id => 18, price => 500 }, # ... 
 { id => 27, price => 270 }, 
 { id => 101, price => 230 } # Least popular ]
 output = { 18 : 17, 27 : 17, 101 : 17 }
 */
class Hotel{
	int id;
	int price;
	public Hotel(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

public class Q3_CheapestPopularHotel {

	public static void main(String[] args) {

		List<Hotel> hotels = new ArrayList<Hotel>();
		Hotel h1 = new Hotel(123,200);
		Hotel h2 = new Hotel(55,150);
		Hotel h3 = new Hotel(17,70);
		Hotel h4 = new Hotel(18,500);
		Hotel h5 = new Hotel(27,50);
		Hotel h6 = new Hotel(101,230);
		hotels.add(h1);
		hotels.add(h2);
		hotels.add(h3);
		hotels.add(h4);
		hotels.add(h5);
		hotels.add(h6);
		Map<Integer, Integer> result = new TreeMap<Integer, Integer>();
		
		Hotel cheapestSoFar = hotels.get(0);
		for(int i=1;i<hotels.size();i++){
			Hotel curr = hotels.get(i);
			if(curr.getPrice()>cheapestSoFar.getPrice())
				result.put(curr.getId(), cheapestSoFar.getId());
			if(curr.getPrice()<cheapestSoFar.getPrice())
				cheapestSoFar = curr;
		}
		
		Set s = result.entrySet();
		Iterator iter = s.iterator();
		while(iter.hasNext()){
			Map.Entry m = (Map.Entry) iter.next();
			System.out.println(m.getKey() +" -> "+m.getValue());
		}
	}
}
