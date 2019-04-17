package com.booking.interviewexperience;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HackerRank_HowManyAgentsToAdd {

	public static void main(String[] args) {
		
		List<List<Integer>> listOLists = new ArrayList<List<Integer>>();
		ArrayList<Integer> singleList = new ArrayList<Integer>();
		singleList.add(1481122000);
		singleList.add(1481122020);
		listOLists.add(singleList);

		ArrayList<Integer> anotherList = new ArrayList<Integer>();
		anotherList.add(1481122000);
		anotherList.add(1481122040);
		listOLists.add(anotherList);
		
		ArrayList<Integer> anotherList1 = new ArrayList<Integer>();
		anotherList1.add(1481122030);
		anotherList1.add(1481122035);
		listOLists.add(anotherList1);
		
        System.out.println(howManyAgentsToAdd(0,listOLists));

	}

	static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {

        List<Integer> incall = new ArrayList<Integer>();
        List<Integer> outcall = new ArrayList<Integer>();

        List<Integer> temp = new ArrayList<Integer>();
        for(int i=0;i<callsTimes.size();i++){
            temp = callsTimes.get(i);
            incall.add(temp.get(0));
            outcall.add(temp.get(1));
        }

        Collections.sort(incall);
        Collections.sort(outcall);
        
       /* for(int i:incall)
        	System.out.println(i);
        
        for(int i:outcall)
        	System.out.println(i);
        */
        int guest=1, maxGuest=1;
        int i=1, j=0, len = incall.size();

        while(i<len && j<len){
            if(incall.get(i) <= outcall.get(j)){
                guest++;
                if (guest > maxGuest) {
                    maxGuest = guest;
                }
                i++;
            } else {
                guest--;
                j++;
            }
        }
        if(noOfCurrentAgents>maxGuest)
        	return 0;
        return maxGuest-noOfCurrentAgents;
    }
}
