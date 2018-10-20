package com.hackerrank;

import java.util.Scanner;

/*
 * Height of binary tree( Maximum edges in longest path)
 */
class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class Tree01 {

	public static int height(Node root) {
		// Write your code here.
		if (root == null)
			return -1;	//Maximum edges on longest path. return 0 if max nodes
		int l = height(root.left);
		int r = height(root.right);
		return 1 + Math.max(l, r);
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = height(root);
		System.out.println(height);
	}
}