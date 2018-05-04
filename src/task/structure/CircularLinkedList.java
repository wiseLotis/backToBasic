package task.structure;


public class CircularLinkedList extends LinkedList implements List{
	
	public CircularLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String add(int index, Object input){
		if(index == 0){
			Node newNode = new Node(input); 
			newNode.setNextnode(head);
			head = newNode;  
			if(head.getNextnode() == null){
				tail = head; 
			}
			if(tail.getNextnode() == null){
				tail.setNextnode(head);
			}
		}else{
			Node newnode = new Node(input); 
			Node prev = (Node) get(index-1); 
			if(prev.getNextnode() == null){
				//append
				newnode.setNextnode(null);
				tail.setNextnode(newnode);
				tail = newnode;
			}else{
				//insert
				newnode.setNextnode(prev.getNextnode());
				prev.setNextnode(newnode);
			}
		}
		size++; 
		return toString(); 
	}
	

	@Override
	public Object get(int index){
		try {
			Node x= head; 
			for(int i = 0; i < index ; i++){
				x = x.getNextnode();
			}
			return x;
		} catch (Exception e) {
			throw e; 
		}
	}

	
	public static void main(String[] args) {
		CircularLinkedList newlist = new CircularLinkedList(); 
		newlist.add("1st"); 
		System.out.println(newlist.toString());
		newlist.add("2nd"); 
		newlist.add("3st"); 
		System.out.println(newlist.toString());
		System.out.println(newlist.getSize());	
		System.out.println(newlist.get(1));
		
		LinkedList.ListIterator itr = newlist.listIterator(); 
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
		
		System.out.println(newlist.remove(2));
		
		CircularLinkedList newlist2 = new CircularLinkedList(); 
		System.out.println(newlist2.setToString("1,2,3,4,5,6"));
		System.out.println("index3 = " + newlist2.get(3).toString());
		System.out.println("newlist2 size: " +  newlist2.getSize());
		newlist2.remove(0);
		System.out.println("newlist2 size: " +  newlist2.getSize());
		System.out.println(newlist2.remove("7"));
		System.out.println(newlist.toString());
		 
	}
	 
}
