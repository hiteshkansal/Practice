package NineJuly;



public class Q1 {

	private class DoublyLinkedList{
		long data;
		DoublyLinkedList prev = null;
		DoublyLinkedList next = null;
	}
	
	static DoublyLinkedList top = null;
	static DoublyLinkedList bottom = null;
	static Q1 q = new Q1();
	
	public static boolean isEmpty() { 
        return top == null; 
    }
	
	public static long push(int x) { 
        DoublyLinkedList temp = q.new DoublyLinkedList(); 
        temp.data = x; 
        if(!isEmpty()){
        	temp.next = top;
            top.prev = temp;
        } else
        	bottom = temp;
        
        top = temp;
        return top.data;
    } 
  
    public static long pop() { 
        if (isEmpty())
            return -1; 

        DoublyLinkedList t = top;
        top = top.next;
        t.next = null;
        if(!isEmpty()){
        	top.prev = null;
        	return top.data;
        } else {
        	bottom = null;
        	return -1;
        }
    }
    
    public static long inc(int a, long b) {
    	if(isEmpty())
    		return -1;
    	DoublyLinkedList t = bottom;
    	while(a > 0){
    		if(t != null){
	    		t.data += b;
	    		t = t.prev;
    		}
    		a--;
    	}
    	if(!isEmpty())
    		return top.data;
    	else
    		return -1;
    }
    
	static void superStack(String[] operations) {
		long r;
		for(int i=0; i<operations.length;i++){
			String s = operations[i];
			String[] s1 = s.split(" ");
			if(s1[0].equalsIgnoreCase("push")){
				r = push(Integer.parseInt(s1[1]));
				if(r==-1)
					System.out.println("EMPTY");
				else
					System.out.println(r);
			} else if(s1[0].equalsIgnoreCase("pop")){
				r = pop();
				if(r==-1)
					System.out.println("EMPTY");
				else
					System.out.println(r);
			} else if(s1[0].equalsIgnoreCase("inc")){
				r = inc(Integer.parseInt(s1[1]), Long.parseLong(s1[2]));
				if(r==-1)
					System.out.println("EMPTY");
				else
					System.out.println(r);
			}
		}
    }
	
	public static void main(String[] args) {
		String ss[] = {"push 4",
				"pop",
				"push 3",
				"push 5",
				"push 2",
				"inc 3 1",
				"pop",
				"push 1",
				"inc 2 2",
				"push 4",
				"pop",
				"pop"};
		superStack(ss);

	}

}
