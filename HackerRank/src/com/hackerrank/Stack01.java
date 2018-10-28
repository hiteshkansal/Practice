package com.hackerrank;

import java.util.Stack;

public class Stack01 {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[')
				st.push(c);
			else if (c == ')') {
				if (st.empty())
					return "NO";
				char t = st.pop();
				if (t != '(')
					return "NO";
			} else if (c == ']') {
				if (st.empty())
					return "NO";
				char t = st.pop();
				if (t != '[')
					return "NO";
			} else if (c == '}') {
				if (st.empty())
					return "NO";
				char t = st.pop();
				if (t != '{')
					return "NO";
			}
		}
		if (st.size() > 0)
			return "NO";
		return "YES";

	}

	public static void main(String[] args){
		System.out.println(isBalanced("((({{}})))"));
	}
}
