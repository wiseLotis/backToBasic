package task.structure;

import java.util.Scanner;


class BTreeNode<T>{
	private T data; 
	private BTreeNode<T> left; 
	public BTreeNode(T data){
		this.data = data; 
		this.left = null; 
		this.right = null; 
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BTreeNode<T> left) {
		this.left = left;
	}

	public BTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BTreeNode<T> right) {
		this.right = right;
	}

	private BTreeNode<T> right; 
	

}

public class BinaryTree implements Tree<BTreeNode<Object>>{
	private BTreeNode<Object> root; 
	public BinaryTree() {
		this.root = null; 
	}
	public BinaryTree(BTreeNode<Object> input){
		this.root = input; 
	}
	
 
	public static void main(String[] args) {
		BTreeNode<Object> a_node = new BTreeNode<Object>("+");
		BTreeNode<Object> b_node  = new BTreeNode<Object>("*");
		BTreeNode<Object> c_node  = new BTreeNode<Object>("1");
		BTreeNode<Object> d_node  = new BTreeNode<Object>("2");
		BTreeNode<Object> e_node  = new BTreeNode<Object>("-");
		BTreeNode<Object> f_node  = new BTreeNode<Object>("8");
		BTreeNode<Object> g_node  = new BTreeNode<Object>("7");
		BinaryTree myTree = new BinaryTree(a_node); 
		try {
			myTree.addChildNode(a_node, b_node);
			myTree.addChildNode(a_node, e_node);
			myTree.addChildNode(b_node, c_node);
			myTree.addChildNode(b_node, d_node);
			myTree.addChildNode(e_node, f_node);
			myTree.addChildNode(e_node, g_node);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(myTree.toString("preorder"));
		System.out.println(myTree.toString("inorder"));
		System.out.println(myTree.toString("postorder"));
		//System.out.println(myTree.isLeaf(a_node));
		//System.out.println(myTree.isLeaf(g_node));
		
	 
	}
	
	public String toString(String options){
		if("postorder".equals(options)){
			return toStringPostorder(getRoot());
		}else if("inorder".equals(options)){
			return toStringInorder(getRoot());
		}else{
			return toStringPreorder(getRoot());
		}
	}
 
	public String toStringPreorder(BTreeNode<Object> node ){
		String result = ""; 
		if(node == null){
			return ""; 
		}
		result +=  node.getData().toString() + "  "; 
		result += toStringPreorder(node.getLeft()); 
		result += toStringPreorder(node.getRight()); 
		return result;
	}
	
	public String toStringInorder(BTreeNode<Object> node ){
		String result = ""; 
		if(node == null){
			return ""; 
		}
		result += toStringInorder(node.getLeft()); 
		result += node.getData().toString()+ "  ";
		result += toStringInorder(node.getRight()); 

		return result;
	}
	public String toStringPostorder(BTreeNode<Object> node ){
		String result = ""; 
		if(node == null){
			return ""; 
		}
		result += toStringPostorder(node.getLeft()); 
		result += toStringPostorder(node.getRight()); 
		
		result +=  node.getData().toString() + "  "; 

		return result;
	}
	@Override
	public BTreeNode<Object> getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}
	public void setRoot(BTreeNode<Object> node) {
		this.root = node; 
	}
	@Override
	public int getDegree(BTreeNode<Object> parent) {
		int cnt = 0; 
		if(parent.getLeft() != null){
			cnt +=1; 
		}
		
		if(parent.getRight() != null ){
			cnt +=1; 
		}
		return cnt;
	}
	
	public void addChildNode(BTreeNode<Object> parent, BTreeNode<Object> child) throws Exception {
		if(parent.getLeft() == null){
			parent.setLeft(child);
			return; 
		}
		
		if(parent.getRight() == null){
			parent.setRight(child);
			return; 
		}
		
		throw new Exception("더이상 이노드에 자식노드를 추가할 수 없습니다. degree 2 이상입니다.");
	
	} 
	
	@Override
	public boolean isLeaf(BTreeNode<Object> node) {
		 
		return (node.getLeft() == null) && (node.getRight() == null);
	}
	
	@Override
	public BTreeNode<Object> getChild(BTreeNode<Object> parent, int index) {
		if(index == 0){
			return parent.getLeft(); 
		}else{
			return parent.getRight(); 
		}
	}
	 
}
