package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * 1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
 */
class ListNode{
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeKSortedList {

	public static void main(String[] args) {
		ArrayList<ListNode> re = new ArrayList<>();
		ListNode tt = new ListNode(1);
		ListNode tt3 = new ListNode(4);
		ListNode tt6 = new ListNode(3);
		
		tt.next = new ListNode(10);
		tt.next.next=new ListNode(20);
		
		tt3.next = new ListNode(11);
		tt3.next.next = new ListNode(13);
		
		tt6.next =  new ListNode(8);
		tt6.next.next = new ListNode(9);
		re.add(tt);
		re.add(tt3);
		re.add(tt6);
		
		ListNode rr = mergeKLists(re);
		
		while(rr!=null){
			System.out.print(rr.val+" -> ");
			rr = rr.next;
		}
	}
	
	public static ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare (ListNode a, ListNode b){
				return a.val-b.val;
			}
		});
		
		for(int i=0;i<a.size();i++){
			pq.add(a.get(i));
		}
		ListNode head = null,last = null, temp;
		while(!pq.isEmpty()){
			temp = pq.peek();
			pq.remove();
			
			if(temp.next!=null)
				pq.add(temp.next);
			
			if(head==null){
				head = temp;
				last = temp;
			} else {
				last.next = temp;
				last = temp;
			}
			
		}
		return head;
    }

}
