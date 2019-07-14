import java.util.List;
import java.util.PriorityQueue;

public class Amazon2
{        
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 int minimumTime(int numOfSubFiles, List<Integer> files)
 {
     int result=0;
     PriorityQueue<Integer> q = new PriorityQueue<Integer>();
     for(Integer i:files)
         q.add(i);
     while(q.size()>1){
         int min1=q.peek();
         q.poll();
         
         int min2=q.peek();
         q.poll();
         
         int merge = min1+min2;
         result+=merge;
         q.add(merge);
     }
     return result;
 }
 // METHOD SIGNATURE ENDS
}