package task.structure;

import task.structure.exception.IsEmptyException;

public class LinkedQueue extends LinkedList implements Queue{
 
	private LinkedList myList; 
	public LinkedQueue() {
		 this.myList = new LinkedList(); 
	}  
	
	public static void main(String[] args) {
		 LinkedQueue myqueue = new LinkedQueue(); 
			 	myqueue.add("1");
				myqueue.add("2");
				myqueue.add("3");
				System.out.println(myqueue.toString());
				System.out.println(myqueue.getSize());
				System.out.println(myqueue.peek().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				myqueue.add("1");
				myqueue.add("2");
				myqueue.add("3");
				myqueue.add("4");
				myqueue.add("5");
				myqueue.add("6");
				System.out.println(myqueue.toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
				System.out.println(myqueue.pop().toString());
		 
	 
	}
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return this.myList.head.getData();  
	}
	
	@Override
	public Object pop(){
		Node popNode = this.myList.head; 
		try{
			this.myList.remove(0); 
			return popNode.getData();
		}catch (IsEmptyException e) {
			return null; 
		}
	}
	
	@Override 
	public String add(Object obj) {
		 return this.myList.add(obj); 
	}
 
	@Override
	public boolean isEmpty() {
		  return this.myList.size == 0; 
	} 
	
	@Override
	public int getSize() {
		return this.myList.size;
	}
	@Override
	public void clear() { 
	}

	public String toString(){
		 return this.myList.toString(); 
	}
	
	public String remove(int index){
		return this.myList.remove(index); 
	}
	public String remove(Object obj){
		return this.myList.remove(obj); 
	}
}
