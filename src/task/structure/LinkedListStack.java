package task.structure;

import task.structure.exception.IsEmptyException;

public class LinkedListStack extends LinkedList implements Stack{

	private LinkedList myList;  
	private Node top; 
	
	public LinkedListStack() {
		this.myList = new LinkedList(); 
		this.top = this.myList.tail; 
	}

	@Override
	public Object pop() {
		
		Node popNode = this.top; 
		try{
			this.myList.remove((this.myList.size -1)); 
			this.top = this.myList.tail; 
			return popNode.getData();
		}catch (IsEmptyException e) {
			return null; 
		}
		
	}

	@Override
	public Object peek() {
		return this.top;
	}

	@Override
	public boolean empty() {
		if(this.myList.size > 0){
			return false; 
		}else{
			return true; 
		}
	}

	@Override
	public int search(Object input) {
		return this.myList.indexOf(input);
	}

	@Override
	public void push(Object input) {
		this.myList.add(input);  		
		this.top = this.myList.tail; 
	}
	 
	public String toString(){
		return this.myList.toString(); 
	}
	
	public static void main(String[] args) {
		LinkedListStack myLinkedstack = new LinkedListStack(); 
		myLinkedstack.push("1");
		System.out.println(myLinkedstack.toString()); //[1]
		myLinkedstack.push("2");
		myLinkedstack.push("3");
		myLinkedstack.push("4");
		System.out.println(myLinkedstack.toString()); //[1,2,3,4]
		myLinkedstack.push("5"); 
		System.out.println( "search 3 : " + myLinkedstack.search("3") ); //search 3 : 2
		System.out.println(myLinkedstack.pop()); 
		System.out.println(myLinkedstack.pop()); 
		System.out.println(myLinkedstack.pop()); 
		System.out.println(myLinkedstack.toString());//[1,2]
		System.out.println(myLinkedstack.peek().toString()); //2
		System.out.println(myLinkedstack.toString());//[1,2]
		System.out.println(myLinkedstack.pop()); 
		System.out.println(myLinkedstack.pop()); 
		System.out.println(myLinkedstack.toString());//[1]
		System.out.println(myLinkedstack.pop()); 
		System.out.println(myLinkedstack.toString());//[]

	}
}
