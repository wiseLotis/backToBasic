package task.structure;

import task.structure.exception.IsEmptyException;


public class ArrayStack implements Stack{

	private int top; 
	private Object[] arrStack;  
	public static void main(String[] args) {
		ArrayStack mystack = new ArrayStack(4); 
		mystack.push("1");
		try{
			System.out.println(mystack.toString()); //[1, null, null, null]
			mystack.push("2");
			mystack.push("3");
			mystack.push("4");  
			System.out.println(mystack.toString()); //[1, null, null, null]
			mystack.push("5"); //your stack is already full.

		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("your stack is already full.");
		}
		try{
			System.out.println( "search 3 : " + mystack.search("3") ); //search 3 : 1 
			
			mystack.pop(); 
			mystack.pop(); 
			mystack.pop(); 
			System.out.println(mystack.toString());//[1]
			System.out.println(mystack.peek().toString()); //1
			System.out.println(mystack.toString());//[1]
			mystack.pop();
			System.out.println(mystack.toString());//[]
			mystack.pop(); // This stack is Empty Now!
		}catch (IsEmptyException ex) {
			 System.out.println("This stack is Empty Now!");
		}

	}
	public ArrayStack(int max) {
		this.top = -1; 
		this.arrStack = new Object[max]; 
	}

	@Override
	public Object pop() {
		if(empty()){
			throw new IsEmptyException("비어있는 stack입니다." ); 
		}
		
		this.arrStack[top] = null; 
		return this.arrStack[top--];
		
	}

	@Override
	public void push(Object input) {
		
		try{
			this.arrStack[this.top+1] = input; 
			this.top++; 
		}catch (ArrayIndexOutOfBoundsException e) {
			throw e; 
		}
		
	}

	@Override
	public Object peek() {
		if(empty()){
			throw new IsEmptyException("비어있는 stack입니다." ); 
		} 
		return this.arrStack[top];
	}

	@Override
	public boolean empty() {
		if(top < 0 ){ // 0 일때 
			return true; 
		}else{
			return false; 
		}
	}

	@Override
	public int search(Object input) {
		if(empty()){
			throw new IsEmptyException("비어있는 stack입니다."); 
		}
		
		int i = this.top; 
		while(i > -1 ){
			if(input.equals(this.arrStack[i])){
				break; 
			}
			i--; 
		}
		return i;
	}
	
	public String toString(){
		if(empty()){
			return "[]"; 
		}
		
		String str= "["; 
		int i = 0; 
		while(i < this.top){
			str += this.arrStack[i].toString() + ","; 
			i++; 
		} 
		str += this.arrStack[i]; 
 		return str+="]"; 
	}

}
