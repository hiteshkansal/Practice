package com.soroco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q3 {

	static StringBuilder sb = new StringBuilder("");
		public static String find_path(List<List<String>> matrix, String word) {
			int R = matrix.size();
			int C = matrix.get(0).size();
			String s="";
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(search(matrix, word, i, j, 0, R,C)){ 
						return sb.toString();
					}
				}
			}
			return "NO PATH";
		}

		public static boolean search(List<List<String>> matrix, String word, int row, int col,
				int index, int R, int C) {


			if (!matrix.get(row).get(col).equals(word.charAt(index)+"")) {
				return false;
			}

			if (index == word.length() - 1) {
				return true;
			}

			if (row + 1 < R && search(matrix, word, row + 1, col, index + 1, R,C)) {
				sb.append("D");
				return true;
			}
			
			if (col + 1 < C && search(matrix, word, row, col + 1, index + 1, R,C)) {
				sb.append("R");
				return true;
			}
			
			return false;
		}

		public static void main(String[] args) throws IOException {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
	        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

	        List<List<String>> matrix = new ArrayList<>();

	        IntStream.range(0, matrixRows).forEach(i -> {
	            try {
	                matrix.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                        .collect(Collectors.toList())
	                );
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        String target_string = bufferedReader.readLine();

	        System.out.println(find_path(matrix, target_string));

		}

	}
	
/*
	static boolean flag = false;
	static String find_path(List<List<String>> matrix, String word) 
	{ 
		int R = matrix.size();
		int C = matrix.get(0).size();
		String s="";
	    for (int row = 0; row < R; row++) {
	       for (int col = 0; col < C; col++) {
	          s = patternSearch(matrix, row, col,R, C, word);
	          if(flag)
	        	  break;
	       }
	       if(flag)
	        	  break;
	    }
	    if(!flag)
	    	return "NO PATH";
	    return s;
	            
	} 
	
	static String patternSearch(List<List<String>> matrix, int row, int col, int R, int C, String word) 
	{ 
		int x[] = {1,0};
		int y[] = {0,1};
		int lastChar=0;
	    StringBuilder s = new StringBuilder("");
	    int len = word.length(); 
	    if (!matrix.get(row).get(col).equals(word.charAt(0)+"")) 
	        return "NO PATH"; 
	    
	    for (int dir = 0; dir < 2; dir++) 
	    { 
	        int k, rd = row + x[dir], cd = col + y[dir]; 
	        for (k = 1; k < len; k++) 
	        { 
	            // If out of bound break 
	            if (rd >= R || rd < 0 || cd >= C || cd < 0) {
	            	s = s.deleteCharAt(lastChar);
	            	break;
	            }
	                 
	  
	            // If not matched,  break 
	            if (!matrix.get(rd).get(cd).equals(word.charAt(k)+"")){
	            	s = s.deleteCharAt(lastChar);
	                break; 
	            }
	  
	            rd += x[dir];
	            cd += y[dir]; 
	            if(dir==0)
	            	s.append("D");
	            if(dir==1)
		           	s.append("R");
	            lastChar=k;
	        } 
	  
	        if (k == len) {
	        	flag = true;
	            return s.toString();
	        }
	    } 
	    return "";
	    
	} 
	
	public static void main(String arg[]) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> matrix = new ArrayList<>();

        IntStream.range(0, matrixRows).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        String target_string = bufferedReader.readLine();

        System.out.println(find_path(matrix, target_string));
	}
*/
