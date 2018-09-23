package com.booking.interviewexperience;

import java.util.Arrays;

//13. Given a check-in and check-out time of the visitors, find the pick moment of the hotel.
public class Q13_GuestsPeakTime {

	public static void peaktime(int [] checkin, int [] checkout, int len){
		Arrays.sort(checkin);
		Arrays.sort(checkout);
		
		int guest=1, maxGuest=1, time=checkin[0];
		int i=1, j=0;
		
		while(i<len && j<len){
			if(checkin[i]<=checkout[j]){
				guest++;
				if(guest>maxGuest){
					maxGuest=guest;
					time = checkin[i];
				}
				i++;
			}
			else {
				guest--;
				j++;
			}
		}
		System.out.println("Max number of Guests are " + maxGuest+" at "+time+" ");
	}
	
	public static void main(String[] args) {

		int checkin[] = {1, 2, 10, 6, 5};
        int checkout[] = {4, 5, 12, 9, 12};
        int n = checkout.length;
        peaktime(checkin, checkout, n);
	}

}
