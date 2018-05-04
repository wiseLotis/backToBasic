package task.structure;

import task.structure.exception.IsEmptyException;
import task.structure.exception.NotFoundException;

public class LinkedList implements List{

	public Node head,tail; 
	public int size = 0;

	public LinkedList() {

	}

	@Override
	public String add(Object input){
		return add(size,input);
	}
	@Override
	public String add(int index, Object input){
		Node newnode = new Node(input);  
		newnode.setNextnode(null);
		if(index == 0){
			newnode.setNextnode(head);
			head =newnode;
			if(head.getNextnode() == null){
				tail = head; 
			}
		}else{
			Node prev = (Node) get(index-1); 
			if(prev.getNextnode() == null){
				//append 
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


	@Override
	public int getSize(){
		return size; 
	} 

	@Override
	public int indexOf(Object input){
		Node x = head; 
		for(int i = 0 ; i < size ; i++){
			if(x.getData() == input){
				return i;  
			}else{
				x = x.getNextnode(); 
			}
		} 
		return -1;
	}

	@Override
	public String remove(int index){
		if(index == -1){
			throw new IsEmptyException(); 
		}
		if(index == 0){
			head = head.getNextnode(); 
		}else{
			Node prev = (Node) get(index-1);
			Node del = (Node) get(index); 
			prev.setNextnode(del.getNextnode());  

			if(del.equals(tail)){
				tail = prev; 
			}
		}
		size--; 
		return toString(); 
	}

	@Override
	public String remove(Object input){
		int index = indexOf(input); 
		if(index == -1){
			throw new NotFoundException(); 
		}else{
			return remove(index); 
		}
	}

	@Override
	public String toString(){
		if(size == 0){
			return "[]"; 
		}
		String str= "["; 
		Node x = head;
		for(int i = 1; i<size ; i++){
			str += x.getData().toString();
			str += ","; 
			x = x.getNextnode(); 
		}
		str += x.getData(); 
		str+="]"; 
		return str; 
	}

	public String setToString(String str){

		String[] strarr = str.split(",");
		for(int i = 0; i < strarr.length; i++){
			add(strarr[i]); 
		}

		return toString(); 

	}

	public static void main(String[] args) {
		LinkedList newlist = new LinkedList(); 
		System.out.println(newlist.add("1st")); 
		System.out.println(newlist.add("2nd"));
		System.out.println(newlist.getSize());		
		System.out.println(newlist.add(0,"-1"));
		System.out.println(newlist.indexOf("1st")); 
		try{
			System.out.println(newlist.indexOf("hello"));
		}catch (Exception e) {
			System.out.println("this is not on the list");
		}
		System.out.println(newlist.remove(1));
		System.out.println(newlist.remove(0));
		System.out.println(newlist.add("3rd"));
		System.out.println(newlist.add("4th"));
		System.out.println(newlist.get(2).toString());

		LinkedList newlist2 = new LinkedList(); 
		System.out.println(newlist2.setToString("1,2,3,4,5,6"));
		try{

			System.out.println(newlist2.remove("8"));
		}catch (NotFoundException e) {
			System.out.println("this is not on the list");
		}

		LinkedList.ListIterator itr = newlist.listIterator();  
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}

	}

	public class Node {

		private Object data;
		private Node nextnode;

		public Node(Object data) {
			this.data = data; 
			this.nextnode = null;
		}
		public Node getNextnode() {
			return this.nextnode;
		}

		public void setNextnode(Node nextnode) {
			this.nextnode = nextnode;
		}

		public Object getData() {
			return this.data;
		}

		public String toString(){
			return String.valueOf(this.data); 
		}
	}

	public class ListIterator {
		private Node next; 
		private Node lastReturn;
		private int nextIndex; 

		public ListIterator() {
			this.next = head; 
			this.nextIndex = 0; 
		}

		public Object next(){
			this.lastReturn = this.next; 
			this.next = this.next.getNextnode(); 
			nextIndex ++; 
			return lastReturn.getData(); 
		}

		public Boolean hasNext(){
			return nextIndex < getSize(); 
		}

	}
	public ListIterator listIterator(){
		return new ListIterator(); 
	}

}
