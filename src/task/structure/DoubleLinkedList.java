package task.structure;

import task.structure.exception.NotFoundException;

public class DoubleLinkedList extends LinkedList implements List{
	
	public DoubleLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	class doubleNode extends Node{

		private doubleNode prevnode;
		
		public doubleNode(Object data) {
			super(data);
		}

		public doubleNode getPrevnode() {
			return prevnode;
		}

		public void setPrevnode(doubleNode prevnode) {
			this.prevnode = prevnode;
		}
		
	}
	
	@Override
	public Object get(int index){
		try {
			if(size/2 < index){
				doubleNode x = (doubleNode) tail; 
				for(int i = size-1; i > index; i--){
					x = x.getPrevnode(); 
				}
				return x; 
			}else{
				Node x= head; 
				for(int i = 0; i < index ; i++){
					x = x.getNextnode();
				}
				return x;
			}
		} catch (Exception e) {
			throw e; 
		}
	}
	

	public String add(int index, Object input){
		doubleNode newnode = new doubleNode(input); 
		newnode.setPrevnode(null);
		newnode.setNextnode(null);
		if(index == 0 ){
			newnode.setNextnode(head);
			head = newnode; 
			if(head.getNextnode() == null){
				tail = head; 
			}
		}else{
			doubleNode prev = (doubleNode) get(index-1); 
			if(prev.getNextnode() == null){
				prev.setNextnode(newnode);
				newnode.setPrevnode(prev);
			}else{
				doubleNode next = (doubleNode) prev.getNextnode(); 
				newnode.setNextnode(next);
				newnode.setPrevnode(prev); 
				prev.setNextnode(newnode);
				next.setPrevnode(newnode); 
			}
		}
		size++; 
		return toString(); 

	}
 
	
	public String remove(int index){
		
		doubleNode node = (doubleNode) get(index); 
		
		if(index == -1){
			return "no data to delete " ; 
		}
		
		if(index == 0){
			// head를 삭제
			 doubleNode tobe = (doubleNode) head.getNextnode();
			 tobe.setPrevnode(null);
			 head = tobe; 
		}else if(node.getNextnode() == null){ //tail인경우 
			doubleNode prev = (doubleNode) node.getPrevnode(); 
			prev.setNextnode(null);
			tail = prev; 
		}else{
			doubleNode prev = (doubleNode) node.getPrevnode(); 
			doubleNode next = (doubleNode) node.getNextnode(); 
			prev.setNextnode(next);
			next.setPrevnode(prev);
		}
		size--; 
		return toString();
	}
	
	public static void main(String[] args) {
		DoubleLinkedList newlist = new DoubleLinkedList(); 
		System.out.println(newlist.add("1st"));
		System.out.println(newlist.add("2nd"));
		System.out.println(newlist.add("3rd"));
		System.out.println("size: " + newlist.getSize());	
		System.out.println("index1: "+newlist.get(1));
		
		System.out.println("iterator ");
		LinkedList.ListIterator itr = newlist.listIterator(); 
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
		
		System.out.println("remove index1:    "+ newlist.remove(1));
		System.out.println("add 2nd index1 ...");
		System.out.println(newlist.add(1,"2nd"));
		System.out.println("set to string ... 1,2,3,4,5,6");
		DoubleLinkedList newlist2 = new DoubleLinkedList(); 
		System.out.println(newlist2.setToString("1,2,3,4,5,6"));
		System.out.println("index3 : " + newlist2.get(3).toString());
		System.out.println("insert 0 to index0 : " +  newlist2.add(0,"0"));
		try{
			System.out.println("remove data 7 :"+  newlist2.remove("7"));
		}catch (NotFoundException e) {
			System.out.println("this is not on list");
		}
		
		System.out.println(newlist2.toString());
		
	}
	 
}
