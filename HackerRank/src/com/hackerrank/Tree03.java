package com.hackerrank;

import java.util.Scanner;

public class Tree03 {

	private static Node prev=null;
    static boolean checkBST(Node root) {
        if(root!=null){
            if(!checkBST(root.left))
                return false;
            if(prev!=null && root.data <= prev.data)
                return false;
            prev = root;
            return checkBST(root.right);
        }
        return true;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        
        if(checkBST(root))
        	System.out.println("Yes");
        else
        	System.out.println("No");
        scan.close();
    }
}
