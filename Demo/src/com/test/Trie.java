package com.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Trie {

	final int ALPHABET_SIZE = 26;
	Trie[] children = new Trie[ALPHABET_SIZE];
	boolean isEnd;

	Trie() {
		isEnd = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}

	static Trie root = new Trie();

	public static void insert(String key) {
		int level, index;
		int length = key.length();

		Trie child = root;

		for (level = 0; level < length; level++) {
			if (!Character.isAlphabetic(key.charAt(level)))
				continue;
			if (Character.isLowerCase(key.charAt(level)))
				index = key.charAt(level) - 'a';
			else
				index = key.charAt(level) - 'A';
			if (child.children[index] == null)
				child.children[index] = new Trie();

			child = child.children[index];
		}

		child.isEnd = true;
	}

	public static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		Trie child = root;

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

	static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
		Trie tr = new Trie();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		String keys[] = keywords.split(" ");
		for (String s : keys) {
			tr.insert(s);
		}
		int len = reviews.length;
		for (int i = 0; i < len; i++) {
			int count = 0;
			String review = reviews[i];
			String revword[] = review.split(" ");
			for (String s : revword) {
				if (tr.search(s))
					count++;
			}
			if (map.containsKey(hotel_ids[i])) {
				int val = map.get(hotel_ids[i]);
				count += val;
			}
			map.put(hotel_ids[i], count);
		}

		map = (TreeMap<Integer, Integer>) sortByValues(map);
		Set set = map.entrySet();
		int[] result = new int[map.size()];
		Iterator iter = set.iterator();
		int j = 0;
		while (iter.hasNext()) {
			Map.Entry mentry = (Map.Entry) iter.next();
			result[j++] = (int) mentry.getKey();
		}
		return result;
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
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

	public static void main(String args[]) {

		String key = "breakfast beach citycenter location metro view staff price";
		int[] hotel_id = { 1, 2, 1, 2, 1, 2 };
		String[] review = { "This hotel has a nice view of the citycenter. The location is perfect.",
				"The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
				"Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
				"They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
				"Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter." };

		int[] r = sort_hotels(key, hotel_id, review);
		for (int i : r) {
			System.out.println(i);
		}
	}
}