package com.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Given an array of n Player objects, write a comparator that sorts them in order of decreasing score. 
 * If 2 or more players have the same score, sort those players alphabetically ascending by name. 
 * To do this, you must create a Checker class that implements the Comparator interface, 
 * then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
 */
class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
	// complete this method
	public int compare(Player a, Player b) {

		int result = a.score - b.score;
		if (result == 0) {
			result = a.name.compareTo(b.name);
			return result < 0 ? -1 : 1;
		}
		return result < 0 ? 1 : -1;
	}
}

public class Sorting03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}
