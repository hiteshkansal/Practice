package com.arcesium;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {



    // Complete the getPosition function below.
    static int getPosition(List<Integer> roll, List<Integer> st, List<Integer> ed) {

        int pos=0, j=0;
        //pos=roll.get(0);
        for(int i=0;i<roll.size();i++){
            pos+=roll.get(i);

            while(j<st.size()){
                int ladStartPos = st.get(j);
                if(ladStartPos!=pos){
                    break;
                }
                int ladEndPos = ed.get(j);
                int ladnextStartPos, nextRollPos;;
                if(j+1>=st.size()){
                    if(pos==ladStartPos){
                        pos += ladEndPos- ladStartPos;
                    }
                    break;
                }
                if(i+1<roll.size()){
                    ladnextStartPos = st.get(j + 1);
                    nextRollPos = roll.get(i+1);
                    if(ladnextStartPos<ladEndPos){
                        pos=ladnextStartPos;
                        j++;
                    } else if((ladnextStartPos-nextRollPos)<ladEndPos){
                        pos = ladnextStartPos;
                        j++;
                        i++;
                        //break;
                    }
                }
                //j++;
            }
            if(j==st.size() && i<roll.size()){
            	while(i<roll.size()){
            		pos+=roll.get(i);
            		i++;
            	}
            }
        }
        
        return pos;
    }
    
    static int two_bst(List<Integer> v) {

        int len = v.size();

        double n = ((int)(len/2))+1;

        return (int)(Math.log(n)/Math.log(2.0))+1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rollCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> rollTemp = new ArrayList<>();

        IntStream.range(0, rollCount).forEach(i -> {
            try {
                rollTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> roll = rollTemp.stream()
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int stCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> stTemp = new ArrayList<>();

        IntStream.range(0, stCount).forEach(i -> {
            try {
                stTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> st = stTemp.stream()
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int edCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> edTemp = new ArrayList<>();

        IntStream.range(0, edCount).forEach(i -> {
            try {
                edTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ed = edTemp.stream()
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int res = getPosition(roll, st, ed);

       System.out.println(res);
    }
}

