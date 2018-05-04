package task.structure;

import java.util.Scanner;

import task.structure.LinkedList;
import task.structure.LinkedListStack;

public class Calculator {
	
	private LinkedListStack stack; 
	private LinkedList opList; 
	private String exp; 
	
	public Calculator() {
		this.stack = new LinkedListStack(); 
		this.opList = new LinkedList(); 
 	}
	public Calculator(String exp) {
		this.stack= new LinkedListStack(); 
		this.opList = new LinkedList(); 
		this.exp = exp; 
 	}
	
	public void setExperession(String exp){
		this.exp = exp; 
	}
	
	public String postfix(){
		String result = "";
	 	String[] expArr = this.exp.split(""); 
	 	for(int i = 0; i < expArr.length; i++){
			String now = expArr[i]; 
	 	
			if(now.matches("[\\d|\\.]")){
				 result +=now; 
			
			}else if(now.matches("[\\+|\\-|\\*|/|\\(|\\{|\\)|\\}]")){
				result += " "; 
				if(this.stack.empty()){
					this.stack.push(now);
					
				}else if(now.matches("[\\(|\\{]")){
					this.stack.push(now);
					
				}else if(now.matches("[\\)|\\}]")){
					
					while(!this.stack.empty()){
						 String top = this.stack.pop().toString(); 
						 if("(".equals(top)){
							 break; 
						 } 
							result +=  top; 
					}
				
				}else{
					String top = this.stack.peek().toString(); 

					while(!this.stack.empty() && getPriority(top)>=getPriority(now)){
						result +=this.stack.pop().toString(); 
						result +=" "; // 이걸 해줘야 함... 
					}
					
					this.stack.push(now);
				}
			}
	 	}
	 	while(!this.stack.empty()){
	 		result += " " + stack.pop(); 
	 	}
	 	System.out.println(result);
		return result;
	}
	
	public Object getResult(){
		String[] postfixExp = postfix().split("\\s");
		for(int j= 0; j < postfixExp.length ;  j++){
			String now = postfixExp[j]; 
			if(now.matches("[\\d|\\.]+")){
				 //System.out.println("push- " + now);
				 this.stack.push(now);
				 
			}else if(now.matches("[+|\\-|*|/]")){
				Integer num2 =  Integer.parseInt(this.stack.pop().toString());
				//System.out.println("pop-" + num2);
				Integer num1 = Integer.parseInt(this.stack.pop().toString());
				//System.out.println("pop-" + num1);
				Integer result = (Integer) calculation(num1, num2, now); 
				this.stack.push(result.toString());
				//System.out.println("push-" + result);
			}
		}
		return this.stack.pop().toString();
	}
	
	public Object calculation(Integer num1,Integer num2,String op){
		if("+".equals(op)){
			return  num1 + num2; 
		}else if("-".equals(op)){
			return num1 - num2; 
		}else if("*".equals(op)){
			return num1 * num2; 
		}else if("/".equals(op)){
			return num1 / num2; 	
		}
		 
		return null;
	}
		
	public int getPriority(String str){
		int priority = 0; 
		switch(str){
		case "+":
		case "-":
			priority = 1; 
			break; 
		case "*":
		case "/": 
			priority = 2; 
			break; 
		}
		return priority; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("수식을 입력해 주세요");
		String exp = sc.next(); 
		Calculator cir = new Calculator(exp);
		System.out.println(cir.getResult());
		
	}
	
	public static boolean isNumeric(String str){
		try{
			double d = Double.parseDouble(str); 
			return true; 
		}catch (NumberFormatException e) {
			return false; 
		}
		
	}


}
