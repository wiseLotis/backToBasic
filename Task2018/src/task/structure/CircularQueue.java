package task.structure;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

public class CircularQueue implements Queue{

	private int capacity = 0; 
	private int Front=0, Rear=0; 
	private Object[] myArray; 
	
	public CircularQueue() {
		this.capacity = 101; 
		this.myArray = new Object[101]; 
	}
	public CircularQueue(int capacity) {
		this.capacity = capacity; 
		this.myArray = new Object[capacity+1]; 
	}

	
	public static void main(String[] args) {
		 CircularQueue myqueue = new CircularQueue(5); 
			 	myqueue.add("1");
				myqueue.add("2");
				myqueue.add("3");
				System.out.println(myqueue.toString());
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
				System.out.println(myqueue.getArraytoString());
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
		return this.myArray[this.Front];
	}
	
	@Override
	public Object pop(){ 
		if(isEmpty()){
			System.out.println("this queue is empty!");
			return null; 
		}
		Object willPop = this.myArray[this.Front];
		this.Front = next(this.Front); 
 		return willPop;
	}
	
	@Override
	public String add(Object obj) {
 		if(isFull()){
			System.out.println("this queue is full of data");
		}else{
			System.out.println(this.Rear);
			this.myArray[this.Rear] = obj; 
		
			this.Rear = next(this.Rear); 
			 
			System.out.println("add" +  obj.toString() + "front : " +  this.Front + "   rear:  " + this.Rear);
		}
 		return obj.toString(); 
	}
	@Override
	public boolean isEmpty() {
		 
		if(this.Rear == this.Front){
			return true;
		}else{
			return false;
		}
		
	}

	public boolean isFull() {
		if(this.Rear== prev(this.Front)){
			return true;
		}else{
			return false;
		}
		
	}
	
	@Override
	public int getSize() {
	  return this.capacity; 
	}
	@Override
	public void clear() {
		this.Front = 0; 
		this.Rear = 0; 
	}
	
	public String toString(){
		String result = "["; 
		int front = this.Front; 
		int rear = this.Rear; 
		if (rear < front){
			rear += this.myArray.length; //front 보다 rear가 작다는건 뒤로 순환 되었다는거니까 array길이만큼 더해준다. 
		}
		result += this.myArray[front].toString() ; 
		while(front < rear-1){
			result += "," + this.myArray[next(front)].toString(); 
			front++; 
		}
		
		result += "]"; 
		
		return result; 
	}

	public String getArraytoString(){
		String result = "["; 
		 
		for(int i=0; i < myArray.length ; i++){
			result += myArray[i]; 
		}
		result += "]"; 
		return result; 
	}
	
	public int next(int num){
		if(num > this.capacity-1){
			System.out.println(num + ": " + this.myArray.length);
			return ++num - this.myArray.length; 
		}else{
			return ++num; 
		}
	}
	public int prev(int num){
		if(num == 0){
			return num + this.myArray.length-1; 
		}else{
			return --num; 
		}
	}
	 
	 
}
