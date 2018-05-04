package task.structure;

class LCRSTreeNode<T>{
	private T data; 
	private LCRSTreeNode<T> leftChild; 
	private LCRSTreeNode<T> rightSibling; 

	public LCRSTreeNode(T data){
		this.data = data; 
		this.leftChild = null; 
		this.rightSibling = null; 
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LCRSTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(LCRSTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public LCRSTreeNode<T> getRightSibling() {
		return rightSibling;
	}

	public void setRightSibling(LCRSTreeNode<T> rightSibling) {
		this.rightSibling = rightSibling;
	}

}


public class LCRSTree implements Tree<LCRSTreeNode<Object>>{
	private LCRSTreeNode<Object> root;

	public LCRSTree() {
		this.root  = null; 
	}
	public LCRSTree(LCRSTreeNode<Object> input){
		this.root = input; 
	}
	public static void main(String[] args) {
		LCRSTreeNode<Object> a_node = new LCRSTreeNode<Object>("A");
		LCRSTreeNode<Object> b_node  = new LCRSTreeNode<Object>("B");
		LCRSTreeNode<Object> c_node  = new LCRSTreeNode<Object>("C");
		LCRSTreeNode<Object> d_node  = new LCRSTreeNode<Object>("D");
		LCRSTreeNode<Object> e_node  = new LCRSTreeNode<Object>("E");
		LCRSTreeNode<Object> f_node  = new LCRSTreeNode<Object>("F");
		LCRSTreeNode<Object> g_node  = new LCRSTreeNode<Object>("G");
		LCRSTree myTree = new LCRSTree(a_node); 
		myTree.addChildNode(a_node, b_node);
		myTree.addChildNode(a_node, d_node);
		myTree.addChildNode(b_node, e_node);
		myTree.addChildNode(b_node, f_node);
		myTree.addChildNode(d_node, g_node);
		myTree.addNext(b_node, c_node);
		System.out.println(myTree.toString());
		System.out.println(myTree.getChild(a_node, 1).getData().toString());
		System.out.println(myTree.isLeaf(a_node));
		System.out.println(myTree.isLeaf(g_node));

	}

	public String toString(){
		return toString(getRoot(), 0); 
	}
	public String toString(LCRSTreeNode<Object> node, int depth){
		String result = "";
		for(int i=0; i <depth; i++){
			result += "  "; 
		}
		result += node.getData().toString() + "\n"; 

		if(node.getLeftChild() != null ){
			result += toString(node.getLeftChild(), depth+1); 
		}
		if(node.getRightSibling() != null){
			result += toString(node.getRightSibling(), depth); 
		}
		return result; 
	}

	@Override
	public LCRSTreeNode<Object> getRoot() {
		// TODO Auto-generated method stub
		return this.root; 
	} 


	@Override
	public int getDegree(LCRSTreeNode<Object> parent) {
		System.out.print(parent.getData().toString()+ "_getDegree : ");
		int cnt=1; 
		LCRSTreeNode<Object> x = parent; 
		LCRSTreeNode<Object> sibling = x.getRightSibling(); 
		while(sibling != null){
			cnt += 1; 
			sibling = sibling.getRightSibling(); 
		}
		System.out.println(cnt);
		return cnt;
	}
	public void addChildNode(LCRSTreeNode<Object> parent, LCRSTreeNode<Object> child) {
		LCRSTreeNode<Object> lastchild = parent.getLeftChild(); 
		if(lastchild == null){
			parent.setLeftChild(child);
		}else{
			while(lastchild.getRightSibling() != null){
				lastchild = lastchild.getRightSibling();  
			}
			lastchild.setRightSibling(child);
		}
	}

	public void addNext(LCRSTreeNode<Object> prev, LCRSTreeNode<Object> next) {
		LCRSTreeNode<Object> temp = prev.getRightSibling(); 
		next.setRightSibling(temp);
		prev.setRightSibling(next);
	}

	@Override
	public boolean isLeaf(LCRSTreeNode<Object> node) {
		return node.getLeftChild() == null;
	}

	@Override
	public LCRSTreeNode<Object> getChild(LCRSTreeNode<Object> parent, int index) {
		LCRSTreeNode<Object> node = parent.getLeftChild(); 
		for(int i = 0; i <index ; i++){
			node = node.getRightSibling(); 
		}
		return node; 
	}

}
