package task.structure;

import java.util.Scanner;



public class ExpressionTree extends BinaryTree implements Tree<BTreeNode<Object>>{

	BinaryTree exptree = null; 
	public ExpressionTree() {
		exptree = new BinaryTree(); 
	}
	public ExpressionTree(BTreeNode<Object> input){
		exptree = new BinaryTree(input); 
	}

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		System.out.println("수식을 입력해 주세요");
		String exp = sc.next(); 
		Calculator cir = new Calculator(exp);
		String postexp = cir.postfix(); 

	}
	public BTreeNode buildTree(BTreeNode parent, String exp){
		
		return parent;
	}
	public BinaryTree getTree(String exp){
		int i = exp.length() -1 ; 
		BTreeNode<Object> root = new BTreeNode<Object>(exp.charAt(i));
		if(isOperaion(exp.charAt( exp.length()))){
			this.exptree.setRoot(root); 
		}else{
			throw new RuntimeException("연산자가 아닌 글자는 root가 될 수 없습니다."); 
		}
		i--; 
		
		for(int j = i ; j > 0; j--){

			BTreeNode<Object> node = new BTreeNode<Object>(exp.charAt(j)); 
			if(i==0){
				if(isOperaion(exp.charAt(i))){
					this.exptree.setRoot(node); 
				}else{
					throw new RuntimeException("연산자가 아닌 글자는 root가 될 수 없습니다."); 
				}
			}else{
				if(isOperaion(exp.charAt(i))){
					buildTree(node, exp);
				}
				addNode(node); 
			}

		}
		System.out.println(this.exptree.toString("preorder"));
		System.out.println(this.exptree.toString("inorder"));
		System.out.println(this.exptree.toString("postorder"));
		return this.exptree;
	}

	private boolean isOperaion(char charAt) {
		// TODO Auto-generated method stub
		String op = "+-/*"; 
 		return op.indexOf(String.valueOf(charAt)) > 0; 
	}
	
	public void addNode(BTreeNode<Object> node) {
		

	} 
}
