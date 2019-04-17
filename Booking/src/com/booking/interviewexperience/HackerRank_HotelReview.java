package com.booking.interviewexperience;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HackerRank_HotelReview {

	final int ALPHABET_SIZE = 26;
	HackerRank_HotelReview[] children = new HackerRank_HotelReview[ALPHABET_SIZE];
	boolean isEnd;

	HackerRank_HotelReview() {
		isEnd = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}

	static HackerRank_HotelReview root = new HackerRank_HotelReview();

	public static void insert(String key) {
		int level, index;
		int length = key.length();

		HackerRank_HotelReview child = root;

		for (level = 0; level < length; level++) {
			if (!Character.isAlphabetic(key.charAt(level)))
				continue;
			if (Character.isLowerCase(key.charAt(level)))
				index = key.charAt(level) - 'a';
			else
				index = key.charAt(level) - 'A';
			if (child.children[index] == null)
				child.children[index] = new HackerRank_HotelReview();

			child = child.children[index];
		}

		child.isEnd = true;
	}

	public static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		HackerRank_HotelReview child = root;

		for (level = 0; level < length; level++) {
			if (!Character.isAlphabetic(key.charAt(level)))
				continue;
			if (Character.isLowerCase(key.charAt(level)))
				index = key.charAt(level) - 'a';
			else
				index = key.charAt(level) - 'A';

			if (child.children[index] == null)
				return false;

			child = child.children[index];
		}

		return (child != null && child.isEnd);
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
	
	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		HackerRank_HotelReview tr = new HackerRank_HotelReview();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		String keys[] = keywords.split(" ");
		for (String s : keys) {
			tr.insert(s);
		}
		int len = reviews.size();
		for (int i = 0; i < len; i++) {
			int count = 0;
			String review = reviews.get(i);
			String revword[] = review.split(" ");
			for (String s : revword) {
				if (tr.search(s))
					count++;
			}
			if (map.containsKey(hotel_ids.get(i))) {
				int val = map.get(hotel_ids.get(i));
				count += val;
			}
			map.put(hotel_ids.get(i), count);
		}

		map = (TreeMap<Integer, Integer>) sortByValues(map);
		Set set = map.entrySet();
		//List<Integer> result = new int[map.size()];
		List<Integer> result = new ArrayList<Integer>();
		Iterator iter = set.iterator();
		int j = 0;
		while (iter.hasNext()) {
			Map.Entry mentry = (Map.Entry) iter.next();
			result.add((int) mentry.getKey());
			j++;
		}
		return result;
	}

	/*public static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		HashMap<String, String> hMap = new HashMap<String, String>();
		String s[] = keywords.split(" ");
		for (String s1 : s) {
			hMap.put(s1.toLowerCase(), s1.toLowerCase());
		}
		int len = hotel_ids.size();
		for (int i = 0; i < len; i++) {
			int count = 0;
			String rev = reviews.get(i);
			String revkey[] = rev.split(" ");
			for (int h = 0; h < revkey.length; h++) {
				if (hMap.containsKey(revkey[h].toLowerCase()))
					count++;
			}
			if (map.containsKey(hotel_ids.get(i))) {
				int val = map.get(hotel_ids.get(i));
				count += val;
			}
			map.put(hotel_ids.get(i), count);

		}

		map = (TreeMap<Integer, Integer>) sortByValues(map);
		Set set = map.entrySet();
		List<Integer> result = new ArrayList<Integer>();
		Iterator iterator = set.iterator();
		int j = 0;
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			result.add((int) mentry.getKey());
			j++;
		}

		return result;
	}
*/
	
	public static void main(String args[]) {

		String key = "breakfast beach citycenter location metro view staff price";
		List hotel_id = new ArrayList<Integer>();
		hotel_id.add(1);
		hotel_id.add(2);
		hotel_id.add(1);
		hotel_id.add(1);
		hotel_id.add(2);
		
		List<String> review = new ArrayList<String>();
		review.add("This hotel has a nice view of the citycenter. The location is perfect.");
		review.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
		review.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		review.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		review.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

		//HotelReview hr = new HotelReview();
		List r = sort_hotels(key, hotel_id, review);
		for (int i=0; i<r.size();i++) {
			System.out.println(r.get(i));
		}
	}
	
}
